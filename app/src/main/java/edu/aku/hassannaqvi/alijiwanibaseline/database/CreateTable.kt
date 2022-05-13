package edu.aku.hassannaqvi.alijiwanibaseline.database


import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts.*
import edu.aku.hassannaqvi.alijiwanibaseline.contracts.TableContracts.WRATable


object CreateTable {


    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_PSU_CODE + " TEXT,"
            + FormsTable.COLUMN_HHID + " TEXT,"
            + FormsTable.COLUMN_SNO + " TEXT,"
            + FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsTable.COLUMN_ENTRY_TYPE + " TEXT,"
            + FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsTable.COLUMN_SA1 + " TEXT"
            + " );"
            )


    const val SQL_CREATE_WRA = ("CREATE TABLE "
            + WRATable.TABLE_NAME + "("
            + WRATable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + WRATable.COLUMN_PROJECT_NAME + " TEXT,"
            + WRATable.COLUMN_UID + " TEXT,"
            + WRATable.COLUMN_UUID + " TEXT,"
            + WRATable.COLUMN_FMUID + " TEXT,"
            + WRATable.COLUMN_SNO + " TEXT,"
            + WRATable.COLUMN_PSU_CODE + " TEXT,"
            + WRATable.COLUMN_HHID + " TEXT,"
            + WRATable.COLUMN_USERNAME + " TEXT,"
            + WRATable.COLUMN_SYSDATE + " TEXT,"
            + WRATable.COLUMN_INDEXED + " TEXT,"
            + WRATable.COLUMN_ISTATUS + " TEXT,"
            + WRATable.COLUMN_DEVICEID + " TEXT,"
            + WRATable.COLUMN_DEVICETAGID + " TEXT,"
            + WRATable.COLUMN_SYNCED + " TEXT,"
            + WRATable.COLUMN_SYNCED_DATE + " TEXT,"
            + WRATable.COLUMN_APPVERSION + " TEXT,"
            + WRATable.COLUMN_SB1 + " TEXT,"
            + WRATable.COLUMN_SB2 + " TEXT,"
            + WRATable.COLUMN_SB3 + " TEXT,"
            + WRATable.COLUMN_SB41 + " TEXT,"
            + WRATable.COLUMN_SB42 + " TEXT,"
            + WRATable.COLUMN_SB5 + " TEXT,"
            + WRATable.COLUMN_SB6 + " TEXT,"
            + WRATable.COLUMN_SB7 + " TEXT"
            + " );"
            )

    const val SQL_CREATE_CHILD = ("CREATE TABLE "
            + ChildTable.TABLE_NAME + "("
            + ChildTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildTable.COLUMN_PROJECT_NAME + " TEXT,"
            + ChildTable.COLUMN_UID + " TEXT,"
            + ChildTable.COLUMN_UUID + " TEXT,"
            + ChildTable.COLUMN_FMUID + " TEXT,"
            + ChildTable.COLUMN_SNO + " TEXT,"
            + ChildTable.COLUMN_PSU_CODE + " TEXT,"
            + ChildTable.COLUMN_HHID + " TEXT,"
            + ChildTable.COLUMN_USERNAME + " TEXT,"
            + ChildTable.COLUMN_SYSDATE + " TEXT,"
            + ChildTable.COLUMN_INDEXED + " TEXT,"
            + ChildTable.COLUMN_ISTATUS + " TEXT,"
            + ChildTable.COLUMN_DEVICEID + " TEXT,"
            + ChildTable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildTable.COLUMN_SYNCED + " TEXT,"
            + ChildTable.COLUMN_SYNCED_DATE + " TEXT,"
            + ChildTable.COLUMN_APPVERSION + " TEXT,"
            + ChildTable.COLUMN_CS1 + " TEXT,"
            + ChildTable.COLUMN_CS2 + " TEXT,"
            + ChildTable.COLUMN_CS31 + " TEXT,"
            + ChildTable.COLUMN_CS32 + " TEXT,"
            + ChildTable.COLUMN_CS4 + " TEXT,"
            + ChildTable.COLUMN_CS5 + " TEXT"
            + " );"
            )

    const val SQL_CREATE_MOTHER = ("CREATE TABLE "
            + MotherTable.TABLE_NAME + "("
            + MotherTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MotherTable.COLUMN_PROJECT_NAME + " TEXT,"
            + MotherTable.COLUMN_UID + " TEXT,"
            + MotherTable.COLUMN_UUID + " TEXT,"
            + MotherTable.COLUMN_FMUID + " TEXT,"
            + MotherTable.COLUMN_SNO + " TEXT,"
            + MotherTable.COLUMN_PSU_CODE + " TEXT,"
            + MotherTable.COLUMN_HHID + " TEXT,"
            + MotherTable.COLUMN_USERNAME + " TEXT,"
            + MotherTable.COLUMN_SYSDATE + " TEXT,"
            + MotherTable.COLUMN_INDEXED + " TEXT,"
            + MotherTable.COLUMN_ISTATUS + " TEXT,"
            + MotherTable.COLUMN_DEVICEID + " TEXT,"
            + MotherTable.COLUMN_DEVICETAGID + " TEXT,"
            + MotherTable.COLUMN_SYNCED + " TEXT,"
            + MotherTable.COLUMN_SYNCED_DATE + " TEXT,"
            + MotherTable.COLUMN_APPVERSION + " TEXT,"
            + MotherTable.COLUMN_DS1 + " TEXT,"
            + MotherTable.COLUMN_DS2 + " TEXT,"
            + MotherTable.COLUMN_DS3 + " TEXT"

            + " );"
            )

    const val SQL_CREATE_ENTRYLOGS = ("CREATE TABLE "
            + EntryLogTable.TABLE_NAME + "("
            + EntryLogTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EntryLogTable.COLUMN_PROJECT_NAME + " TEXT,"
            + EntryLogTable.COLUMN_UID + " TEXT,"
            + EntryLogTable.COLUMN_UUID + " TEXT,"
            + EntryLogTable.COLUMN_PSU_CODE + " TEXT,"
            + EntryLogTable.COLUMN_HHID + " TEXT,"
            + EntryLogTable.COLUMN_USERNAME + " TEXT,"
            + EntryLogTable.COLUMN_SYSDATE + " TEXT,"
            + EntryLogTable.COLUMN_DEVICEID + " TEXT,"
            + EntryLogTable.COLUMN_ENTRY_DATE + " TEXT,"
            + EntryLogTable.COLUMN_ISTATUS + " TEXT,"
            + EntryLogTable.COLUMN_ISTATUS96x + " TEXT,"
            + EntryLogTable.COLUMN_ENTRY_TYPE + " TEXT,"
            + EntryLogTable.COLUMN_SYNCED + " TEXT,"
            + EntryLogTable.COLUMN_SYNCED_DATE + " TEXT,"
            + EntryLogTable.COLUMN_APPVERSION + " TEXT"
            + " );"
            )


    const val SQL_CREATE_FAMILYMEMBERS = ("CREATE TABLE "
            + FamilyMembersTable.TABLE_NAME + "("
            + FamilyMembersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FamilyMembersTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FamilyMembersTable.COLUMN_UID + " TEXT,"
            + FamilyMembersTable.COLUMN_UUID + " TEXT,"
            + FamilyMembersTable.COLUMN_PSU_CODE + " TEXT,"
            + FamilyMembersTable.COLUMN_HHID + " TEXT,"
            + FamilyMembersTable.COLUMN_SNO + " TEXT,"
            + FamilyMembersTable.COLUMN_USERNAME + " TEXT,"
            + FamilyMembersTable.COLUMN_SYSDATE + " TEXT,"
            + FamilyMembersTable.COLUMN_INDEXED + " TEXT,"
            + FamilyMembersTable.COLUMN_ISTATUS + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICEID + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICETAGID + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FamilyMembersTable.COLUMN_APPVERSION + " TEXT,"
            + FamilyMembersTable.COLUMN_SA2 + " TEXT"
            + " );"
            )


    const val SQL_CREATE_USERS = ("CREATE TABLE "
            + UsersTable.TABLE_NAME + "("
            + UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersTable.COLUMN_FULLNAME + " TEXT,"
            + UsersTable.COLUMN_DESIGNATION + " TEXT"
            + " );"
            )


    const val SQL_CREATE_VILLAGES = ("CREATE TABLE "
            + VillagesTable.TABLE_NAME + "("
            + VillagesTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VillagesTable.COLUMN_COUNTRY + " TEXT,"
            + VillagesTable.COLUMN_CCODE + " TEXT,"
            + VillagesTable.COLUMN_PROVINCE + " TEXT,"
            + VillagesTable.COLUMN_PROVCODE + " TEXT,"
            + VillagesTable.COLUMN_DISTRICT_NAME + " TEXT,"
            + VillagesTable.COLUMN_DCODE + " TEXT,"
            + VillagesTable.COLUMN_VILLAGE + " TEXT,"
            + VillagesTable.COLUMN_VCODE + " TEXT,"
            + VillagesTable.COLUMN_PSUCODE + " TEXT"
            + " );"
            )


    /*const val SQL_CREATE_RANDOM = ("CREATE TABLE "
            + RandomTable.TABLE_NAME + "("
            + RandomTable.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + RandomTable.COLUMN_SNO + " TEXT,"
            + RandomTable.COLUMN_ENUM_BLOCK_CODE + " TEXT,"
            + RandomTable.COLUMN_HH_NO + " TEXT,"
            + RandomTable.COLUMN_HEAD_HH + " TEXT"
            + " );"
            )*/

    const val SQL_CREATE_VERSIONAPP = ("CREATE TABLE "
            + VersionTable.TABLE_NAME + " ("
            + VersionTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VersionTable.COLUMN_VERSION_CODE + " TEXT, "
            + VersionTable.COLUMN_VERSION_NAME + " TEXT, "
            + VersionTable.COLUMN_PATH_NAME + " TEXT "
            + ");"
            )


}