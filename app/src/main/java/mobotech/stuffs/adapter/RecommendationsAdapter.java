package mobotech.stuffs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mobotech.stuffs.MyFragment;

/**
 * Created by niraj on 8/6/15.
 */
public class RecommendationsAdapter extends FragmentPagerAdapter {



    String[] tabs;



    public RecommendationsAdapter(FragmentManager fm, String[] tabs) {

        super(fm);

        this.tabs = tabs;


    }



    @Override


    public Fragment getItem(int index) {


        switch (index) {


            case 0:

                return new MyFragment().newInstance(tabs[index]);

            case 1:

                return new MyFragment().newInstance(tabs[index]);

            case 2:

                return new MyFragment().newInstance(tabs[index]);

            case 3:

                return new MyFragment().newInstance(tabs[index]);

            case 4:
                return new MyFragment().newInstance(tabs[index]);

            default:

                return new MyFragment().newInstance(tabs[index]);
        }

    }




    @Override


    public int getItemPosition(Object object) {


        return super.getItemPosition(object);


    }



    @Override
    public int getCount() {


        return tabs.length;


    }



    @Override
    public CharSequence getPageTitle(int position) {


        return tabs[position];


    }


}