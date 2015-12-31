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

    String link_1 = "http://p-fst1.pixstatic.com/5640d62d2a099a637b00012e/_w.540_s.fit_/Liana_Hayles_Newton_Sam_West_Village_07.jpg";
    String link_2 = "https://sohe.wisc.edu/wordpress/wp-content/uploads/2014/04/Stephen-Small-0910_crop-e1432917505540-300x300.jpg";
    String link_3 = "http://jenkinsons.com/aquarium/wp-content/uploads/sites/2/2015/12/Simon-small-300x300.jpg";
    String link_4 = "http://media.t3.com/img/resized/om/xxl_Omega-Seamaster-300-Spectre-3-970-80.jpg";
    String link_5 = "https://www.bordeaux-undiscovered.co.uk/wp-content/uploads/1970/01/FDLRPALE-small-300x300.jpg";
    String link_6 = "https://radio.adelaide.edu.au/wp-content/uploads/2013/07/Small-Change-300x300pix.jpg";

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
                return FirstFragment.newInstance(0, "Title 0 " , "Description 0 " , link_1);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FirstFragment.newInstance(1, "Title 1 " , "Description 1 " , link_2);
            case 2: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(2, "Title 2 " , "Description 2 " , link_3);
            case 3: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(3, "Title 3 " , "Description 3 " , link_4);
            case 4: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(4, "Title 4 " , "Description 4 " , link_5);
            case 5: // Fragment # 1 - This will show SecondFragment
                return FirstFragment.newInstance(5, "Title 5 " , "Description 5 " , link_6);
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