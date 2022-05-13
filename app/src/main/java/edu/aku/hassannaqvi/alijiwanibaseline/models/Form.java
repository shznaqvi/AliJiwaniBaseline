package edu.aku.hassannaqvi.alijiwanibaseline.models;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp._EMPTY_;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.alijiwanibaseline.BR;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;


public class Form extends BaseObservable implements Observable {

    private final String TAG = "Form";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = PROJECT_NAME;
    // APP VARIABLES
    private String id = _EMPTY_;
    private String uid = _EMPTY_;
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
    private String entryType = _EMPTY_;

    // FIELD VARIABLES
    private String as1q01 = _EMPTY_;
    private String as1q02 = _EMPTY_;
    private String as1q03 = _EMPTY_;
    private String as1q04 = _EMPTY_;
    private String as1q05 = _EMPTY_;
    private String as1q06 = _EMPTY_;
    private String as1q07 = _EMPTY_;
    private String as1q08 = _EMPTY_;
    private String as1q09 = _EMPTY_;
    private String as1q10 = _EMPTY_;
    private String as1q1096x = _EMPTY_;
    private String as1q11 = _EMPTY_;
    private String as1q12 = _EMPTY_;
    private String as1q13 = _EMPTY_;
    private String as1q14 = _EMPTY_;
    private String as1q15d = _EMPTY_;
    private String as1q15m = _EMPTY_;
    private String as1q15y = _EMPTY_;
    private String as1q16h = _EMPTY_;
    private String as1q16m = _EMPTY_;
    private String as1q17h = _EMPTY_;
    private String as1q17m = _EMPTY_;
    private String as1q18 = _EMPTY_;
    private String as1q19 = _EMPTY_;
    private String as1q20 = _EMPTY_;
    private String as1q21 = _EMPTY_;
    private String as1q22 = _EMPTY_;
    private String as1q23 = _EMPTY_;
    private String as1q23a = _EMPTY_;




    public Form() {

/*        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.appInfo.getAppVersion());
        setAppver(MainApp.appInfo.getAppVersion());*/

    }


