package edu.aku.hassannaqvi.alijiwanibaseline.models;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp._EMPTY_;

import android.database.Cursor;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import edu.aku.hassannaqvi.alijiwanibaseline.BR;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts.FamilyMembersTable;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;


public class FamilyMembers extends BaseObservable implements Observable {

    private final String TAG = "Form";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = _EMPTY_;
    private String uid = _EMPTY_;
    private String uuid = _EMPTY_;
    private String userName = _EMPTY_;
    private String sysDate = _EMPTY_;
    private String psuCode = _EMPTY_;
    private String hhid = _EMPTY_;
    private String sno = _EMPTY_;
    private String deviceId = _EMPTY_;
    private String deviceTag = _EMPTY_;
    private String appver = _EMPTY_;
    private String endTime = _EMPTY_;
    private String iStatus = _EMPTY_;
    private String iStatus96x = _EMPTY_;
    private String synced = _EMPTY_;
    private String syncDate = _EMPTY_;


    // SECTION VARIABLES
    private String sA2 = _EMPTY_;

    // FIELD VARIABLES
    private String hl1 = _EMPTY_;
    private String hl2 = _EMPTY_;
    private String hl3 = _EMPTY_;
    private String hl4 = _EMPTY_;
    private String hl5d = _EMPTY_;
    private String hl5m = _EMPTY_;
    private String hl5y = _EMPTY_;
    private String hl6y = _EMPTY_;
    private String hl6m = _EMPTY_;
    private String hl7 = _EMPTY_;
    private String hl8 = _EMPTY_;
    private String hl9 = _EMPTY_;
    private String hl10 = _EMPTY_;
    private String hl11 = _EMPTY_;
    private String hl12 = _EMPTY_;
    private String hl1296x = _EMPTY_;
    private String hl13 = _EMPTY_;


    private boolean expanded;
    private boolean mwra;
    private long ageInMonths;
    private String indexed = _EMPTY_;
    private String memCate = _EMPTY_;

    public FamilyMembers() {


    }


    public void populateMeta() {

        setSysDate(MainApp.form.getSysDate());
        setUserName(MainApp.form.getUserName());
        setDeviceId(MainApp.form.getDeviceId());
        setUuid(MainApp.form.getUid());
        setAppver(MainApp.form.getAppver());
        setpsuCode(MainApp.form.getPsuCode());
        setHhid(MainApp.form.getHhid());
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Bindable
    public String getpsuCode() {
        return psuCode;
    }

    public void setpsuCode(String psuCode) {
        this.psuCode = psuCode;
    }

    @Bindable
    public String getHhid() {
        return hhid;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
    }

    @Bindable
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }


    public String getsA2() {
        return sA2;
    }

    public void setsA2(String sA2) {
        this.sA2 = sA2;
    }

/*
    public void setEcdNo(String sno) {
        this.sno = sno;
    }

    @Bindable
    public boolean isMwra() {
        return mwra;
    }
*/

    @Bindable
    public String getHl1() {
        return hl1;
    }

    public void setHl1(String hl1) {
        this.hl1 = hl1;
        this.sno = hl1;
        notifyPropertyChanged(BR.hl1);
    }

    @Bindable
    public String getHl2() {
        return hl2;
    }

    public void setHl2(String hl2) {
        this.hl2 = hl2;
        notifyPropertyChanged(BR.hl2);
    }

    @Bindable
    public String getHl3() {
        return hl3;
    }

    public void setHl3(String hl3) {
        this.hl3 = hl3;
        notifyPropertyChanged(BR.hl3);
    }

    @Bindable
    public String getHl4() {
        return hl4;
    }

    public void setHl4(String hl4) {
        this.hl4 = hl4;
        updateMemCategory();
        notifyPropertyChanged(BR.hl4);
    }

    @Bindable
    public String getHl5d() {
        return hl5d;
    }

    public void setHl5d(String hl5d) {
        this.hl5d = hl5d;
        CaluculateAge();
        notifyPropertyChanged(BR.hl5d);
    }

