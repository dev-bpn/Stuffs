package mobotech.stuffs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mobotech.stuffs.adapter.RecommendationsAdapter;
import mobotech.stuffs.view.NonSwipeableViewPager;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.recommendations_viewpager)
    NonSwipeableViewPager mNonSwipableViewPager;

    private String[] tabs= {"q" , "e"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        RecommendationsAdapter adapter = new RecommendationsAdapter(getSupportFragmentManager(), tabs);
        mNonSwipableViewPager.setAdapter(adapter);

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
