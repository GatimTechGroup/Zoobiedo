package com.zoobiedo.org.utils;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zoobiedo.org.R;
import com.zoobiedo.org.model.BookingTimeSlots;
import com.zoobiedo.org.model.Facilities;
import com.zoobiedo.org.model.FacilitySlots;
import com.zoobiedo.org.model.SubFacilities;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by Venkatesh on 22-09-2016.
 */
public class AppUtils {


    public static Calendar createDatepicker(Activity activity, final TextView date,ImageView previous,ImageView next,final Calendar myCalendar)
    {
         final int calYear, calMonth, calDay;

        calYear = myCalendar.get(Calendar.YEAR);
        calMonth = myCalendar.get(Calendar.MONTH);
        calDay = myCalendar.get(Calendar.DAY_OF_MONTH);
        final long currentday;

        DatePickerDialog datePicker = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                int month = monthOfYear+1;
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                date.setText(dayOfMonth + "-" + month + "-" + year);

            }
        },calYear,calMonth,calDay);

       // datePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        currentday = datePicker.getDatePicker().getMinDate();
        datePicker.show();

                previous.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if( myCalendar.get(Calendar.DAY_OF_MONTH)> calDay) {
                            myCalendar.set(Calendar.YEAR, myCalendar.get(Calendar.YEAR));
                            myCalendar.set(Calendar.MONTH, myCalendar.get(Calendar.MONTH));
                            myCalendar.set(Calendar.DAY_OF_MONTH, myCalendar.get(Calendar.DAY_OF_MONTH) - 1);

                            date.setText(myCalendar.get(Calendar.DAY_OF_MONTH) + "-" + myCalendar.get(Calendar.MONTH) + "-" + calYear);
                        }
                    }
                });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myCalendar.set(Calendar.YEAR, myCalendar.get(Calendar.YEAR));
                myCalendar.set(Calendar.MONTH, myCalendar.get(Calendar.MONTH));
                myCalendar.set(Calendar.DAY_OF_MONTH, myCalendar.get(Calendar.DAY_OF_MONTH) + 1);
                date.setText(myCalendar.get(Calendar.DAY_OF_MONTH) + "-" + myCalendar.get(Calendar.MONTH) + "-" + calYear);
            }
        });


        return myCalendar;

    }
    public static void createTimePicker(Activity activity,final TextView time,final Calendar myCalendar)
    {
        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = myCalendar.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                time.setText( selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.show();
    }
    public static void createPreferences(Context context,String prefValue,int prefKey)
    {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getString(prefKey), prefValue);
        editor.commit();
    }

    public static void clearAppPreferences(Context context)
    {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear().commit();
    }
    public  static String readPreference(Context context,int prefKey)
    {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPref.getString(context.getString(prefKey), null);
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context.checkCallingOrSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }

        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = connMgr.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }
    public static void displayToast(final Activity activity, final String message)
    {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public static String getJsonStringFromObject(Object jsonObject)
    {
        Gson gson = new Gson();
        // Staff obj = new Staff();
        // 2. Java object to JSON, and assign to a String
        String jsonInString = gson.toJson(jsonObject);
        return jsonInString;
    }

    public static JsonObject getJsonObject( String obj )
    {
        JsonParser lParser = new JsonParser();
        return lParser.parse( obj ).getAsJsonObject();
    }

    public static String getISO8601(Calendar mCalender)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(mCalender.getTimeZone());
        String nowAsISO = df.format(new Date());
        return nowAsISO;
    }
    public static void createProgressBar(ProgressDialog mProgress)
    {
        mProgress.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mProgress.setIndeterminate(true);
        mProgress.show();
        mProgress.setCancelable(false);
        mProgress.setContentView(R.layout.progress);
    }
    public static ArrayList<Facilities> getFacilities(ArrayList<FacilitySlots> slots)
    {
        ArrayList<Facilities> mlist = new ArrayList<>();
        for(int i=0;i<=slots.size()-1;i++)
        {
            for(int j=0;j<=slots.get(i).getValue().size()-1;j++)
            {
                mlist.add(slots.get(i).getValue().get(j));
            }
        }
        return mlist;
    }
    public static ArrayList<SubFacilities> getSubFacilities(ArrayList<Facilities> mFacilitiesList)
    {
        ArrayList<SubFacilities> mlist = new ArrayList<>();
        for(int i=0; i<= mFacilitiesList.size()-1;i++)
        {
            for(int j=0 ;j<=mFacilitiesList.get(i).getSubfacilities().size()-1 ; j++) {
                mlist.add(mFacilitiesList.get(i).getSubfacilities().get(j));
            }
        }
        return mlist;
    }

    public static HashMap<String,ArrayList<Facilities>> getFacilityMap(ArrayList<FacilitySlots> slots)
    {
        HashMap<String,ArrayList<Facilities>> facilitiesHashMap = new HashMap<>();
        for(int i=0;i<=slots.size()-1;i++)
        {
            for(int j=0;j<=slots.get(i).getValue().size()-1;j++)
            {
                facilitiesHashMap.put(slots.get(i).getKey(), slots.get(i).getValue());
            }
        }
        return facilitiesHashMap;
    }
    public static SubFacilities getSubFacilityFromId(ArrayList<SubFacilities> subFacilities,int id)
    {
        for(SubFacilities sf : subFacilities)
        {
            if(id == sf.getSubFacilityId())
            {
                return sf;
            }
        }
        return null;
    }
   /* public static ArrayList<BookingTimeSlots> getBookingTimeSlots(ArrayList<FacilitySlots> mSlots,String slotType)
    {
        HashMap<String,ArrayList<Facilities>> facilitiesHashMap = getFacilityMap(mSlots);
        Iterator it = facilitiesHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getKey().toString().equalsIgnoreCase(slotType))
            {

            }

        }
    }*/

    public static String getTmeStamp(String date)
    {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date d = null;
        Timestamp timestamp = null;
        try {
            d = (Date)formatter.parse(date);
            timestamp = new java.sql.Timestamp(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("debug","date stamp"+"/Date("+String.valueOf(timestamp.getTime())+")/");
        //return "/Date("+String.valueOf(timestamp.getTime())+")/";
        return "/Date(1462406400000)/";
    }

    public static boolean hasPermissions(Context context, String permission) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permission != null) {

                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }

        }
        return true;
    }
    public static String getHour(String hours)
    {
       int i =  Integer.parseInt(hours.replace("P","").replace("T","").replace("H",""));

        if(i < 12)
        {
            return i+" AM";
        }else
        {
            return i+" PM";
        }
    }
}