    @Bindable
    public String getHl5m() {
        return hl5m;
    }

    public void setHl5m(String hl5m) {
        this.hl5m = hl5m;
        if (hl5m.equals("98")) {
            setHl5d("98");
        }
        CaluculateAge();
        notifyPropertyChanged(BR.hl5m);
    }

    @Bindable
    public String getHl5y() {
        return hl5y;
    }

    public void setHl5y(String hl5y) {
        this.hl5y = hl5y;
        if (hl5y.equals("9998")) {
            setHl5m("98");
            setHl6m("");
            setHl6y("");
        }
        // Calculate age
        CaluculateAge();
        notifyPropertyChanged(BR.hl5y);
    }

    @Bindable
    public String getHl6y() {
        return hl6y;
    }

    public void setHl6y(@NonNull String hl6y) {
        this.hl6y = hl6y;
        setHl7(hl6y.length() > 0 ? Integer.parseInt(hl6y) < 13 ? "" : this.hl7 : this.hl7);
        setHl11(hl6y.length() > 0 ? Integer.parseInt(hl6y) < 3 ? "" : this.hl11 : this.hl11);
        setHl12(hl6y.length() > 0 ? Integer.parseInt(hl6y) < 10 ? "" : this.hl12 : this.hl12);
        updateMemCategory();

        notifyPropertyChanged(BR.hl6y);
    }

    @Bindable
    public String getHl6m() {
        return hl6m;
    }

    public void setHl6m(String hl6m) {
        this.hl6m = hl6m;
        notifyPropertyChanged(BR.hl6m);
    }

    @Bindable
    public String getHl7() {
        return hl7;
    }

    public void setHl7(String hl7) {
        this.hl7 = hl7;
//        setHl7(hl7.equals("") ? "99" : this.hl7);
        updateMemCategory();

        notifyPropertyChanged(BR.hl7);
    }

    @Bindable
    public String getHl8() {
        return hl8;
    }

    public void setHl8(String hl8) {
        this.hl8 = hl8;
        updateMemCategory();
        notifyPropertyChanged(BR.hl8);
    }

    @Bindable
    public String getHl9() {
        return hl9;
    }

    public void setHl9(String hl9) {
        this.hl9 = hl9;
        notifyPropertyChanged(BR.hl9);
    }

    @Bindable
    public String getHl10() {
        return hl10;
    }

    public void setHl10(String hl10) {
        this.hl10 = hl10;
        updateMemCategory();
        notifyPropertyChanged(BR.hl10);
    }

    @Bindable
    public String getHl11() {
        return hl11;
    }

    public void setHl11(String hl11) {
        this.hl11 = hl11;
        notifyPropertyChanged(BR.hl11);
    }

    @Bindable
    public String getHl12() {
        return hl12;
    }

    public void setHl12(String hl12) {
        this.hl12 = hl12;
        setHl1296x(hl12.equals("96") ? this.hl1296x : "");
        notifyPropertyChanged(BR.hl12);
    }

    @Bindable
    public String getHl1296x() {
        return hl1296x;
    }

    public void setHl1296x(String hl1296x) {
        this.hl1296x = hl1296x;
        notifyPropertyChanged(BR.hl1296x);
    }

    @Bindable
    public String getHl13() {
        return hl13;
    }

    public void setHl13(String hl13) {
        this.hl13 = hl13;
        notifyPropertyChanged(BR.hl13);
    }

    @Bindable
    public boolean isMwra() {
        return mwra;
    }

    public void setMwra(boolean mwra) {
        this.mwra = mwra;

        notifyPropertyChanged(BR.mwra);
    }

    public String getMemCate() {
        return memCate;
    }

    public void setMemCate(String memCate) {
        this.memCate = memCate;
        // notifyPropertyChanged(BR.memCate);
    }

    @Bindable
    public String getIndexed() {
        return indexed;
    }

    public void setIndexed(String Indexed) {
        this.indexed = Indexed;
        notifyPropertyChanged(BR.indexed);
    }

