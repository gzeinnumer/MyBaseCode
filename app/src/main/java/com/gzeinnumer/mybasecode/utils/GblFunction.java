package com.gzeinnumer.mybasecode.utils;

import static com.gzeinnumer.mybasecode.base.BaseConstant.MATA_UANG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.gzeinnumer.bu.utils.MBUtilsDate;
import com.gzeinnumer.eeda.helper.FGDir;
import com.gzeinnumer.eeda.helper.FGFile;
import com.gzeinnumer.mybasecode.BuildConfig;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GblFunction {

    public static final String TAG = "GblFunction";

    public static void debugLocationActivity(Context applicationContext, String simpleName) {
        if (isDebugActive()) {
            Toast.makeText(applicationContext, simpleName, Toast.LENGTH_SHORT).show();
        }
    }

    public static void myLogD(String TAG, String msg) {
        Log.d(TAG, "myLogD: " + msg);
    }

    public static String getCreatedAt() {
        return MBUtilsDate.getCurrentTime("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    public static boolean isDebugActive() {
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
            if (isDebugActive())
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + ".debug";
            else
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Package name not found";
        }
    }

    public static String getSoftwareVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Package name not found";
        }
    }

    public static boolean validateFileSize(String path) {
        File file = new File(path);

        long fileSizeInBytes = file.length();
        long fileSizeInKB = fileSizeInBytes / 1024;
        long fileSizeInMB = fileSizeInKB / 1024;

        return fileSizeInMB <= 20;
    }

    public static String messageRelease(String debug) {
        if (isDebugActive()) {
            return debug;
        } else {
            return "Telah terjadi kesalahan. Silahkan mencoba beberapa saat lagi";
        }
    }

    public static String dummyOrDebug(){
        if (isDebugActive()) {
            return "resource.get()";
        } else {
            return "-";
        }
    }

    /**
     * "data:image/jpeg;"
     */
    public static String convertToBase64WithDataImage(String imagePath) {
        try {
            Bitmap bm = BitmapFactory.decodeFile(imagePath);
            //  bm = Bitmap.createScaledBitmap(bm, 1024, 1024, false);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 25, baos);
            byte[] byteArrayImage = baos.toByteArray();
            return "data:image/jpeg;base64," + Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
        } catch (Exception e) {
            Log.d(TAG, "convertToBase64WithDataImage: " + e.getMessage());
            return " ";
        }
    }

    public static String getYesterday(int count) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, count);
        Date date = cal.getTime();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(date);
    }

    public static String getTomorrow(int count) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, count);
        Date date = cal.getTime();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(date);
    }

    public static String prettyCount(Number number) {
        try{
            char[] suffix = {' ', 'k', 'M', 'B', 'T', 'P', 'E'};
            long numValue = number.longValue();
            int value = (int) Math.floor(Math.log10(numValue));
            int base = value / 3;
            if (value >= 3 && base < suffix.length) {
                return new DecimalFormat("#0").format(numValue / Math.pow(10, base * 3)) + suffix[base];
            } else {
                return new DecimalFormat("##0").format(numValue);
            }
        }  catch (Exception e){
            return String.valueOf(number);
        }
    }

    public static String realNumberInt(String cureencyValue) {
        if (cureencyValue == null || cureencyValue.equals("")) {
            return "0";
        } else {
            return cureencyValue.replace(".","").replace(",00","");
        }
    }

    public static String saparator(String value) {
        if (value == null || value.equals("")) {
            return "0";
        }
        value = idrComma(value);
        return value.substring(0, value.indexOf(","));
    }

    public static String idrComma(String value) {
        if (value == null || value.equals("")) {
            return "0";
        } else {
            Locale localeID = new Locale("in", "ID");
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
            return formatRupiah.format(Double.valueOf(value)).replace(MATA_UANG.trim(), "");
        }
    }

    public static String idr(String value) {
        return MATA_UANG + idrComma(value).replace(",00","");
    }

    public static String saveMessage(String debug, String realese) {
        if (BuildConfig.DEBUG) {
            return debug;
        } else {
            return realese;
        }
    }

    public static String s(Object str) {
        return String.valueOf(str);
    }

    public static String getDate() {
        return MBUtilsDate.getCurrentTime("yyyy-MM-dd", Locale.getDefault());
    }

    public static String dateOnly(String time) {
        if (time == null){
            return "-";
        }
        String reformatOneString = MBUtilsDate.reformatDate(
                time,
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd",
                Locale.getDefault()
        );
        return reformatOneString;
    }

    @SuppressLint("SimpleDateFormat")
    public static boolean checkBetween(String dateToCheck, String startDate, String endDate) {
        boolean res = false;
        SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd"); //22-05-2013
        SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd"); //22-05-2013
        try {
            Date requestDate = fmt2.parse(dateToCheck);
            Date fromDate = fmt1.parse(startDate);
            Date toDate = fmt1.parse(endDate);
            res = requestDate.compareTo(fromDate) >= 0 && requestDate.compareTo(toDate) <= 0;
        } catch (ParseException pex) {
            pex.printStackTrace();
        }
        return res;
    }
}
