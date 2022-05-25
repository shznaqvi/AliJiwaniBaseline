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

import edu.aku.hassannaqvi.alijiwanibaseline.BR;
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts;
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp;

public class ECDInfo extends BaseObservable implements Observable {

    private final String TAG = "EcdInfo";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = PROJECT_NAME;
    // APP VARIABLES
    private String id = _EMPTY_;
    private String uid = _EMPTY_;
    private String uuid = _EMPTY_;
    private String userName = _EMPTY_;
    private String sysDate = _EMPTY_;
    private String psuCode = _EMPTY_;
    private String hhid = _EMPTY_;
    private String indexed = _EMPTY_;
    private String ecdNo = _EMPTY_;
    private String deviceId = _EMPTY_;
    private String deviceTag = _EMPTY_;


    private String appver = _EMPTY_;
    private String endTime = _EMPTY_;
    private String iStatus = _EMPTY_;
    private String iStatus96x = _EMPTY_;
    private String synced = _EMPTY_;
    private String syncDate = _EMPTY_;


    //Section Variables
    private String ecdInfo;


    // Field Variables
    private String cs1q02c1 = _EMPTY_;
    private String cs1q02c1n = _EMPTY_;
    private String cs1q02c1agem = _EMPTY_;
    private String cs1q02c1agey = _EMPTY_;
    private String cs1q02c1sex = _EMPTY_;
    private String cs1q02c1ecd = _EMPTY_;
    private String cs1q02c1cent = _EMPTY_;


    public void populateMeta() {

        setSysDate(MainApp.form.getSysDate());
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setUuid(MainApp.form.getUid());  // not applicable in Form table
        setAppver(MainApp.appInfo.getAppVersion());
        setProjectName(PROJECT_NAME);
        setPsuCode(MainApp.selectedPSU);
        setHhid(MainApp.selectedHHID);

    }


