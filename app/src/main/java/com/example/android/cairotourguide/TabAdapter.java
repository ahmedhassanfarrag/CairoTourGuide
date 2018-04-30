package com.example.android.cairotourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link android.support.v4.app.Fragment} for a view pager.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public TabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MuseumsFragment();
        } else if (position == 1) {
            return new TopPlacesFragmen();
        } else if (position == 2) {
            return new MallFragment();
        } else if (position == 3) {
            return new CafeFragment();
        } else {
            return new ParksFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.Museum);
        } else if (position == 1) {
            return mContext.getString(R.string.top5);
        } else if (position == 2) {
            return mContext.getString(R.string.Malls);
        } else if (position == 3) {
            return mContext.getString(R.string.cafe);
        } else {
            return mContext.getString(R.string.parks);
        }
    }
}

