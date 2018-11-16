package com.tw2.bxhkpop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tw2.bxhkpop.view.fragment.BXHFragment;
import com.tw2.bxhkpop.view.fragment.HomeFragment;
import com.tw2.bxhkpop.view.fragment.ProfileFragment;
import com.tw2.bxhkpop.view.fragment.VideoFragment;

public class HomeAdapter extends FragmentStatePagerAdapter {

    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new HomeFragment();
                break;
            case 1:
                frag = new BXHFragment();
                break;
            case 2:
                frag = new VideoFragment();
                break;
            case 3:
                frag = new ProfileFragment();
                break;


        }
        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
