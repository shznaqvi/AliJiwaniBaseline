package edu.aku.hassannaqvi.alijiwanibaseline.adapters;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.adolListFemale;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.adolListMale;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.childList;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.mwraList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.aku.hassannaqvi.alijiwanibaseline.R;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;
import edu.aku.hassannaqvi.alijiwanibaseline.database.DatabaseHelper;
import edu.aku.hassannaqvi.alijiwanibaseline.models.FamilyMembers;
import edu.aku.hassannaqvi.alijiwanibaseline.models.Form;

/**
 * Created by hassan.naqvi on 8/1/2016.
 */
public class FormsAdapter extends RecyclerView.Adapter<FormsAdapter.ViewHolder> {
    private static final String TAG = "FormsAdapter";
    Context c;
    DatabaseHelper db;
    private List<Form> fc = Collections.emptyList();

    // Provide a suitable constructor (depends on the kind of dataset)
    public FormsAdapter(List<Form> fc, Context c) {
        this.fc = fc;
        this.c = c;
        Log.d("TAG:count", String.valueOf(getItemCount()));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pendingform_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        db = new DatabaseHelper(c);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        mwraList = new ArrayList<Integer>();
        adolListFemale = new ArrayList<Integer>();
        adolListMale = new ArrayList<Integer>();
        childList = new ArrayList<Integer>();

        try {
            MainApp.familyList = db.getMemberBYUID(fc.get(position).getUid());
            for (FamilyMembers fm : MainApp.familyList) {

                if (Integer.parseInt(fm.getHl6y()) < 5) {
                    MainApp.childList.add(Integer.parseInt(fm.getHl1()));
                    String motherSno = fm.getHl8(); // mother's line number from child
                    if (!motherSno.equals("") && !motherSno.equals("97") && !MainApp.mwraList.contains(Integer.parseInt(motherSno))) {

                        FamilyMembers mother = MainApp.familyList.get(Integer.parseInt(motherSno) - 1);

                        if (Integer.parseInt(mother.getHl6y()) < 50 && Integer.parseInt(mother.getHl6y()) >= 15) {
                            MainApp.mwraList.add(Integer.parseInt(motherSno));
                        }
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
            Toast.makeText(c, "JSONException (Family Members)" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        String iStatus = "Status  Unknown";
        int iColor = 0;
        switch (fc.get(position).getiStatus()) {
            case "1":
                iStatus = "Complete";
                iColor = Color.GREEN;
                break;
            case "2":
                iStatus = "No Respondent";
                iColor = Color.RED;
                break;
            case "3":
                iStatus = "Memebers Absent";
                iColor = Color.RED;
                break;
            case "4":
                iStatus = "Refused";
                iColor = Color.RED;
                break;
            case "5":
                iStatus = "Empty";
                iColor = Color.RED;
                break;
            case "6":
                iStatus = "Not Found";
                iColor = Color.RED;
                break;
            case "96":
                iStatus = "Other Reason";
                iColor = Color.RED;
                break;
            default:
                iStatus = "Open Form";
                iColor = Color.RED;
                break;

        }

        holder.hhno.setText(fc.get(position).getHhid());
        holder.psuCode.setText(fc.get(position).getPsuCode());

        holder.istatus.setText(iStatus);
        holder.fatherName.setText(fc.get(position).getAs1q09());
        holder.mwraCount.setText(mwraList.size() + "");
        holder.childCount.setText(childList.size() + "");
        holder.adolMaleCount.setText(adolListMale.size() + "");
        holder.adolFemaleCount.setText(adolListFemale.size() + "");

        holder.sysdate.setText(fc.get(position).getSysDate());
        holder.istatus.setTextColor(iColor);
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return fc.size();
    }

    private void editHousehold(int position) {
        MainApp.form = new Form();
        try {
            MainApp.form = db.getFormByPsuHHNo(fc.get(position).getPsuCode(), fc.get(position).getHhid());
        } catch (JSONException e) {
            Log.d(TAG, c.getString(R.string.hh_exists_form) + e.getMessage());
            Toast.makeText(c, c.getString(R.string.hh_exists_form) + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rv;
        public TextView sysdate;
        public TextView psuCode;
        public TextView hhno;
        public TextView istatus;
        public TextView mwraCount;
        public TextView childCount;
        public TextView adolMaleCount;
        public TextView adolFemaleCount;
        public TextView fatherName;
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);
//            rv = v.findViewById(R.id.FormsList);
            sysdate = v.findViewById(R.id.sysdate);
            psuCode = v.findViewById(R.id.psuCode);
            hhno = v.findViewById(R.id.hhno);
            istatus = v.findViewById(R.id.istatus);
            fatherName = v.findViewById(R.id.fathername);
            mwraCount = v.findViewById(R.id.mwraCount);
            childCount = v.findViewById(R.id.childCount);
            adolMaleCount = v.findViewById(R.id.adolMaleCount);
            adolFemaleCount = v.findViewById(R.id.adolFemaleCount);

        }


    }
}