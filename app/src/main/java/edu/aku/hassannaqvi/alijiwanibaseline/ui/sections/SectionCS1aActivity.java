package edu.aku.hassannaqvi.alijiwanibaseline.ui.sections;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.child;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.childOfSelectedMWRAList;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.wra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.util.ArrayList;

import edu.aku.hassannaqvi.alijiwanibaseline.R;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;
import edu.aku.hassannaqvi.alijiwanibaseline.database.DatabaseHelper;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivitySectionCs1aBinding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.Child;
import edu.aku.hassannaqvi.alijiwanibaseline.models.FamilyMembers;

public class SectionCS1aActivity extends AppCompatActivity {
    private static final String TAG = "SectionCS1Activity";
    ActivitySectionCs1aBinding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainApp.langRTL ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_cs1a);
        db = MainApp.appInfo.dbHelper;

        try {
            child = db.getChildByUUID();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        bi.setForm(child);

        child.setCs1q0101(wra.getBs1resp());
        child.setCs1q0102(wra.getBs1respline());

        if (MainApp.superuser)
            bi.btnContinue.setText("Review Next");

        db = MainApp.appInfo.dbHelper;
        setSupportActionBar(bi.toolbar);

      setSelectedChildList();


    }

    private void setSelectedChildList(){
        MainApp.childOfSelectedMWRAList = new ArrayList<>();

        for (FamilyMembers familyMember : MainApp.familyList){

            int motherNo = Integer.parseInt(familyMember.getHl8());

            // Doing +1 because, in mother drop down ... is added on 0th position
            int selectedMWRa = Integer.parseInt(MainApp.selectedMWRA) +1 ;

            if (motherNo ==  selectedMWRa && Integer.parseInt(familyMember.getHl6y()) < 5 ){
                childOfSelectedMWRAList.add(Integer.valueOf(familyMember.getHl1()));
            }
        }

        child.setCs1q02(String.valueOf(childOfSelectedMWRAList.size()));

    }

    private boolean insertNewRecord() {

        if (!child.getUid().equals("") || MainApp.superuser) return true;
        child.populateMeta();

        long rowId = 0;
        try {
            rowId = db.addChild(child);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        child.setId(String.valueOf(rowId));
        if (rowId > 0) {
            child.setUid(child.getDeviceId() + child.getId());
            db.updatesChildColumn(TableContracts.ChildTable.COLUMN_UID, child.getUid());
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
            updcount = db.updatesChildColumn(TableContracts.ChildTable.COLUMN_CS1, child.cS1toString());
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
            i = new Intent(this, SectionCS1bActivity.class).putExtra("complete", true);
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