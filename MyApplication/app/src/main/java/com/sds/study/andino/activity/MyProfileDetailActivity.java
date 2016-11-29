package com.sds.study.andino.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.sds.study.andino.R;
import com.sds.study.andino.RoundProfile;

/**
 * Created by 석환 on 2016-11-29.
 */

public class MyProfileDetailActivity extends AppCompatActivity {

    ImageView imgbackground;
    RoundProfile roundProfile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_detail);
        ImageView imgbackground =(ImageView)findViewById(R.id.imgback);
        imgbackground.setScaleType(ImageView.ScaleType.FIT_XY); //꽉채우기.
        ImageView roundProfile=(ImageView)findViewById(R.id.roundProfile);
        roundProfile.setScaleType(ImageView.ScaleType.FIT_XY);

    }

}
