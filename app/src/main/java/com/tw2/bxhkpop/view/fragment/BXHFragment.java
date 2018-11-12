package com.tw2.bxhkpop.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tw2.bxhkpop.R;
import com.tw2.bxhkpop.adapter.BXHMainAdapter;

public class BXHFragment extends Fragment {
    private View view;
    private ViewPager viewPager;
    private BXHMainAdapter adapter;
    private TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bxh, container, false);
        initView();
        initPager();
        return view;
    }

    private void initPager() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        adapter = new BXHMainAdapter(manager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    private void initView() {
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.home_tab_layout);
    }
}
