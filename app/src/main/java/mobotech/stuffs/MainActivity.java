package mobotech.stuffs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Date datecurrentDate = new Date(System.currentTimeMillis());
        long lonn = datecurrentDate.getTime();

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);


        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        sharedPrefs.edit().putInt("DAY_INT", currentDay).apply();


        int currDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        int savedDay = PreferenceManager.getDefaultSharedPreferences(this).getInt("DAY_INT", 0);

        if(currDay != savedDay){

            Log.e("APP_TAG" ,currDay +"Do some stuffs if hours changed..");
            Log.e("APP_TAG" , savedDay +"Do some stuffs if hours changed..");

        }{

            Log.e("APP_TAG" ,currDay + "Do some stuffs if hours DONT changed..");
            Log.e("APP_TAG" , savedDay +"Do some stuffs if hours DONT changed..");

        }

    }

    private void saveCurrentDayInPrefs() {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        sharedPrefs.edit().putInt("DAY_INT", currentDay).apply();

    }

//    private void alarmTaskForPreferenceUpdate(){
//
//        Calendar calendar = Calendar.getInstance();
//
//        calendar.set(Calendar.HOUR_OF_DAY, 13); // For 1 PM or 2 PM
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        PendingIntent pi = PendingIntent.getService(this, 0,
//                new Intent(this, MyClass.class),PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                AlarmManager.INTERVAL_DAY, pi);
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
