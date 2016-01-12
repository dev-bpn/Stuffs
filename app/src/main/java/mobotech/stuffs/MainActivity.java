package mobotech.stuffs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mobotech.stuffs.adapter.ImageSliderAdapter;
import mobotech.stuffs.model.Banner;
import mobotech.stuffs.view.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.viewpager)
    AutoScrollViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        ArrayList<Banner> bannerArrayList = new ArrayList<>();
        bannerArrayList.add(new Banner("Banner Title" , "http://www.queness.com/resources/images/png/apple_ex.png"));
        bannerArrayList.add(new Banner("Banner title 2" , "http://donutey.com/images/format/PNG1.png"));

        mViewPager.setAdapter(new ImageSliderAdapter(this , bannerArrayList).setInfiniteLoop(true));
        mViewPager.setInterval(4000);
        mViewPager.startAutoScroll();

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
