package com.example.izyoo.cal3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PartThree03Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//       define View
        View view = inflater.inflate(R.layout.activity_part_three, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewPager);

//used the getChildFragmentManager() to return back into parent fragment~Return a private FragmentManager for placing and managing Fragments inside of this Fragment.
//if used getFragmentManager()/getSupportFragmentManager(), it will recreate another~Return the FragmentManager for interacting with fragments associated with this fragment's activity.
//Basically, the difference is that Fragment's now have their own internal FragmentManager that can handle Fragments. The child FragmentManager is the one that handles Fragments contained
// within only the Fragment that it was added to. The other FragmentManager is contained within the entire Activity.
//In this case, what I'm guessing is you've added the Fragments to the Activity's FragmentManager. You get the child FragmentManager which doesn't contain what you are looking for. Thus
// you get the exception because it can't find the Fragment with the given ID because it's in a different FragmentManager.

        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(PartThreeFragment.createInstance(20), getString(R.string.tab_1));
        pagerAdapter.addFragment(PartThreeFragment.createInstance(6), getString(R.string.tab_2));
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
    }
//

    static class PagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public PagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }
}
