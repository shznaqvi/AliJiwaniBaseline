package edu.aku.hassannaqvi.alijiwanibaseline.models

import android.database.Cursor
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts.VillagesTable
import edu.aku.hassannaqvi.alijiwanibaseline.core.MainApp._EMPTY_
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hassan.naqvi on 11/30/2016.
 */
class Villages {
    var ID: Long = 0
    var country: String = _EMPTY_
    var ccode: String = _EMPTY_
    var province: String = _EMPTY_
    var provcode: String = _EMPTY_
    var district_name: String = _EMPTY_
    var dcode: String = _EMPTY_
    var village: String = _EMPTY_
    var vcode: String = _EMPTY_
    var psucode: String = _EMPTY_


    constructor() {
        // Default Constructor
    }

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Villages {
        country = jsonObject.getString(VillagesTable.COLUMN_COUNTRY)
        ccode = jsonObject.getString(VillagesTable.COLUMN_CCODE)
        province = jsonObject.getString(VillagesTable.COLUMN_PROVINCE)
        provcode = jsonObject.getString(VillagesTable.COLUMN_PROVCODE)
        district_name = jsonObject.getString(VillagesTable.COLUMN_DISTRICT_NAME)
        dcode = jsonObject.getString(VillagesTable.COLUMN_DCODE)
        village = jsonObject.getString(VillagesTable.COLUMN_VILLAGE)
        vcode = jsonObject.getString(VillagesTable.COLUMN_VCODE)
        psucode = jsonObject.getString(VillagesTable.COLUMN_PSUCODE)

        return this
    }

    fun hydrate(cursor: Cursor): Villages {
        ID = cursor.getLong(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_ID))
        country = cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_COUNTRY))
        ccode = cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_CCODE))
        province = cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_PROVINCE))
        provcode = cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_PROVCODE))
        district_name =
            cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_DISTRICT_NAME))
        dcode = cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_DCODE))
        village = cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_VILLAGE))
        vcode = cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_VCODE))
        psucode = cursor.getString(cursor.getColumnIndexOrThrow(VillagesTable.COLUMN_PSUCODE))

        return this
    }


}