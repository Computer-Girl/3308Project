package dachman.lucas.letsgoapp2.Adapters;

import android.icu.util.ULocale;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import dachman.lucas.letsgoapp2.Fragments.EventListAllFragment;
import dachman.lucas.letsgoapp2.Models.Category;

/**
 * Created by lucas on 3/8/17.
 */

public class mFragmentPagerAdapter extends FragmentStatePagerAdapter {

    Category [] categories;

    public mFragmentPagerAdapter(FragmentManager fm, Category [] categories) {
        super(fm);
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        Category c = categories[position];
        return EventListAllFragment.newInstance(c);
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories[position].name();
    }
}
