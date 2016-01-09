package mobotech.stuffs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.percent)
    TextView percent;
    @InjectView(R.id.profile_text)
    TextView profileText;
    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }


    @Override
    public void onResume(){
        super.onResume();
        UserDetail userDetail = getUserDetailsFromPrefs(this);
        String percentageComplete = profileCompletion(userDetail);
        percent.setText(percentageComplete + "%");
        profileText.setText("of your profile\t" + "is complete");
        progressBar.setProgress(Integer.parseInt(percentageComplete));
    }


    private String profileCompletion(UserDetail userDetail){
        int count = 0;
        String firstName = userDetail.getFirstName();
        String lastName = userDetail.getLastName();
        String name = firstName + " " + lastName;
        if (isValid(name)){count++;}
        String dob = userDetail.getDob();
        if(isValid(dob)){count++;}
        String email = userDetail.getEmail();
        if(isValid(email)){count++;}
        String gender = userDetail.getGender();
        if(isValid(gender)){count++;}
        String city = userDetail.getCity();
        if(isValid(city)){count++;}
        String occupation = userDetail.getOccupation();
        if(isValid(occupation)){count++;}

        double percentage = ((double)count)/6 * 100;

        return String.valueOf((int)percentage);
    }

    private boolean isValid(String value){
        return !(TextUtils.isEmpty(value) || value.equals("null"));
    }


    public static UserDetail getUserDetailsFromPrefs(Context context) {
        UserDetail userDetail = new UserDetail();
        SharedPreferences prefs = context.getSharedPreferences("", Context.MODE_PRIVATE);
        userDetail.setFbToken(prefs.getString("", "Def1"));
        userDetail.setUser_id(prefs.getString("", "Def2"));
        userDetail.setFirstName(prefs.getString("", ""));
        userDetail.setLastName(prefs.getString("", "Def4"));
        userDetail.setGender(prefs.getString("", ""));
        userDetail.setDob(prefs.getString("", "Def6"));
        userDetail.setEmail(prefs.getString("", "Def7"));
        userDetail.setUserPictureUrl(prefs.getString("", ""));
        userDetail.setCity(prefs.getString("", "Def9"));
        userDetail.setOccupation(prefs.getString("", ""));

        return userDetail;

    }


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
