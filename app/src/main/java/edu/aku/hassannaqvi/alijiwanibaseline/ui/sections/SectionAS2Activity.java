package edu.aku.hassannaqvi.alijiwanibaseline.ui.sections;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.familyMember;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;

import edu.aku.hassannaqvi.alijiwanibaseline.R;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;
import edu.aku.hassannaqvi.alijiwanibaseline.database.DatabaseHelper;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionAs2Binding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.FamilyMembers;

public class SectionAS2Activity extends AppCompatActivity {
    private static final String TAG = "SectionAS2Activity";
    ActivitySectionAs2Binding bi;
    private DatabaseHelper db;
    private ArrayList<String> fatherNames;
    private ArrayList<String> fatherCodes;
    private ArrayList<String> motherNames;
    private ArrayList<String> motherCodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_as2);
        bi.setFamilymember(familyMember);
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;
        MainApp.familyMember.setHl1(String.valueOf(MainApp.memberCount + 1));
        bi.hl5y.setMaxvalue(Float.parseFloat(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
        bi.hl5y.setMinvalue(Float.parseFloat(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))) - 120);

        setupListener();
        populateSpinner();
        if (MainApp.superuser)
            bi.btnContinue.setText("Review Next");
    }

    private void setupListener() {
        bi.hl2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                bi.hl3name.setVisibility(View.VISIBLE);
                bi.hl3name.setText(getString(R.string.hl3t1) + " " + familyMember.getHl2() + " " + getString(R.string.hl3t2));
            }
        });
    }

    private void populateSpinner() {

        fatherNames = new ArrayList<>();
        fatherCodes = new ArrayList<>();

        motherNames = new ArrayList<>();
        motherCodes = new ArrayList<>();

        fatherNames.add("...");
        fatherCodes.add("...");
        for (FamilyMembers fl : MainApp.fatherList) {
            fatherNames.add(fl.getHl2());
            fatherCodes.add(fl.getHl1());
        }
        fatherNames.add(getResources().getString(R.string.notAvlDied));
        fatherCodes.add("97");

        motherNames.add("...");
        motherCodes.add("...");
        for (FamilyMembers fl : MainApp.motherList) {
            motherNames.add(fl.getHl2());
            motherCodes.add(fl.getHl1());
        }
        motherNames.add(getResources().getString(R.string.notAvlDied));
        motherCodes.add("97");

        // Apply the adapter to the Father spinner
        bi.hl9.setAdapter(new ArrayAdapter<>(SectionAS2Activity.this, R.layout.custom_spinner, fatherNames));

        bi.hl9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;
                MainApp.familyMember.setHl9(fatherCodes.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        // Apply the adapter to the Mother spinner
        bi.hl8.setAdapter(new ArrayAdapter<>(SectionAS2Activity.this, R.layout.custom_spinner, motherNames));

        bi.hl8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;
                MainApp.familyMember.setHl8(motherCodes.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });


    }


    private boolean insertNewRecord() {
        if (!familyMember.getUid().equals("") || MainApp.superuser) return true;
        MainApp.familyMember.populateMeta();

        long rowId = 0;
        try {
            rowId = db.addFamilyMembers(MainApp.familyMember);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.familyMember.setId(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.familyMember.setUid(MainApp.familyMember.getDeviceId() + MainApp.familyMember.getId());
            db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_UID, MainApp.familyMember.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean updateDB() {
        if (MainApp.superuser) return true;

        int updcount = 0;
        try {
            updcount = db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_SA2, MainApp.familyMember.sA2toString());
        } catch (JSONException e) {
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void btnContinue(View view) {
        if (!formValidation()) return;
        if (!insertNewRecord()) return;
        // saveDraft();

        //TODO: fix it in future
        if (Integer.parseInt(bi.hl6y.getText().toString().trim()) < 13) {
            familyMember.setHl7("99");
        }

        if (updateDB()) {
            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }


    public void btnEnd(View view) {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }
}