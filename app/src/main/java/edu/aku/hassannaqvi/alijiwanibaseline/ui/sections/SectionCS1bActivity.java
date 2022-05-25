package edu.aku.hassannaqvi.alijiwanibaseline.ui.sections;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.childOfSelectedMWRAList;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.ecdInfo;

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
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionCs1bBinding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.ECDInfo;

public class SectionCS1bActivity extends AppCompatActivity {
    private static final String TAG = "SectionCS1Activity";
    ActivitySectionCs1bBinding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_cs1b);
        db = MainApp.appInfo.dbHelper;

        setupECD();

        if (MainApp.superuser)
            bi.btnContinue.setText("Review Next");

        db = MainApp.appInfo.dbHelper;
        setSupportActionBar(bi.toolbar);


    }

    private void setupECD() {
        if (ecdInfo == null) ecdInfo = new ECDInfo();
        Integer childSno = childOfSelectedMWRAList.get(0);
        String childName = MainApp.familyList.get(childSno - 1).getHl2();

        try {
            ecdInfo = db.getECInfoByUUid(childSno);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        if (ecdInfo.getUid().equals("")) {
            ecdInfo.setCs1q02c1(String.valueOf(childSno));
            ecdInfo.setCs1q02c1n(String.valueOf(childName));
            ecdInfo.setEcdNo(String.valueOf(childSno));
        }
        bi.setForm(ecdInfo);
    }

    private boolean insertNewRecord() {
        if (!ecdInfo.getUid().equals("") || MainApp.superuser) return true;
        ecdInfo.populateMeta();

        long rowId = 0;
        try {
            rowId = db.addEcdInfo(ecdInfo);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        ecdInfo.setId(String.valueOf(rowId));
        if (rowId > 0) {
            ecdInfo.setUid(ecdInfo.getDeviceId() + ecdInfo.getId());
            db.updatesECDColumn(TableContracts.ECDInfoTable.COLUMN_UID, ecdInfo.getUid());
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
            updcount = db.updatesECDColumn(TableContracts.ECDInfoTable.COLUMN_ECDINFO, ecdInfo.ecdInfotoString());
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
            //finish();
            if (checkECDComplete()){
                i = new Intent(this, SectionCS1cActivity.class).putExtra("complete", true);
            }else i = new Intent(this, SectionCS1bActivity.class).putExtra("complete", true);

            //      if (bi.h111a.isChecked()) {
           /* } else {
                i = new Intent(this, EndingActivity.class).putExtra("complete", false);
            }*/

            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkECDComplete(){

        childOfSelectedMWRAList.remove(0);
        finish();
        if (childOfSelectedMWRAList.size() > 0){
            return false;
        }else return true;

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