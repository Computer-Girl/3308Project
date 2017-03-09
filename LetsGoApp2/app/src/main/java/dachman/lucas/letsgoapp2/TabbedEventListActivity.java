package dachman.lucas.letsgoapp2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dachman.lucas.letsgoapp2.Adapters.mFragmentPagerAdapter;
import dachman.lucas.letsgoapp2.Models.Category;

public class TabbedEventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_event_list);

        // Get the view pager and set its adapter
        Category [] categories = Category.values();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new mFragmentPagerAdapter(getSupportFragmentManager(), categories));

        // Give Tab Layout the view pager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