    public FamilyMembers Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_UUID));
        this.projectName = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_PROJECT_NAME));
        this.psuCode = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_PSU_CODE));
        this.hhid = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_HHID));
        this.sno = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_SNO));
        this.indexed = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_INDEXED));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_SYNCED_DATE));

        sA2Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(FamilyMembersTable.COLUMN_SA2)));
        updateMemCategory();

        return this;
    }

    public void sA2Hydrate(String string) throws JSONException {
        Log.d(TAG, "sA2Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.hl1 = json.getString("hl1");
            this.hl2 = json.getString("hl2");
            this.hl3 = json.getString("hl3");
            this.hl4 = json.getString("hl4");
            this.hl5d = json.getString("hl5d");
            this.hl5m = json.getString("hl5m");
            this.hl5y = json.getString("hl5y");
            this.hl6y = json.getString("hl6y");
            this.hl6m = json.getString("hl6m");
            this.hl7 = json.getString("hl7");
            this.hl8 = json.getString("hl8");
            this.hl9 = json.getString("hl9");
            this.hl10 = json.getString("hl10");
            this.hl11 = json.getString("hl11");
            this.hl12 = json.getString("hl12");
            this.hl1296x = json.getString("hl1296x");
            this.hl13 = json.getString("hl13");
        }
    }


    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(FamilyMembersTable.COLUMN_ID, this.id);
        json.put(FamilyMembersTable.COLUMN_UID, this.uid);
        json.put(FamilyMembersTable.COLUMN_UUID, this.uuid);
        json.put(FamilyMembersTable.COLUMN_PROJECT_NAME, this.projectName);
        json.put(FamilyMembersTable.COLUMN_PSU_CODE, this.psuCode);
        json.put(FamilyMembersTable.COLUMN_HHID, this.hhid);
        json.put(FamilyMembersTable.COLUMN_INDEXED, this.indexed);
        json.put(FamilyMembersTable.COLUMN_SNO, this.sno);
        json.put(FamilyMembersTable.COLUMN_USERNAME, this.userName);
        json.put(FamilyMembersTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FamilyMembersTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FamilyMembersTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(FamilyMembersTable.COLUMN_ISTATUS, this.iStatus);
        json.put(FamilyMembersTable.COLUMN_SYNCED, this.synced);
        json.put(FamilyMembersTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(FamilyMembersTable.COLUMN_APPVERSION, this.appver);

        json.put(FamilyMembersTable.COLUMN_SA2, new JSONObject(sA2toString()));
        return json;
    }

    public String sA2toString() throws JSONException {
        Log.d(TAG, "sA2toString: ");
        JSONObject json = new JSONObject();
        json.put("hl1", hl1)
                .put("hl2", hl2)
                .put("hl3", hl3)
                .put("hl4", hl4)
                .put("hl5d", hl5d)
                .put("hl5m", hl5m)
                .put("hl5y", hl5y)
                .put("hl6y", hl6y)
                .put("hl6m", hl6m)
                .put("hl7", hl7)
                .put("hl8", hl8)
                .put("hl9", hl9)
                .put("hl10", hl10)
                .put("hl11", hl11)
                .put("hl12", hl12)
                .put("hl1296x", hl1296x)
                .put("hl13", hl13);
        return json.toString();
    }

    private void CaluculateAge() {
        Log.d(TAG, "CaluculateAge: " + this.hl5y + "-" + this.hl5m + "-" + this.hl5d);

        if (!this.hl5y.equals("") && !this.hl5y.equals("9998") && !this.hl5m.equals("") && !this.hl5d.equals("")) {

            if ((Integer.parseInt(this.hl5m) > 12 && !this.hl5m.equals("98")) || (Integer.parseInt(this.hl5d) > 31 && !this.hl5d.equals("98")) || Integer.parseInt(this.hl5y) < 1920) {
                setHl6y("");
                setHl6m("");
                this.ageInMonths = 0;
                return;
            }


            // set current Date
            int curDay = !MainApp.form.getAs1q15d().equals("98") ? Integer.parseInt(MainApp.form.getAs1q15d()) : 15;
            int curMonth = !MainApp.form.getAs1q15m().equals("98") ? Integer.parseInt(MainApp.form.getAs1q15m()) : 6;
            int curYear = Integer.parseInt(MainApp.form.getAs1q15y());
            Calendar cur = Calendar.getInstance();


            // set Date of birth
            int day = !this.hl5d.equals("98") ? Integer.parseInt(this.hl5d) : 15;
            int month = !this.hl5m.equals("98") ? Integer.parseInt(this.hl5m) : 6;
            int year = Integer.parseInt(this.hl5y);
            Calendar cal = Calendar.getInstance();

            SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd", Locale.ENGLISH);
//             String todayDate = df.format(Calendar.getInstance().getTime());


            try {
                cal.setTime(df.parse(year + " " + month + " " + day));
                cur.setTime(df.parse(curYear + " " + curMonth + " " + curDay));

/*                System.out.println(df.format("Current: " + cur.getTime()));
                System.out.println(df.format("DOB: " + cal.getTime()));*/


                //long millis = System.currentTimeMillis() - cal.getTimeInMillis();
                long millis = cur.getTimeInMillis() - cal.getTimeInMillis();
                cal.setTimeInMillis(millis);

             /*   int mYear = cal.get(Calendar.YEAR)-1970;
                int mMonth = cal.get(Calendar.MONTH);
                int mDay = cal.get(Calendar.DAY_OF_MONTH)-1;

                Log.d(TAG, "CaluculateAge: " + (mYear) + "-" + mMonth + "-" + mDay);
*/
                this.ageInMonths = MILLISECONDS.toDays(millis) / 30;
                long tYear = MILLISECONDS.toDays(millis) / 365;
                long tMonth = (MILLISECONDS.toDays(millis) - (tYear * 365)) / 30;
                long tDay = MILLISECONDS.toDays(millis) - ((tYear * 365) + (tMonth * 30));

                Log.d(TAG, "CaluculateAge: Y-" + tYear + " M-" + tMonth + " D-" + tDay);
               /* setH231d(String.valueOf(tDay));
                setH231m(String.valueOf(tMonth));*/

                setHl6y(String.valueOf(tYear));
                setHl6m(String.valueOf(tMonth));
                if (tYear < 0)
                    setHl6y("");
                //setAge(String.valueOf(((tYear) * 12) + tMonth));


        /*        String.format("%d min, %d sec",
                        ,
                        TimeUnit.MILLISECONDS.toSeconds(millis) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
                );*/

            } catch (ParseException e) {
                Log.d(TAG, "CaluculateAge: " + e.getMessage());
                e.printStackTrace();

            }
        }
    }

    /**
     * Memeber Categories:
     * 1 = MWRA
     * 2 = Child
     * 3 = Adol Male // not used in this project
     * 4 = Adol Female
     */
    private void updateMemCategory() {
        if (hl4.equals("") || hl6y.equals("") || hl7.equals("") || !hl10.equals("1")) return;
        String memGender = getHl4();
        String memMaritalStatus = getHl7();
        int memAge = Integer.parseInt(getHl6y());

        // MWRA
        if (memGender.equals("2")                // Female
                && memAge >= 15 && memAge <= 49   // 15 to 49 year old
                && !memMaritalStatus.equals("5")
        ) {
            setMemCate("1");
        }

        // Child
        if (memAge < 5
                && !hl8.equals("") && !hl8.equals("97")
        ) {
            setMemCate("2");
        }

        // Adolescent Male
        if (memGender.equals("1")
                && memAge >= 15 && memAge <= 19   // 15 to 49 year old
                && (memMaritalStatus.equals("5") || memMaritalStatus.equals("97"))
        ) {
            setMemCate("3");
        }

        // Adolescent Female

        if (memGender.equals("2")
                && memAge >= 15 && memAge <= 19   // 15 to 49 year old
                && (memMaritalStatus.equals("5") || memMaritalStatus.equals("97"))
        ) {
            setMemCate("4");
        }
    }
}
