package com.sds.study.andino;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 김승현 on 2016-11-10.
 */

public class ItemView extends LinearLayout {

    private ImageView mIcon;
    private TextView mTxt;
    private TextView mComment;

    private Button mBtn;

    public ItemView(Context context, FriendData gData){
        super(context);

        //인플레이션 작업
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.friend_list, this, true);

        //set icon
        mIcon = (ImageView) findViewById(R.id.icon);
        mIcon.setImageResource(gData.getIcon());

        //set title 지정
        mTxt = (TextView) findViewById(R.id.name);
        mTxt.setText(gData.getTitle());


    }
    public void  setmIcon(int icon){
        mIcon.setImageResource(icon);
    }
    public void setTitle(String data){
        mTxt.setText(data);
    }

    }

