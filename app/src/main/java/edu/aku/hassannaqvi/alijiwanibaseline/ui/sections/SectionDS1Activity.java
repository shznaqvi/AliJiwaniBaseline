package edu.aku.hassannaqvi.alijiwanibaseline.ui.sections;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.child;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.mother;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.selectedChild;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.selectedChildName;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.alijiwanibaseline.R;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;
import edu.aku.hassannaqvi.alijiwanibaseline.database.DatabaseHelper;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionCs5Binding;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionDs1Binding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.Child;
import edu.aku.hassannaqvi.alijiwanibaseline.models.Mother;

public class SectionDS1Activity extends AppCompatActivity {
    private static final String TAG = "SectionDS1Activity";
    ActivitySectionDs1Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_ds1);
        db = MainApp.appInfo.dbHelper;

        try {
            mother = db.getMotherByUUID();
            //mother.notifyChange();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(MotherKAP): " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        if (mother.getUid().equals("")) {
            mother.setDs1q01(selectedChildName);
            mother.setDs1q02("" + (Integer.parseInt(selectedChild) + 1));
        }
        bi.setForm(mother);
        if (MainApp.superuser)
            bi.btnContinue.setText("Review Next");

        if (MainApp.mother == null) mother = new Mother();
        bi.setForm(mother);

        db = MainApp.appInfo.dbHelper;
        setSupportActionBar(bi.toolbar);
        //populateSpinner(this);
        //if (MainApp.entryType == 1) formType();

    }

    private boolean insertNewRecord() {
        if (!mother.getUid().equals("") || MainApp.superuser) return true;

        mother.populateMeta();

        long rowId = 0;
        try {
            rowId = db.addMother(mother);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        mother.setId(String.valueOf(rowId));
        if (rowId > 0) {
            mother.setUid(mother.getDeviceId() + mother.getId());
            db.updatesMotherColumn(TableContracts.MotherTable.COLUMN_UID, mother.getUid());
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
            updcount = db.updatesMotherColumn(TableContracts.MotherTable.COLUMN_DS1, mother.dS1toString());
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
            i = new Intent(this, SectionDS2Activity.class).putExtra("complete", true);
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

    }


}