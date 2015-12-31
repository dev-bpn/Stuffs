package mobotech.stuffs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import mobotech.stuffs.fragment.FirstFragment;

/**
 * Created by Dell on 12/31/2015.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 6;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return FirstFragment.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FirstFragment.newInstance(1, "Page # 2");
            case 2: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(2, "Page # 3");
            case 3: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(3, "Page # 4");
            case 4: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(4, "Page # 5");
            case 5: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(5, "Page # 6");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}