package edu.aku.hassannaqvi.alijiwanibaseline.ui.sections;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.util.Calendar;
import java.util.List;

import edu.aku.hassannaqvi.alijiwanibaseline.R;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;
import edu.aku.hassannaqvi.alijiwanibaseline.database.DatabaseHelper;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionAs1Binding;

public class SectionAS1Activity extends AppCompatActivity {
    private static final String TAG = "SectionAS1Activity";
    ActivitySectionAs1Binding bi;
    private List<String> countryCode, provinceCode, districtCode, villageCode;
    private List<String> countryName, provinceName, districtName, villageName;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_as1);
        bi.setForm(form);
        if (!MainApp.superuser) {
            form.setAs1q18(MainApp.user.getFullname());
        } else {
            form.setAs1q19(MainApp.user.getFullname());
            bi.btnContinue.setText("Review Next");
        }
        db = MainApp.appInfo.dbHelper;
        setSupportActionBar(bi.toolbar);
        //populateSpinner(this);
        if (MainApp.entryType == 1) formType();


    }


    private boolean insertNewRecord() {
        if (!MainApp.form.getUid().equals("") || MainApp.superuser) return true;

        MainApp.form.populateMeta();

        long rowId = 0;
        try {
            rowId = db.addForm(MainApp.form);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.form.setId(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.form.setUid(MainApp.form.getDeviceId() + MainApp.form.getId());
            db.updatesFormColumn(TableContracts.FormsTable.COLUMN_UID, MainApp.form.getUid());
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
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SA1, MainApp.form.sA1toString());
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
        if (updateDB()) {
            Intent i;
            //      if (bi.h111a.isChecked()) {
            i = new Intent(this, ConsentActivity.class).putExtra("complete", true);
           /* } else {
                i = new Intent(this, EndingActivity.class).putExtra("complete", false);
            }*/

            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    @Override
    public void onBackPressed() {
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
    }

    public void btnEnd(View view) {
        finish();
        //startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
        //startActivity(new Intent(this, MainActivity.class));
    }

    public void formType() {
        bi.Grp1.setVisibility(View.GONE);
        bi.fldGrpCVas1q17.setVisibility(View.GONE);
        bi.Grp2.setVisibility(View.GONE);
        bi.as1q15y.setEnabled(false);
        bi.as1q15m.setEnabled(false);
        bi.as1q15d.setEnabled(false);
        bi.as1q16h.setEnabled(false);
        bi.as1q16m.setEnabled(false);
        bi.as1q18.setEnabled(false);
        MainApp.form.setAs1q15y(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        MainApp.form.setAs1q15m(String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1));
        MainApp.form.setAs1q15d(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
        MainApp.form.setAs1q16h(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
        MainApp.form.setAs1q16m(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)));
        MainApp.form.setAs1q18(MainApp.user.getFullname());
    }


}