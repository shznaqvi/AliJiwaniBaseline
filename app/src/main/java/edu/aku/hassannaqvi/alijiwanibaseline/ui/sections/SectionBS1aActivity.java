package edu.aku.hassannaqvi.alijiwanibaseline.ui.sections;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.wra;
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
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionBs1aBinding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.WRA;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.EndingActivity;

public class SectionBS1aActivity extends AppCompatActivity {
    private static final String TAG = "SectionBS1aActivity";
    ActivitySectionBs1aBinding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_bs1a);
        db = MainApp.appInfo.dbHelper;

        try {
            wra = db.getWraByUUID();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(MWRA): " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        if (wra == null) wra = new WRA();
        bi.setForm(wra);

        wra.setBs1respline(MainApp.familyList.get(Integer.parseInt(MainApp.selectedMWRA)).getHl1());
        wra.setBs1resp(MainApp.familyList.get(Integer.parseInt(MainApp.selectedMWRA)).getHl2());

        if (MainApp.superuser)
            bi.btnContinue.setText("Review Next");

        db = MainApp.appInfo.dbHelper;
        setSupportActionBar(bi.toolbar);
        //populateSpinner(this);
        if (MainApp.entryType == 1) formType();

    }

    private boolean insertNewRecord() {
        if (!wra.getUid().equals("") || MainApp.superuser) return true;
        wra.populateMeta();

        long rowId = 0;
        try {
            rowId = db.addWra(wra);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        wra.setId(String.valueOf(rowId));
        if (rowId > 0) {
            wra.setUid(wra.getDeviceId() + wra.getId());
            db.updatesWraColumn(TableContracts.WRATable.COLUMN_UID, wra.getUid());
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
            updcount = db.updatesWraColumn(TableContracts.WRATable.COLUMN_SB1, wra.sB1toString());
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
            if (bi.bs1con1.isChecked()) {

                MainApp.preg_count = 0;
                MainApp.totalPreg = Integer.parseInt(MainApp.wra.getBs1q6());

                if (MainApp.wra.getBs1q2().equals("1")) {
                    MainApp.totalPreg--;
                }
                i = new Intent(this, SectionBS1bActivity.class).putExtra("complete", true);
           } else {
                i = new Intent(this, EndingActivity.class).putExtra("complete", false);
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

        int bs1q3 = Integer.parseInt(wra.getBs1q3());
        int bs1q6 = Integer.parseInt(wra.getBs1q6());

        if (bs1q6 > bs1q3)
            return Validator.emptyCustomTextBox(this, bi.bs1q6, "Number of pregnancies could not be greater than total pregnancies in Bs1q3");

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

    public void formType() {

    }


}