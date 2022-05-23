package edu.aku.hassannaqvi.alijiwanibaseline.ui.sections;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.pregnancy;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.wra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.alijiwanibaseline.R;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;
import edu.aku.hassannaqvi.alijiwanibaseline.database.DatabaseHelper;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionBs1bBinding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.Pregnancy;
import edu.aku.hassannaqvi.alijiwanibaseline.models.WRA;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.EndingActivity;

public class SectionBS1bActivity extends AppCompatActivity {

    private static final String TAG = "SectionBS1bActivity";
    ActivitySectionBs1bBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_bs1b);
        db = MainApp.appInfo.dbHelper;

        try {
            pregnancy = db.getPregByUUid(String.valueOf(++MainApp.preg_count));
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(MWRA): " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //if (pregnancy == null) pregnancy = new Pregnancy();
        bi.setForm(pregnancy);
        bi.sno.setText("Pregnancy: " + MainApp.preg_count + " of " + MainApp.wra.getBs1q6());
        pregnancy.setSno(String.valueOf(MainApp.preg_count));

        if (MainApp.superuser)
            bi.btnContinue.setText("Review Next");

        db = MainApp.appInfo.dbHelper;
        setSupportActionBar(bi.toolbar);

    }

    private boolean updateDB() {
        if (MainApp.superuser) return true;

        int updcount = 0;
        try {
            updcount = db.updatesPregnancyColumn(TableContracts.PregnancyTable.COLUMN_SB1, pregnancy.sB1toString());
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

    private boolean insertNewRecord() {
        if (!pregnancy.getUid().equals("") || MainApp.superuser) return true;
        MainApp.pregnancy.populateMeta();
        long rowId = 0;
        try {
            rowId = db.addPregnancy(pregnancy);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        pregnancy.setId(String.valueOf(rowId));
        if (rowId > 0) {
            pregnancy.setUid(pregnancy.getDeviceId() + pregnancy.getId());
            db.updatesPregnancyColumn(TableContracts.PregnancyTable.COLUMN_UID, pregnancy.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void btnContinue(View view) {
        if (!formValidation()) return;
        if (!insertNewRecord()) return;

        //if (!updateDB()) return;
        // saveDraft();
        if (updateDB()) {

            MainApp.pregnancy = new Pregnancy();
            finish();

            Intent i;
            if (MainApp.totalPreg > MainApp.preg_count) {
                i = new Intent(this, SectionBS1bActivity.class).putExtra("complete", true);
            } else {
                i = new Intent(this, SectionBS1cActivity.class).putExtra("complete", false);
            }

            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean formValidation() {

        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) {
            return false;
        }

        return true;

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
}