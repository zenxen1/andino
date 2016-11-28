package com.sds.study.andino;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomPagerAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments = new Fragment[3];

    public RoomPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new AddFriendFragment();
        fragments[1]=new RoomFrienedFragment();
        fragments[2]=new RoomChatFragment();

    }

    @Override
    public int getCount() {
        return fragments.length ;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }
}
