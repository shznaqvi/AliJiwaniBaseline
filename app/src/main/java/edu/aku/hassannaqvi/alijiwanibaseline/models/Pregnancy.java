package edu.aku.hassannaqvi.alijiwanibaseline.models;

import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp._EMPTY_;
import static edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp.selectedMWRA;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.alijiwanibaseline.BR;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;

public class Pregnancy extends BaseObservable implements Observable {


    private final String TAG = "Pregnancy";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = PROJECT_NAME;
    // APP VARIABLES
    private String id = _EMPTY_;
    private String uid = _EMPTY_;
    private String uuid = _EMPTY_;
    private String muid = _EMPTY_;
    private String fmuid = _EMPTY_;
    private String userName = _EMPTY_;
    private String sysDate = _EMPTY_;
    private String psuCode = _EMPTY_;
    private String hhid = _EMPTY_;
    private String sno = _EMPTY_;
    private String msno = _EMPTY_;
    private String indexed = _EMPTY_;
    private String deviceId = _EMPTY_;
    private String deviceTag = _EMPTY_;
    private String appver = _EMPTY_;
    private String endTime = _EMPTY_;
    private String iStatus = _EMPTY_;
    private String iStatus96x = _EMPTY_;
    private String synced = _EMPTY_;
    private String syncDate = _EMPTY_;

    private String bs1q7p1g = _EMPTY_;
    private String bs1q7p1d = _EMPTY_;
    private String bs1q7p1d96x = _EMPTY_;
    private String bs1q7p1b = _EMPTY_;

    public void populateMeta() {
        setSysDate(MainApp.form.getSysDate());
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setUuid(MainApp.form.getUid());  // not applicable in Form table
        setMuid(MainApp.wra.getUid());  // not applicable in Form table
        setFmuid(MainApp.familyList.get(Integer.parseInt(selectedMWRA)).getUid()); //// not applicable in Form table
        setMsno(MainApp.wra.getBs1q1());
        setAppver(MainApp.appInfo.getAppVersion());
        setProjectName(PROJECT_NAME);
        setpsuCode(MainApp.selectedPSU);
        setHhid(MainApp.selectedHHID);
    }


    public String getProjectName() {
        return projectName;
    }

    public String getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public String getpsuCode() {
        return psuCode;
    }

    public String getHhid() {
        return hhid;
    }

    public String getSno() {
        return sno;
    }

    public String getIndexed() {
        return indexed;
    }

    public String getMuid() {
        return muid;
    }

    public String getFmuid() {
        return fmuid;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIndexed(String indexed) {
        this.indexed = indexed;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setMuid(String muid) {
        this.muid = muid;
    }

    public void setFmuid(String fmuid) {
        this.fmuid = fmuid;
    }

    public String getMsno() {
        return msno;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public void setpsuCode(String psuCode) {
        this.psuCode = psuCode;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setMsno(String msno) {
        this.msno = msno;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }



    @Bindable
    public String getBs1q7p1g() {
        return bs1q7p1g;
    }

    public void setBs1q7p1g(String bs1q7p1g) {
        this.bs1q7p1g = bs1q7p1g;
        notifyPropertyChanged(BR.bs1q7p1g);
    }

    @Bindable
    public String getBs1q7p1d() {
        return bs1q7p1d;
    }

    public void setBs1q7p1d(String bs1q7p1d) {
        this.bs1q7p1d = bs1q7p1d;
        setBs1q7p1d96x(bs1q7p1d.equals("96") ? this.bs1q7p1d96x : "");
        notifyPropertyChanged(BR.bs1q7p1d);
    }

    @Bindable
    public String getBs1q7p1d96x() {
        return bs1q7p1d96x;
    }

    public void setBs1q7p1d96x(String bs1q7p1d96x) {
        this.bs1q7p1d96x = bs1q7p1d96x;
        notifyPropertyChanged(BR.bs1q7p1d96x);
    }

    @Bindable
    public String getBs1q7p1b() {
        return bs1q7p1b;
    }

    public void setBs1q7p1b(String bs1q7p1b) {
        this.bs1q7p1b = bs1q7p1b;
        notifyPropertyChanged(BR.bs1q7p1b);
    }



    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(TableContracts.PregnancyTable.COLUMN_ID, this.id);
        json.put(TableContracts.PregnancyTable.COLUMN_UID, this.uid);
        json.put(TableContracts.PregnancyTable.COLUMN_UUID, this.uuid);
        json.put(TableContracts.PregnancyTable.COLUMN_MUID, this.muid);
        json.put(TableContracts.PregnancyTable.COLUMN_FMUID, this.fmuid);
        json.put(TableContracts.PregnancyTable.COLUMN_PROJECT_NAME, this.projectName);
        json.put(TableContracts.PregnancyTable.COLUMN_INDEXED, this.indexed);
        json.put(TableContracts.PregnancyTable.COLUMN_PSU_CODE, this.psuCode);
        json.put(TableContracts.PregnancyTable.COLUMN_HHID, this.hhid);
        json.put(TableContracts.PregnancyTable.COLUMN_SNO, this.sno);
        json.put(TableContracts.PregnancyTable.COLUMN_M_SNO, this.msno);
        json.put(TableContracts.PregnancyTable.COLUMN_USERNAME, this.userName);
        json.put(TableContracts.PregnancyTable.COLUMN_SYSDATE, this.sysDate);
        json.put(TableContracts.PregnancyTable.COLUMN_DEVICEID, this.deviceId);
        json.put(TableContracts.PregnancyTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(TableContracts.PregnancyTable.COLUMN_ISTATUS, this.iStatus);
        json.put(TableContracts.PregnancyTable.COLUMN_SYNCED, this.synced);
        json.put(TableContracts.PregnancyTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(TableContracts.PregnancyTable.COLUMN_APPVERSION, this.appver);
        json.put(TableContracts.PregnancyTable.COLUMN_SB1, new JSONObject(sB1toString()));
        return json;
    }

    public String sB1toString() throws JSONException {
        Log.d(TAG, "sB1toString: ");
        JSONObject json = new JSONObject();
        json.put("bs1q7p1g", bs1q7p1g)
                .put("bs1q7p1d", bs1q7p1d)
                .put("bs1q7p1d96x", bs1q7p1d96x)
                .put("bs1q7p1b", bs1q7p1b);
        return json.toString();
    }


    public Pregnancy Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_UUID));
        this.muid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_MUID));
        this.fmuid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_FMUID));
        this.projectName = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_PROJECT_NAME));
        this.indexed = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_INDEXED));
        this.psuCode = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_PSU_CODE));
        this.hhid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_HHID));
        this.sno = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_SNO));
        this.msno = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_M_SNO));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_SYNCED_DATE));

        sB1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.PregnancyTable.COLUMN_SB1)));
        return this;
    }

    public void sB1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sB1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.bs1q7p1g = json.getString("bs1q7p1g");
            this.bs1q7p1d = json.getString("bs1q7p1d");
            this.bs1q7p1d96x = json.getString("bs1q7p1d96x");
            this.bs1q7p1b = json.getString("bs1q7p1b");
        }
    }





}
