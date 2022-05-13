package edu.aku.hassannaqvi.alijiwanibaseline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;
import edu.aku.hassannaqvi.alijiwanibaseline.database.AndroidManager;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.FamilyMembers;
import edu.aku.hassannaqvi.alijiwanibaseline.models.Form;
import edu.aku.hassannaqvi.alijiwanibaseline.models.WRA;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.IdentificationActivity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.SyncActivity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.lists.FormsReportCluster;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.lists.FormsReportDate;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.lists.FormsReportPending;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.sections.ConsentActivity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.sections.SectionAS1Activity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.sections.SectionAS2Activity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.sections.SectionBS1Activity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.sections.SectionBS2Activity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.sections.SectionBS3Activity;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.app_icon);
        bi.adminView.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);
        bi.toolbar.setSubtitle("Welcome, " + MainApp.user.getFullname() + (MainApp.admin ? " (Admin)" : "") + "!");
        invalidateOptionsMenu();
    }

    public void sectionPress(View view) {


        switch (view.getId()) {
            case R.id.startInterview:
                MainApp.entryType = 1;
                break;
            case R.id.startDataEntry:
                MainApp.entryType = 2;
                break;
/*
            case R.id.updateBlood:
                MainApp.entryType = 3;
                break;

            case R.id.updateStool:
                MainApp.entryType = 4;
                break;*/
            default:
                MainApp.entryType = 0;

        }


        switch (view.getId()) {

            case R.id.startInterview:
            case R.id.startDataEntry:

                MainApp.form = new Form();
                startActivity(new Intent(this, IdentificationActivity.class));
                break;
        /*    case R.id.openAnthro:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionA2Activity.class));
                break;*/
            case R.id.seca1:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionAS1Activity.class));
                break;
            case R.id.seca2:
                MainApp.familyMember = new FamilyMembers();
                startActivity(new Intent(this, SectionAS2Activity.class));
                break;

            case R.id.secb1:
                MainApp.wra = new WRA();
                startActivity(new Intent(this, SectionBS1Activity.class));
                break;
            case R.id.secb2:
                startActivity(new Intent(this, SectionBS2Activity.class));
                break;
            case R.id.secb3:
                startActivity(new Intent(this, SectionBS3Activity.class));
                break;



            case R.id.con:
                MainApp.form = new Form();
                startActivity(new Intent(this, ConsentActivity.class));
                break;
            case R.id.dbManager:
                startActivity(new Intent(this, AndroidManager.class));
                break;


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_database:
                intent = new Intent(MainActivity.this, AndroidManager.class);
                startActivity(intent);
                break;
            case R.id.onSync:
                intent = new Intent(MainActivity.this, SyncActivity.class);
                startActivity(intent);
                break;
            case R.id.checkPendingForms:
                intent = new Intent(MainActivity.this, FormsReportPending.class);
                startActivity(intent);
                break;
            case R.id.formsReportDate:
                intent = new Intent(MainActivity.this, FormsReportDate.class);
                startActivity(intent);
                break;
            case R.id.formsReportCluster:
                intent = new Intent(MainActivity.this, FormsReportCluster.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        MenuItem action_database = menu.findItem(R.id.action_database);

        action_database.setVisible(MainApp.admin);
        return true;

    }

}