package com.tw2.bxhkpop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tw2.bxhkpop.view.fragment.BXHBaiHatFragment;
import com.tw2.bxhkpop.view.fragment.BXHGroupFragment;
import com.tw2.bxhkpop.view.fragment.BXHVisualFragment;

public class BXHMainAdapter extends FragmentStatePagerAdapter {

    public BXHMainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new BXHGroupFragment();
                break;
            case 1:
                frag = new BXHVisualFragment();
                break;
            case 2:
                frag = new BXHBaiHatFragment();
                break;

        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Nhóm nhạc";
                break;
            case 1:
                title = "Visual";
                break;
            case 2:
                title = "Bài hát";
                break;

        }

        return title;
    }
}