    public void populateMeta() {

        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        //   setUuid(MainApp.form.getUid());  // not applicable in Form table
        setAppver(MainApp.appInfo.getAppVersion());
        setProjectName(PROJECT_NAME);
        setPsuCode(MainApp.selectedPSU);
        setHhid(MainApp.selectedHHID);
        setEntryType(String.valueOf(MainApp.entryType));

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

    @Bindable
    public String getPsuCode() {
        return psuCode;
    }

    public void setPsuCode(String psuCode) {
        this.psuCode = psuCode;
        notifyPropertyChanged(BR.psuCode);
    }

    @Bindable
    public String getHhid() {
        return hhid;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
        notifyPropertyChanged(BR.hhid);
    }

    @Bindable
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
        notifyPropertyChanged(BR.sno);
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

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
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


    @Bindable
    public String getAs1q01() {
        return as1q01;
    }

    public void setAs1q01(String as1q01) {
        this.as1q01 = as1q01;
        notifyPropertyChanged(BR.as1q01);
    }

    @Bindable
    public String getAs1q02() {
        return as1q02;
    }

    public void setAs1q02(String as1q02) {
        this.as1q02 = as1q02;
        notifyPropertyChanged(BR.as1q02);
    }

    @Bindable
    public String getAs1q03() {
        return as1q03;
    }

    public void setAs1q03(String as1q03) {
        this.as1q03 = as1q03;
        notifyPropertyChanged(BR.as1q03);
    }

    @Bindable
    public String getAs1q04() {
        return as1q04;
    }

    public void setAs1q04(String as1q04) {
        this.as1q04 = as1q04;
        notifyPropertyChanged(BR.as1q04);
    }

    @Bindable
    public String getAs1q05() {
        return as1q05;
    }

    public void setAs1q05(String as1q05) {
        this.as1q05 = as1q05;
        notifyPropertyChanged(BR.as1q05);
    }

    @Bindable
    public String getAs1q06() {
        return as1q06;
    }

    public void setAs1q06(String as1q06) {
        this.as1q06 = as1q06;
        notifyPropertyChanged(BR.as1q06);
    }

    @Bindable
    public String getAs1q07() {
        return as1q07;
    }

    public void setAs1q07(String as1q07) {
        this.as1q07 = as1q07;
        notifyPropertyChanged(BR.as1q07);
    }

    @Bindable
    public String getAs1q08() {
        return as1q08;
    }

    public void setAs1q08(String as1q08) {
        this.as1q08 = as1q08;
        notifyPropertyChanged(BR.as1q08);
    }

    @Bindable
    public String getAs1q09() {
        return as1q09;
    }

    public void setAs1q09(String as1q09) {
        this.as1q09 = as1q09;
        notifyPropertyChanged(BR.as1q09);
    }

    @Bindable
    public String getAs1q10() {
        return as1q10;
    }

    public void setAs1q10(String as1q10) {
        this.as1q10 = as1q10;
        setAs1q1096x(as1q10.equals("96") ? this.as1q1096x : ""); // for all skips, mention all skipped questions
        notifyPropertyChanged(BR.as1q10);
    }

    @Bindable
    public String getAs1q1096x() {
        return as1q1096x;
    }

    public void setAs1q1096x(String as1q1096x) {
        this.as1q1096x = as1q1096x;
        notifyPropertyChanged(BR.as1q1096x);
    }

    @Bindable
    public String getAs1q11() {
        return as1q11;
    }

    public void setAs1q11(String as1q11) {
        this.as1q11 = as1q11;
        notifyPropertyChanged(BR.as1q11);
    }

    @Bindable
    public String getAs1q12() {
        return as1q12;
    }

    public void setAs1q12(String as1q12) {
        this.as1q12 = as1q12;
        notifyPropertyChanged(BR.as1q12);
    }

    @Bindable
    public String getAs1q13() {
        return as1q13;
    }

    public void setAs1q13(String as1q13) {
        this.as1q13 = as1q13;
        notifyPropertyChanged(BR.as1q13);
    }

    @Bindable
    public String getAs1q14() {
        return as1q14;
    }

    public void setAs1q14(String as1q14) {
        this.as1q14 = as1q14;
        notifyPropertyChanged(BR.as1q14);
    }

    @Bindable
    public String getAs1q15d() {
        return as1q15d;
    }

    public void setAs1q15d(String as1q15d) {
        this.as1q15d = as1q15d;
        notifyPropertyChanged(BR.as1q15d);
    }

    @Bindable
    public String getAs1q15m() {
        return as1q15m;
    }

    public void setAs1q15m(String as1q15m) {
        this.as1q15m = as1q15m;
        notifyPropertyChanged(BR.as1q15m);
    }

    @Bindable
    public String getAs1q15y() {
        return as1q15y;
    }

    public void setAs1q15y(String as1q15y) {
        this.as1q15y = as1q15y;
        notifyPropertyChanged(BR.as1q15y);
    }

    @Bindable
    public String getAs1q16h() {
        return as1q16h;
    }

    public void setAs1q16h(String as1q16h) {
        this.as1q16h = as1q16h;
        notifyPropertyChanged(BR.as1q16h);
    }

    @Bindable
    public String getAs1q16m() {
        return as1q16m;
    }

    public void setAs1q16m(String as1q16m) {
        this.as1q16m = as1q16m;
        notifyPropertyChanged(BR.as1q16m);
    }

    @Bindable
    public String getAs1q17h() {
        return as1q17h;
    }

    public void setAs1q17h(String as1q17h) {
        this.as1q17h = as1q17h;
        notifyPropertyChanged(BR.as1q17h);
    }

    @Bindable
    public String getAs1q17m() {
        return as1q17m;
    }

    public void setAs1q17m(String as1q17m) {
        this.as1q17m = as1q17m;
        notifyPropertyChanged(BR.as1q17m);
    }

    @Bindable
    public String getAs1q18() {
        return as1q18;
    }

    public void setAs1q18(String as1q18) {
        this.as1q18 = as1q18;
        notifyPropertyChanged(BR.as1q18);
    }

    @Bindable
    public String getAs1q19() {
        return as1q19;
    }

    public void setAs1q19(String as1q19) {
        this.as1q19 = as1q19;
        notifyPropertyChanged(BR.as1q19);
    }

    @Bindable
    public String getAs1q20() {
        return as1q20;
    }

    public void setAs1q20(String as1q20) {
        this.as1q20 = as1q20;
        notifyPropertyChanged(BR.as1q20);
    }

    @Bindable
    public String getAs1q21() {
        return as1q21;
    }

    public void setAs1q21(String as1q21) {
        this.as1q21 = as1q21;
        notifyPropertyChanged(BR.as1q21);
    }

    @Bindable
    public String getAs1q22() {
        return as1q22;
    }

    public void setAs1q22(String as1q22) {
        this.as1q22 = as1q22;
        notifyPropertyChanged(BR.as1q22);
    }

    @Bindable
    public String getAs1q23() {
        return as1q23;
    }

    public void setAs1q23(String as1q23) {
        this.as1q23 = as1q23;
        setAs1q09(as1q23.equals("2") ? "" : this.as1q09);
        setAs1q10(as1q23.equals("2") ? "" : this.as1q10);
        setAs1q23a(as1q23.equals("2") ? "" : this.as1q23a);
        notifyPropertyChanged(BR.as1q23);
    }

    @Bindable
    public String getAs1q23a() {
        return as1q23a;
    }

    public void setAs1q23a(String as1q23a) {
        this.as1q23a = as1q23a;
        notifyPropertyChanged(BR.as1q23a);
    }

    public Form Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_UID));
        this.projectName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_PROJECT_NAME));
        this.psuCode = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_PSU_CODE));
        this.hhid = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_HHID));
        this.sno = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SNO));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICETAGID));
        this.entryType = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ENTRY_TYPE));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED_DATE));

        sA1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SA1)));
        return this;
    }

    public void sA1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sA1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.as1q01 = json.getString("as1q01");
            this.as1q02 = json.getString("as1q02");
            this.as1q03 = json.getString("as1q03");
            this.as1q04 = json.getString("as1q04");
            this.as1q05 = json.getString("as1q05");
            this.as1q06 = json.getString("as1q06");
            this.as1q07 = json.getString("as1q07");
            this.as1q08 = json.getString("as1q08");
            this.as1q09 = json.getString("as1q09");
            this.as1q10 = json.getString("as1q10");
            this.as1q1096x = json.has("as1q1096x") ? json.getString("as1q1096x") : "";
            this.as1q11 = json.getString("as1q11");
            this.as1q12 = json.getString("as1q12");
            this.as1q13 = json.getString("as1q13");
            this.as1q14 = json.getString("as1q14");
            this.as1q15d = json.getString("as1q15d");
            this.as1q15m = json.getString("as1q15m");
            this.as1q15y = json.getString("as1q15y");
            this.as1q16h = json.getString("as1q16h");
            this.as1q16m = json.getString("as1q16m");
            this.as1q17h = json.getString("as1q17h");
            this.as1q17m = json.getString("as1q17m");
            this.as1q18 = json.getString("as1q18");
            this.as1q19 = json.getString("as1q19");
            this.as1q20 = json.getString("as1q20");
            this.as1q21 = json.getString("as1q21");
            this.as1q22 = json.getString("as1q22");
            this.as1q23 = json.getString("as1q23");
            this.as1q23a = json.getString("as1q23a");
        }
    }

    public String sA1toString() throws JSONException {
        Log.d(TAG, "sA1toString: ");
        JSONObject json = new JSONObject();
        json.put("as1q01", as1q01)
                .put("as1q02", as1q02)
                .put("as1q03", as1q03)
                .put("as1q04", as1q04)
                .put("as1q05", as1q05)
                .put("as1q06", as1q06)
                .put("as1q07", as1q07)
                .put("as1q08", as1q08)
                .put("as1q09", as1q09)
                .put("as1q10", as1q10)
                .put("as1q1096x", as1q1096x)
                .put("as1q11", as1q11)
                .put("as1q12", as1q12)
                .put("as1q13", as1q13)
                .put("as1q14", as1q14)
                .put("as1q15d", as1q15d)
                .put("as1q15m", as1q15m)
                .put("as1q15y", as1q15y)
                .put("as1q16h", as1q16h)
                .put("as1q16m", as1q16m)
                .put("as1q17h", as1q17h)
                .put("as1q17m", as1q17m)
                .put("as1q18", as1q18)
                .put("as1q19", as1q19)
                .put("as1q20", as1q20)
                .put("as1q21", as1q21)
                .put("as1q22", as1q22)
                .put("as1q23", as1q23)
                .put("as1q23a", as1q23a);
        return json.toString();
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this.id);
        json.put(FormsTable.COLUMN_UID, this.uid);
        json.put(FormsTable.COLUMN_PROJECT_NAME, this.projectName);
        json.put(FormsTable.COLUMN_PSU_CODE, this.psuCode);
        json.put(FormsTable.COLUMN_HHID, this.hhid);
        json.put(FormsTable.COLUMN_SNO, this.sno);
        json.put(FormsTable.COLUMN_USERNAME, this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(FormsTable.COLUMN_ENTRY_TYPE, this.entryType);
        json.put(FormsTable.COLUMN_ISTATUS, this.iStatus);
        json.put(FormsTable.COLUMN_SYNCED, this.synced);
        json.put(FormsTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(FormsTable.COLUMN_APPVERSION, this.appver);
        json.put(FormsTable.COLUMN_SA1, new JSONObject(sA1toString()));
        return json;
    }


}
