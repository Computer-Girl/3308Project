package dachman.lucas.letsgoapp2.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import dachman.lucas.letsgoapp2.Fragments.EventListCategoryFragment;
import dachman.lucas.letsgoapp2.Fragments.EventListStarredFragment;
import dachman.lucas.letsgoapp2.Models.Category;

/**
 * Created by lucas on 3/8/17.
 *
 * This class maintains which fragment is shown, depending on the position of the tab view
 */




public class mFragmentPagerAdapter extends FragmentStatePagerAdapter {

//    Category [] categories;
    String [] pages;

    public mFragmentPagerAdapter(FragmentManager fm, String [] _pages) {
        super(fm);

        this.pages = _pages;
    }

    /**
     * This method takes care of showing the correct
     * fragment depending on the tab view. If the tab
     * view is one of the categories then it returns
     * an instance of EventListCategoryFragment.
     * The Category is determined using pageName. If
     * the tab view is for the starred events then
     * it returns an instance EventListStarredFragment
     *
     * @param position - The position of the tab view
     * @return - The Fragment to display
     */
    @Override
    public Fragment getItem(int position) {
        String pageName = pages[position];
        if(pageName == "Starred")
            return EventListStarredFragment.newInstance();
        else
            return EventListCategoryFragment.newInstance(Category.valueOf(pageName));
    }

    @Override
    public int getCount() {
        return pages.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pages[position].toString();
    }
}
