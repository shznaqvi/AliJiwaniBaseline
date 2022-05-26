package edu.aku.hassannaqvi.alijiwanibaseline.ui.sections;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.child;

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
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionCs2Binding;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionCs5Binding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.Child;

public class SectionCS5Activity extends AppCompatActivity {
    private static final String TAG = "SectionCS5Activity";
    ActivitySectionCs5Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_cs5);
        child.setCs5q01(MainApp.ageOfIndexChild < 2 ? "1" : "2");

        bi.setForm(child);

        if (MainApp.superuser)
            bi.btnContinue.setText("Review Next");

        db = MainApp.appInfo.dbHelper;
        setSupportActionBar(bi.toolbar);
        //populateSpinner(this);
        //if (MainApp.entryType == 1) formType();

    }

    private boolean updateDB() {
        if (MainApp.superuser) return true;

        int updcount = 0;
        try {
            updcount = db.updatesChildColumn(TableContracts.ChildTable.COLUMN_CS5, child.cS5toString());
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

        if (updateDB()) {
            Intent i;
            //      if (bi.h111a.isChecked()) {
            i = new Intent(this, SectionDS1Activity.class).putExtra("complete", true);
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