    @Bindable
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
        notifyPropertyChanged(BR.projectName);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
        notifyPropertyChanged(BR.uid);
    }

    @Bindable
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
        notifyPropertyChanged(BR.uuid);
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
        notifyPropertyChanged(BR.sysDate);
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
    public String getIndexed() {
        return indexed;
    }

    public void setIndexed(String indexed) {
        this.indexed = indexed;
        notifyPropertyChanged(BR.indexed);
    }

    @Bindable
    public String getEcdNo() {
        return ecdNo;
    }

    public void setEcdNo(String ecdNo) {
        this.ecdNo = ecdNo;
        notifyPropertyChanged(BR.ecdNo);
    }

    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        notifyPropertyChanged(BR.deviceId);
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
        notifyPropertyChanged(BR.deviceTag);
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
        notifyPropertyChanged(BR.appver);
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
        notifyPropertyChanged(BR.endTime);
    }

    @Bindable
    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
        notifyPropertyChanged(BR.iStatus);
    }

    @Bindable
    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
        notifyPropertyChanged(BR.iStatus96x);
    }

    @Bindable
    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
        notifyPropertyChanged(BR.synced);
    }

    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
        notifyPropertyChanged(BR.syncDate);
    }

    @Bindable
    public String getEcdInfo() {
        return ecdInfo;
    }

    public void setEcdInfo(String ecdInfo) {
        this.ecdInfo = ecdInfo;
        notifyPropertyChanged(BR.ecdInfo);
    }

    @Bindable
    public String getCs1q02c1() {
        return cs1q02c1;
    }

    public void setCs1q02c1(String cs1q02c1) {
        this.cs1q02c1 = cs1q02c1;
        notifyPropertyChanged(BR.cs1q02c1);
    }

    @Bindable
    public String getCs1q02c1n() {
        return cs1q02c1n;
    }

    public void setCs1q02c1n(String cs1q02c1n) {
        this.cs1q02c1n = cs1q02c1n;
        notifyPropertyChanged(BR.cs1q02c1n);
    }

    @Bindable
    public String getCs1q02c1agem() {
        return cs1q02c1agem;
    }

    public void setCs1q02c1agem(String cs1q02c1agem) {
        this.cs1q02c1agem = cs1q02c1agem;
        notifyPropertyChanged(BR.cs1q02c1agem);
    }

    @Bindable
    public String getCs1q02c1agey() {
        return cs1q02c1agey;
    }

    public void setCs1q02c1agey(String cs1q02c1agey) {
        this.cs1q02c1agey = cs1q02c1agey;
        notifyPropertyChanged(BR.cs1q02c1agey);
    }

    @Bindable
    public String getCs1q02c1sex() {
        return cs1q02c1sex;
    }

    public void setCs1q02c1sex(String cs1q02c1sex) {
        this.cs1q02c1sex = cs1q02c1sex;
        notifyPropertyChanged(BR.cs1q02c1sex);
    }

    @Bindable
    public String getCs1q02c1ecd() {
        return cs1q02c1ecd;
    }

    public void setCs1q02c1ecd(String cs1q02c1ecd) {
        this.cs1q02c1ecd = cs1q02c1ecd;
        notifyPropertyChanged(BR.cs1q02c1ecd);
    }

    @Bindable
    public String getCs1q02c1cent() {
        return cs1q02c1cent;
    }

    public void setCs1q02c1cent(String cs1q02c1cent) {
        this.cs1q02c1cent = cs1q02c1cent;
        notifyPropertyChanged(BR.cs1q02c1cent);
    }


    public ECDInfo Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_UUID));
        this.psuCode = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_PSU_CODE));
        this.hhid = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_HHID));
        this.projectName = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_PROJECT_NAME));
        this.indexed = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_INDEXED));
        this.ecdNo = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_ECD_NO));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_SYNCED_DATE));

        ecdInfoHydrate(cursor.getString(cursor.getColumnIndexOrThrow(TableContracts.ECDInfoTable.COLUMN_ECDINFO)));
        notifyChange();
        return this;
    }

    public void ecdInfoHydrate(String string) throws JSONException {
        Log.d(TAG, "sC1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.cs1q02c1 = json.getString("cs1q02c1");
            this.cs1q02c1n = json.getString("cs1q02c1n");
            this.cs1q02c1agem = json.getString("cs1q02c1agem");
            this.cs1q02c1agey = json.getString("cs1q02c1agey");
            this.cs1q02c1sex = json.getString("cs1q02c1sex");
            this.cs1q02c1ecd = json.getString("cs1q02c1ecd");
            this.cs1q02c1cent = json.getString("cs1q02c1cent");

        }
    }

    public String ecdInfotoString() throws JSONException {
        Log.d(TAG, "ecdInfotoString: ");
        JSONObject json = new JSONObject();
        json.put("cs1q02c1", cs1q02c1)
                .put("cs1q02c1n", cs1q02c1n)
                .put("cs1q02c1agem", cs1q02c1agem)
                .put("cs1q02c1agey", cs1q02c1agey)
                .put("cs1q02c1sex", cs1q02c1sex)
                .put("cs1q02c1ecd", cs1q02c1ecd)
                .put("cs1q02c1cent", cs1q02c1cent);
        return json.toString();
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(TableContracts.ECDInfoTable.COLUMN_ID, this.id);
        json.put(TableContracts.ECDInfoTable.COLUMN_UID, this.uid);
        json.put(TableContracts.ECDInfoTable.COLUMN_UUID, this.uuid);
        json.put(TableContracts.ECDInfoTable.COLUMN_ECD_NO, this.ecdNo);
        json.put(TableContracts.ECDInfoTable.COLUMN_PSU_CODE, this.psuCode);
        json.put(TableContracts.ECDInfoTable.COLUMN_HHID, this.hhid);

        json.put(TableContracts.ECDInfoTable.COLUMN_PROJECT_NAME, this.projectName);
        json.put(TableContracts.ECDInfoTable.COLUMN_INDEXED, this.indexed);
        json.put(TableContracts.ECDInfoTable.COLUMN_APPVERSION, this.appver);

        json.put(TableContracts.ECDInfoTable.COLUMN_USERNAME, this.userName);
        json.put(TableContracts.ECDInfoTable.COLUMN_SYSDATE, this.sysDate);
        json.put(TableContracts.ECDInfoTable.COLUMN_DEVICEID, this.deviceId);
        json.put(TableContracts.ECDInfoTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(TableContracts.ECDInfoTable.COLUMN_SYNCED, this.synced);
        json.put(TableContracts.ECDInfoTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(TableContracts.ECDInfoTable.COLUMN_ISTATUS, this.iStatus);
        json.put(TableContracts.ECDInfoTable.COLUMN_ECDINFO, new JSONObject(ecdInfotoString()));
        return json;
    }
}
