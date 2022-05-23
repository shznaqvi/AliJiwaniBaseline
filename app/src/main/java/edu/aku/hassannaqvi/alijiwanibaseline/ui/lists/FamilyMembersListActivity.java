package edu.aku.hassannaqvi.alijiwanibaseline.ui.lists;

import static android.view.View.VISIBLE;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.adolListFemale;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.adolListMale;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.selectedChild;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.selectedChildName;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.util.ArrayList;

import edu.aku.hassannaqvi.alijiwanibaseline.R;
import edu.aku.hassannaqvi.alijiwanibaseline.adapters.FamilyMembersAdapter;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;
import edu.aku.hassannaqvi.alijiwanibaseline.database.DatabaseHelper;
import edu.aku.hassannaqvi.alijiwanibaseline.databinding.ActivityFamilyListBinding;
import edu.aku.hassannaqvi.alijiwanibaseline.models.FamilyMembers;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.EndingActivity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.sections.SectionAS2Activity;
import edu.aku.hassannaqvi.alijiwanibaseline.ui.sections.SectionBS1aActivity;


public class FamilyMembersListActivity extends AppCompatActivity {


    private static final String TAG = "MwraActivity";
    private final boolean selectionCheck = false;
    ActivityFamilyListBinding bi;
    DatabaseHelper db;
    private FamilyMembersAdapter familyMembersAdapter;
    ActivityResultLauncher<Intent> MemberInfoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK && !MainApp.superuser) {
                        // There are no request codes
                        //Intent data = result.getData();
                        Intent data = result.getData();
                      /*  int age = Integer.parseInt(femalemembers.getHh05y());
                        boolean isFemale = femalemembers.getHh03().equals("2");
                        boolean notMarried = femalemembers.getHh06().equals("2");
                        if (
                            // Adolescent: Male + Female - 10 to 19
                                (age >= 10 && age < 20 && notMarried)
                                        ||
                                        // MWRA: Married females between 14 to 49
                                        (age >= 14 && age < 50 && !notMarried && isFemale )

                        ) {*/
                        MainApp.familyList.add(MainApp.familyMember);
                        MainApp.hhheadSelected = MainApp.familyMember.getHl3().equals("1");
                        //  memGender = MainApp.familyMember.getA204();
                        // boolean memAgeCheck = Integer.parseInt(MainApp.familyMember.getA206()) > 18;
                        if (!MainApp.familyMember.getHl7().equals("") && !MainApp.familyMember.getHl7().equals("5") && !MainApp.familyMember.getHl7().equals("99")) {
                            switch (MainApp.familyMember.getHl4()) {
                                case "1":
                                    MainApp.fatherList.add(MainApp.familyMember);
                                    //MainApp.mwraCount++;
                                    break;
                                case "2":
                                    MainApp.motherList.add(MainApp.familyMember);
                                    //MainApp.adolCount++;
                                    break;

                            }
                        }
                        /** populateMothersList
                         *      Familymember has a value in mothers Serial Number (HL8)
                         *      Mother not already exists in the MWRA List
                         */
                        String motherSno = MainApp.familyMember.getHl8();
                        if (Integer.parseInt(MainApp.familyMember.getHl6y()) < 5 && MainApp.familyMember.getHl10().equals("1")
                                && !motherSno.equals("")
                                && !motherSno.equals("97")
                                && !MainApp.mwraList.contains(Integer.parseInt(motherSno))

                        ) {
                            FamilyMembers mother = MainApp.familyList.get(Integer.parseInt(motherSno) - 1);
                            /**
                             * Mother is present
                             * Mother's age is between 15 - 49
                             */
                            if (mother.getHl10().equals("1") && Integer.parseInt(mother.getHl6y()) >= 15 && Integer.parseInt(mother.getHl6y()) < 50) {
                                MainApp.mwraList.add(Integer.parseInt(motherSno));
                            }
                        }

                        /** Populate Adolescent:
                         *                      Age:    15-19,
                         *           Marital Status:    unmarried or 99,
                         *      Availability Status:    Present
                         */
                        if (
                                Integer.parseInt(MainApp.familyMember.getHl6y()) >= 15 && Integer.parseInt(MainApp.familyMember.getHl6y()) <= 19   // 10 - 19 year old
                                        && (MainApp.familyMember.getHl7().equals("5") || MainApp.familyMember.getHl7().equals("99")) && MainApp.familyMember.getHl10().equals("1")

                        ) {

                            /** Populate Adolescent Male
                             *      Gender: Male
                             */
                            if (MainApp.familyMember.getHl4().equals("1"))
                                adolListMale.add(Integer.valueOf(MainApp.familyMember.getHl1()));

                            /** Populate Adolescent Female
                             *      Gender: Female
                             */
                            if (MainApp.familyMember.getHl4().equals("2"))
                                adolListFemale.add(Integer.valueOf(MainApp.familyMember.getHl1()));
                        }


/*                        // Populate lists for MWRA and ADOL
                        if (!MainApp.familyMembers.getMemCate().equals("")) {
                            switch (MainApp.familyMembers.getMemCate()) {

                              //MWRA List
                                case "1":
                                    MainApp.mwraList.add(MainApp.familyMembers);
                                    MainApp.mwraCount++;
                                    break;

                                    //
                                case "2":
                                    MainApp.adolList.add(MainApp.familyMembers);
                                    MainApp.adolCount++;
                                    break;
                                case "3":
                                    MainApp.maleList.add(MainApp.familyMembers);
                                    MainApp.maleCount++;
                                    break;
                            }

                        }*/


                        MainApp.memberCount++;
                        familyMembersAdapter.notifyItemInserted(MainApp.familyList.size() - 1);
                        //  Collections.sort(MainApp.fm, new SortByStatus());
                        //fmAdapter.notifyDataSetChanged();

                        //        }
                        checkCompleteFm();
                    }
                    if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        Toast.makeText(FamilyMembersListActivity.this, "No family member added.", Toast.LENGTH_SHORT).show();
                    }

                }
            });
    private ArrayList<String> motherNames, childNames, adolMaleNames, adolFemaleNames;
    private ArrayList<String> motherSno, childSno, adolMaleSno, adolFemaleSno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_mwra);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_family_list);
        bi.setCallback(this);
        if (MainApp.superuser)
            bi.btnContinue.setText("Review Next");
        db = MainApp.appInfo.dbHelper;
        MainApp.familyList = new ArrayList<>();
        MainApp.mwraList = new ArrayList<Integer>();
        adolListFemale = new ArrayList<Integer>();
        adolListMale = new ArrayList<Integer>();
        MainApp.adolListAll = new ArrayList<>();
        MainApp.fatherList = new ArrayList<>();
        MainApp.motherList = new ArrayList<>();
        Log.d(TAG, "onCreate: familyList " + MainApp.familyList.size());
        try {
            MainApp.familyList = db.getMemberBYUID(MainApp.form.getUid());
            int fmCount = 0;
            for (FamilyMembers fm : MainApp.familyList) {
                fmCount++;
                if (!fm.getHl7().equals("5") && !fm.getHl7().equals("99")) {

                    switch (fm.getHl4()) {
                        case "1":
                            MainApp.fatherList.add(fm);
                            //MainApp.mwraCount++;
                            break;
                        case "2":
                            MainApp.motherList.add(fm);
                            //MainApp.adolCount++;
                            break;

                    }
                }

                // Populate mothers' list
                String motherSno = fm.getHl8(); // mother's line number from child
                if (Integer.parseInt(fm.getHl6y()) < 5 && fm.getHl10().equals("1") &&
                        !motherSno.equals("") && !motherSno.equals("97") && !MainApp.mwraList.contains(Integer.parseInt(motherSno))) {
                    // MainApp.mwraList.add(Integer.parseInt(motherSno));
                    FamilyMembers mother = MainApp.familyList.get(Integer.parseInt(motherSno) - 1);

                    if (mother.getHl10().equals("1") && Integer.parseInt(mother.getHl6y()) < 50 && Integer.parseInt(mother.getHl6y()) >= 15) {
                        MainApp.mwraList.add(Integer.parseInt(motherSno));
                    }
                }

                // Populate Adolescent
                if (
                        Integer.parseInt(fm.getHl6y()) >= 10 && Integer.parseInt(fm.getHl6y()) <= 19   // 10 - 19 year old
                                && (fm.getHl7().equals("5") || fm.getHl7().equals("99"))

                ) {
                    // Male
                    if (fm.getHl4().equals("1"))
                        adolListMale.add(Integer.valueOf(fm.getHl1()));
                    // Female
                    if (fm.getHl4().equals("2"))
                        adolListFemale.add(Integer.valueOf(fm.getHl1()));
                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(FamilyMembers): " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        MainApp.selectedMWRA = "";
        MainApp.selectedChild = "";
        MainApp.selectedChildName = "";
        MainApp.selectedAdolMale = "";
        MainApp.selectedAdolFemale = "";

        // Set Selected Members
        for (int i = 0; i < MainApp.familyList.size(); i++) {

            // Set Mother
            if (MainApp.familyList.get(i).getIndexed().equals("1")) {
                MainApp.selectedMWRA = String.valueOf(i);
                bi.btnRand.setVisibility(View.INVISIBLE);
                //bi.btnContinue.setVisibility(View.VISIBLE);
                bi.btnContinue.setEnabled(true);
                bi.btnContinue.setBackground(getResources().getDrawable(R.drawable.button_shape_green));
                // break;
            }

            // Set Child
            if (MainApp.familyList.get(i).getIndexed().equals("2")) {
                MainApp.selectedChild = String.valueOf(i);
                selectedChildName = MainApp.familyList.get(i).getHl2();
                MainApp.ageOfIndexChild = Integer.parseInt(MainApp.familyList.get(i).getHl6y());
            }
            // Set AdolMale
            if (MainApp.familyList.get(i).getIndexed().equals("3"))
                MainApp.selectedAdolMale = String.valueOf(i);
            // Set AdolFemale
            if (MainApp.familyList.get(i).getIndexed().equals("4"))
                MainApp.selectedAdolFemale = String.valueOf(i);


            MainApp.hhheadSelected = MainApp.familyList.get(i).getHl3().equals("1");

        }

        bi.btnContinue.setEnabled(!MainApp.selectedMWRA.equals(""));
        bi.btnContinue.setBackground(!MainApp.selectedMWRA.equals("") ? getResources().getDrawable(R.drawable.button_shape_green) : getResources().getDrawable(R.drawable.button_shape_gray));

        //bi.btnContinue.setVisibility(!MainApp.selectedMWRA.equals("") ? View.VISIBLE : View.INVISIBLE);
        MainApp.memberCount = Math.round(MainApp.familyList.size());

        familyMembersAdapter = new FamilyMembersAdapter(this, MainApp.familyList);
        bi.rvMwra.setAdapter(familyMembersAdapter);
        bi.rvMwra.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainApp.superuser) {
                    Toast.makeText(FamilyMembersListActivity.this, "Supervisors cannot add new members.", Toast.LENGTH_LONG).show();

                } else if (MainApp.selectedMWRA.equals("")) {
                    //     Toast.makeText(MwraActivity.this, "Opening Mwra Form", Toast.LENGTH_LONG).show();
                    MainApp.familyMember = new FamilyMembers();
                    addFemale();
                } else {
                    Toast.makeText(FamilyMembersListActivity.this, "This form has been locked. You cannot add new family member to locked forms", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity Resumed!", Toast.LENGTH_SHORT).show();

        // Family Complete criteria: MWRA must exist
        if (MainApp.mwraList.size() > 0) {
            bi.familyComplete.setVisibility(VISIBLE);

        } else {
            bi.familyComplete.setVisibility(View.GONE);

        }

        // Disable family complete check if MWRA indexed
        if (!MainApp.selectedMWRA.equals("")) {
            bi.familyComplete.setChecked(true);
            bi.familyComplete.setEnabled(false);
        }
        //MainApp.familyMember = new MWRA();
        //MainApp.child = new Child();
/*        if (MainApp.mwraList.size() > 0 && MainApp.selectedMWRA.equals("")) {
            //MainApp.fm.get(Integer.parseInt(String.valueOf(MainApp.selectedMWRA))).setStatus("1");
            bi.btnRand.setVisibility(View.VISIBLE);
            // bi.btnContinue.setVisibility(View.INVISIBLE);
            bi.btnContinue.setEnabled(false);
            bi.btnContinue.setBackground(getResources().getDrawable(R.drawable.button_shape_gray));

        } else {
            bi.btnRand.setVisibility(View.INVISIBLE);
            // bi.btnContinue.setVisibility(View.VISIBLE);
            bi.btnContinue.setEnabled(true);
            bi.btnContinue.setBackground(getResources().getDrawable(R.drawable.button_shape_green));

        }*/
        checkCompleteFm();


        // bi.fab.setClickable(!MainApp.form.getiStatus().equals("1"));
      /* bi.completedmember.setText(mwra.size()+ " MWRAs added");
        bi.totalmember.setText(MainApp.familyMemberTotal+ " M completed");*/
    }


    private void checkCompleteFm() {
        //     if (!MainApp.form.getIStatus().equals("1")) {
        int compCount = MainApp.familyList.size();

        MainApp.memberCountComplete = compCount;
        //   bi.btnContinue.setVisibility(compCount == memberCount && !form.getiStatus().equals("1")? View.VISIBLE : View.GONE);
     /*   bi.btnContinue.setVisibility(compCount >= memberCount ? View.VISIBLE : View.GONE);
        bi.btnContinue.setEnabled(bi.btnContinue.getVisibility()==View.VISIBLE);*/

        //  } else {
        //       Toast.makeText(this, "Form has been completed or locked", Toast.LENGTH_LONG).show();
        //   }

        /*MainApp.childOfSelectedMWRAList = new ArrayList<>();
        for (FamilyMembers fm : MainApp.familyList) {
            if (fm.getHl8().equals("2")) {
                MainApp.childOfSelectedMWRAList.add(Integer.parseInt(fm.getHl1()));
            }
        }

        String kishGridChild = MainApp.kishGrid(Integer.parseInt(MainApp.form.getEcdNo()), MainApp.childOfSelectedMWRAList.size());
        int indx = MainApp.childOfSelectedMWRAList.get(Integer.parseInt(kishGridChild));
        MainApp.selectedMWRA = String.valueOf(indx - 1);
        MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedMWRA));
        db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "1");

        // Updating adapter
        MainApp.familyList.get(Integer.parseInt(MainApp.selectedMWRA)).setIndexed("1");

        familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedMWRA));

        // Select Child using KishGrid
        MainApp.childOfSelectedMWRAList = new ArrayList<>();
        for (FamilyMembers fm : MainApp.familyList) {
            if (fm.getHl8().equals(MainApp.familyMember.getHl1())) {
                MainApp.childOfSelectedMWRAList.add(Integer.parseInt(fm.getHl1()));
            }
        }*/
    }

    public void addFemale() {
        addMoreMember();

      /*  if (MainApp.familyList.size() >= Integer.parseInt(MainApp.form.getH220b())) {
            displayAddMoreDialog();
        } else {
            addMoreMWRA();

        }*/
    }

    public void btnContinue(View view) {

        try {
            MainApp.familyMember = db.getSelectedMemberBYUID(MainApp.form.getUid());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(FamilyMembers): " + e.getMessage(), Toast.LENGTH_LONG).show();

        }
        finish();

        // TODO: fix error
        startActivity(new Intent(this, MainApp.selectedMWRA.equals("") ? EndingActivity.class : SectionBS1aActivity.class).putExtra("complete", true));


    }

    private void proceedSelect() {

        String hhno = MainApp.form.getSno().substring(MainApp.form.getSno().length() - 1);
        // Select Index Mother using KishGrid
        String kishGridMWRA = MainApp.kishGrid(Integer.parseInt(hhno), MainApp.mwraList.size());
        int sno = MainApp.mwraList.get(Integer.parseInt(kishGridMWRA));

        // Updating database to mark indexed mother
        MainApp.selectedMWRA = String.valueOf(sno - 1);
        MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedMWRA));
        db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "1");

        // Updating adapter
        MainApp.familyList.get(Integer.parseInt(MainApp.selectedMWRA)).setIndexed("1");
        familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedMWRA));


        // Select Child using KishGrid
        MainApp.childOfSelectedMWRAList = new ArrayList<>();
        for (FamilyMembers fm : MainApp.familyList) {
            if (fm.getHl8().equals(MainApp.familyMember.getHl1()) && fm.getHl10().equals("1") && Integer.parseInt(fm.getHl6y()) < 5) {
                MainApp.childOfSelectedMWRAList.add(Integer.parseInt(fm.getHl1()));
            }
        }

        String kishGridChild = MainApp.kishGrid(Integer.parseInt(hhno), MainApp.childOfSelectedMWRAList.size());
        sno = MainApp.childOfSelectedMWRAList.get(Integer.parseInt(kishGridChild));

        // Updating database to mark indexed mother
        MainApp.selectedChild = String.valueOf(sno - 1);
        selectedChildName = MainApp.familyList.get(Integer.parseInt(selectedChild)).getHl2();
        MainApp.ageOfIndexChild = Integer.parseInt(MainApp.familyList.get(Integer.parseInt(selectedChild)).getHl6y());
        MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedChild));
        db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "2");

        // Updating adapter
        MainApp.familyList.get(Integer.parseInt(MainApp.selectedChild)).setIndexed("2");
        familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedChild));


        // Select AdolMale using KishGrid
        if (adolListMale.size() > 0) {
            String kishGridAdolMale = MainApp.kishGrid(Integer.parseInt(hhno), adolListMale.size());
            sno = adolListMale.get(Integer.parseInt(kishGridAdolMale));

            // Updating database to mark selected adolmale
            MainApp.selectedAdolMale = String.valueOf(sno - 1);
            MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedAdolMale));
            db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "3");

            // Updating adapter
            MainApp.familyList.get(Integer.parseInt(MainApp.selectedAdolMale)).setIndexed("3");
            familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedAdolMale));
        }

        if (adolListFemale.size() > 0) {
            // Select AdolFemale using KishGrid
            String kishGridAdolFemale = MainApp.kishGrid(Integer.parseInt(hhno), adolListFemale.size());
            sno = adolListFemale.get(Integer.parseInt(kishGridAdolFemale));

            // Updating database to mark selected adolfemale
            MainApp.selectedAdolFemale = String.valueOf(sno - 1);
            MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedAdolFemale));
            db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "4");

            // Updating adapter
            MainApp.familyList.get(Integer.parseInt(MainApp.selectedAdolFemale)).setIndexed("4");
            familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedAdolFemale));
        }

        bi.btnRand.setVisibility(View.INVISIBLE);
        // bi.btnContinue.setVisibility(View.VISIBLE);
        bi.btnContinue.setEnabled(true);
        bi.btnContinue.setBackground(getResources().getDrawable(R.drawable.button_shape_green));
    }

  /*  private void displayAddMoreDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_mwra_dialog)
                .setMessage(String.format(getString(R.string.message_mwra_dialog_addmore), MainApp.form.getH220b()))

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.h111a, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        addMoreMember();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.h111b, null)
                .setIcon(R.drawable.ic_alert_24)
                .show();

    }

    private void displayProceedDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_mwra_dialog)
                .setMessage(String.format(getString(R.string.message_mwra_dialog_proceeed), MainApp.familyList.size() + "", MainApp.form.getH220b()))

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.h111a, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        proceedSelect();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.h111b, null)
                .setIcon(R.drawable.ic_alert_24)
                .show();

    }*/

    private void addMoreMember() {
        MainApp.familyMember = new FamilyMembers();
        Intent intent = new Intent(this, SectionAS2Activity.class);
        //   finish();
        MemberInfoLauncher.launch(intent);
    }

    public void btnEnd(View view) {

        finish();
        // startActivity(new Intent(this, MainActivity.class));
        /*   } else {
               Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
           }*/
    }

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                //   mwra.get(selectedMWRA).setExpanded(false);
                checkCompleteFm();
                mwraAdapter.notifyItemChanged(selectedMWRA);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
                Toast.makeText(this, "Child for " + MainApp.familyList.get(selectedMWRA).getH221() + " was not added.", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    public void btnRand(View view) {
/*        if (MainApp.familyList.size() < Integer.parseInt(MainApp.form.getH220b())) {
            displayProceedDialog();
        } else {*/
        if (MainApp.mwraList.size() > 0 && MainApp.selectedMWRA.equals("")) {

            if (MainApp.entryType == 1) {
                proceedSelect();
            }
            if (MainApp.entryType == 2) {
                showSelect();
            }
        } else {
            bi.btnRand.setVisibility(VISIBLE);
        }
        /*       }*/
    }

    private void showSelect() {

        bi.selectionLists.setVisibility(VISIBLE);

        // Populate Mothers List
        if (MainApp.mwraList.size() > 0) {
            motherNames = new ArrayList<>();
            motherSno = new ArrayList<>();

            motherNames.add("...");
            motherSno.add("...");

            for (Integer m : MainApp.mwraList) {

                motherNames.add(MainApp.familyList.get(m - 1).getHl2());
                motherSno.add(MainApp.familyList.get(m - 1).getHl1());

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(FamilyMembersListActivity.this,
                    R.layout.custom_spinner, motherNames);

            bi.mwraList.setAdapter(adapter);

            bi.mwraList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    bi.childList.setAdapter(null);
                    if (position == 0) return;

                    MainApp.childOfSelectedMWRAList = new ArrayList<>();
                    for (FamilyMembers fm : MainApp.familyList) {
                        if (fm.getHl8().equals(motherSno.get(position)) && fm.getHl10().equals("1") && Integer.parseInt(fm.getHl6y()) < 5) {
                            MainApp.childOfSelectedMWRAList.add(Integer.parseInt(fm.getHl1()));
                        }
                    }

                    // Populate Childs List
                    if (MainApp.childOfSelectedMWRAList.size() > 0) {
                        childNames = new ArrayList<>();
                        childSno = new ArrayList<>();

                        childNames.add("...");
                        childSno.add("...");

                        for (Integer c : MainApp.childOfSelectedMWRAList) {

                            childNames.add(MainApp.familyList.get(c - 1).getHl2());
                            childSno.add(MainApp.familyList.get(c - 1).getHl1());

                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FamilyMembersListActivity.this,
                                R.layout.custom_spinner, childNames);

                        bi.childList.setAdapter(adapter);
                        bi.childDD.setVisibility(View.VISIBLE);

                    } else {
                        bi.childDD.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        } else {
            bi.motherDD.setVisibility(View.GONE);
        }


       /* // Populate Childs List
        if (MainApp.childOfSelectedMWRAList.size() > 0) {
            childNames = new ArrayList<>();
            childSno = new ArrayList<>();

            childNames.add("...");
            childSno.add("...");

            for (Integer c : MainApp.childOfSelectedMWRAList) {

                childNames.add(MainApp.familyList.get(c - 1).getHl2());
                childSno.add(MainApp.familyList.get(c - 1).getHl1());

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(FamilyMembersListActivity.this,
                    R.layout.custom_spinner, childNames);

            bi.childList.setAdapter(adapter);
        } else {
            bi.childDD.setVisibility(View.GONE);
        }*/

        // Populate AdolMales List
        if (adolListMale.size() > 0) {
            adolMaleNames = new ArrayList<>();
            adolMaleSno = new ArrayList<>();

            adolMaleNames.add("...");
            adolMaleSno.add("...");

            for (Integer am : adolListMale) {

                adolMaleNames.add(MainApp.familyList.get(am - 1).getHl2());
                adolMaleSno.add(MainApp.familyList.get(am - 1).getHl1());

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(FamilyMembersListActivity.this,
                    R.layout.custom_spinner, adolMaleNames);

            bi.adolMaleList.setAdapter(adapter);
        } else {
            bi.adolMaleDD.setVisibility(View.GONE);
        }

        // Populate AdolFemales List
        if (adolListFemale.size() > 0) {
            adolFemaleNames = new ArrayList<>();
            adolFemaleSno = new ArrayList<>();

            adolFemaleNames.add("...");
            adolFemaleSno.add("...");

            for (Integer af : adolListFemale) {

                adolFemaleNames.add(MainApp.familyList.get(af - 1).getHl2());
                adolFemaleSno.add(MainApp.familyList.get(af - 1).getHl1());

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(FamilyMembersListActivity.this,
                    R.layout.custom_spinner, adolFemaleNames);

            bi.adolFemaleList.setAdapter(adapter);
        } else {
            bi.adolFemaleDD.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK)

            // A213 is line number
            familyMembersAdapter.notifyItemInserted(Integer.parseInt(MainApp.familyMember.getHl8()) - 1);

    }

    public void finalizeFamily(View view) {
        if (bi.familyComplete.isChecked()) {
            if (MainApp.mwraList.size() > 0 && MainApp.selectedMWRA.equals("")) {
                //MainApp.fm.get(Integer.parseInt(String.valueOf(MainApp.selectedMWRA))).setStatus("1");
                bi.btnRand.setVisibility(VISIBLE);
                // bi.btnContinue.setVisibility(View.INVISIBLE);
                bi.btnContinue.setEnabled(false);
                bi.btnContinue.setBackground(getResources().getDrawable(R.drawable.button_shape_gray));

            } else {
                bi.btnRand.setVisibility(View.INVISIBLE);
                // bi.btnContinue.setVisibility(View.VISIBLE);
                bi.btnContinue.setEnabled(true);
                bi.btnContinue.setBackground(getResources().getDrawable(R.drawable.button_shape_green));
            }
        } else {
            bi.btnRand.setVisibility(View.INVISIBLE);
            bi.btnContinue.setEnabled(false);
            bi.btnContinue.setBackground(getResources().getDrawable(R.drawable.button_shape_gray));


            bi.mwraList.setAdapter(null);
            bi.childList.setAdapter(null);
            bi.adolFemaleList.setAdapter(null);
            bi.adolMaleList.setAdapter(null);
            bi.selectionLists.setVisibility(View.GONE);
        }
    }

    public void btnProceed(View view) {
        if (formValidation()) {
/*            if (MainApp.mwraList.size() > 0 && bi.mwraList.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Mother not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            if (MainApp.childOfSelectedMWRAList.size() > 0 && bi.childList.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Child not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            if (MainApp.adolListMale.size() > 0 && bi.adolMaleList.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Adolescent male not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            if (MainApp.adolListFemale.size() > 0 && bi.adolFemaleList.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Adolescent female not selected", Toast.LENGTH_SHORT).show();
                return;
            }*/

// MWRA
            // Updating database to mark indexed mother
            MainApp.selectedMWRA = String.valueOf(Integer.parseInt(motherSno.get(bi.mwraList.getSelectedItemPosition())) - 1);
            MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedMWRA));
            db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "1");

            // Updating adapter and notify MWRA selection
            MainApp.familyList.get(Integer.parseInt(MainApp.selectedMWRA)).setIndexed("1");
            familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedMWRA));

// CHILD
            // Updating database to mark selected Child
            MainApp.selectedChild = String.valueOf(Integer.parseInt(childSno.get(bi.childList.getSelectedItemPosition())) - 1);
            selectedChildName = MainApp.familyList.get(Integer.parseInt(selectedChild)).getHl2();
            MainApp.ageOfIndexChild = Integer.parseInt(MainApp.familyList.get(Integer.parseInt(selectedChild)).getHl6y());
            MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedChild));
            db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "2");

            // Updating adapter and notify Child selection
            MainApp.familyList.get(Integer.parseInt(MainApp.selectedChild)).setIndexed("2");
            familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedChild));

