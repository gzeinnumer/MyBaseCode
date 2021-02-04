package com.gzeinnumer.mybasecode.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import com.gzeinnumer.gzndirectory.helper.FGDir;
import com.gzeinnumer.gzndirectory.helper.FGFile;
import com.gzeinnumer.gznutils.utils.MBUtilsDate;
import com.gzeinnumer.mybasecode.BuildConfig;

import java.util.List;
import java.util.Locale;

public class GblFunction {

    public static void debugLocationActivity(Context applicationContext, String simpleName) {
        if (BuildConfig.DEBUG) {
            Toast.makeText(applicationContext, simpleName, Toast.LENGTH_SHORT).show();
        }
    }

    public static void myLogD(String TAG, String msg) {
        Log.d(TAG, "myLogD: " + msg);
    }

    public static String getCreatedAt() {
        return MBUtilsDate.getCurrentTime("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    public static boolean isDebugActive(){
        return BuildConfig.DEBUG;
    }

    public static boolean isDBExists() {
        return FGFile.isFileExists("/Db/DbName.sql");
    }

    public static void initFolder() {
        String[] folder = new String[]{"/Config", "/Db", "/Foto"};
        FGDir.initFolder(folder);

        if (!FGDir.isFileExists("/Config/Password.txt")) {
            initFilePassword("");
        }
    }

    public static void initFilePassword(String value) {
        String pass;
        if (value.trim().equals("")) {
            pass = "admin";
        } else {
            pass = value;
        }
        String[] data = new String[]{pass};
        String fileName = "/Password.txt";
        String saveTo = "/Config";
        boolean isSuccess = FGFile.initFile(fileName, saveTo, data);
    }

    public static String readFileAdmin() {
        List<String> list = FGFile.readFile("/Config/Password.txt");
        return list.get(0);
    }

    public static List<String> readFileRegister() {
        return FGFile.readFile("/config/Register.txt");
    }

    public static String getSoftwareVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Package name" +
                    " not found";
        }
    }
}
