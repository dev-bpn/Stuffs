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
                return FirstFragment.newInstance(0, "Title 0 " , "Description 0 " , "ImageLink 0 ");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FirstFragment.newInstance(0, "Title 1 " , "Description 1 " , "ImageLink 1 ");
            case 2: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(0, "Title 2 " , "Description 2 " , "ImageLink 2 ");
            case 3: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(0, "Title 3 " , "Description 3 " , "ImageLink 3 ");
            case 4: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(0, "Title 4 " , "Description 4 " , "ImageLink 4 ");
            case 5: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(0, "Title 5 " , "Description 5 " , "ImageLink 5 ");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position ;
    }

}