// ADOLESCENT MALE
            // Updating database to mark selected adolmale
            if (adolListMale.size() > 0) {
                MainApp.selectedAdolMale = String.valueOf(Integer.parseInt(adolMaleSno.get(bi.adolMaleList.getSelectedItemPosition())) - 1);
                MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedAdolMale));
                db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "3");

                // Updating adapter and notify Adolescent Male selection
                MainApp.familyList.get(Integer.parseInt(MainApp.selectedAdolMale)).setIndexed("3");
                familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedAdolMale));
            }

// ADOLESCENT FEMALE
            // Updating database to mark selected adolFemale
            if (adolListFemale.size() > 0) {
                MainApp.selectedAdolFemale = String.valueOf(Integer.parseInt(adolFemaleSno.get(bi.adolFemaleList.getSelectedItemPosition())) - 1);
                MainApp.familyMember = MainApp.familyList.get(Integer.parseInt(MainApp.selectedAdolFemale));
                db.updatesfamilyListColumn(TableContracts.FamilyMembersTable.COLUMN_INDEXED, "4");

                // Updating adapter and notify Adolescent Female selection
                MainApp.familyList.get(Integer.parseInt(MainApp.selectedAdolFemale)).setIndexed("4");
                familyMembersAdapter.notifyItemChanged(Integer.parseInt(MainApp.selectedAdolFemale));
            }
            bi.selectionLists.setVisibility(View.GONE);
            bi.familyComplete.setEnabled(false);
            bi.btnContinue.setEnabled(true);
            bi.btnRand.setVisibility(View.INVISIBLE);

            bi.btnContinue.setBackground(getResources().getDrawable(R.drawable.button_shape_green));


        }

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.selectionLists);
    }


}