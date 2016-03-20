package example.app.androidsample;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import org.json.JSONObject;

import example.app.androidsample.fragment.PagerItemFragment;
import example.app.androidsample.util.JSONParser;

public class PagerSlidingTabActivity extends AppCompatActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private TopPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sliding);

        setupTabs();

    }

    protected void setupTabs() {

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new TopPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);

        tabs.setViewPager(pager);
    }

    public class TopPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = { "1", "2", "3"};

        public TopPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return PagerItemFragment.newInstance(PagerSlidingTabActivity.this, 1);
            } else if (position == 1) {
                return PagerItemFragment.newInstance(PagerSlidingTabActivity.this, 2);
            } else {
                return PagerItemFragment.newInstance(PagerSlidingTabActivity.this, 3);
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }



    }
}
