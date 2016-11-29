package com.sds.study.andino.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.sds.study.andino.R;
import com.sds.study.andino.RoundProfile;

import static android.R.attr.onClick;


/**
 * Created by 석환 on 2016-11-28.
 */

public class MyProfileActivity extends AppCompatActivity {

    RoundProfile profile_pic;
    ImageView imgback;
    ImageButton bt_setting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        profile_pic = (RoundProfile) findViewById(R.id.profile_pic);
        ImageView imgback = (ImageView) findViewById(R.id.imgback);
        imgback.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView profile_pic = (ImageView) findViewById(R.id.profile_pic);
        profile_pic.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageButton bt_setting = (ImageButton) findViewById(R.id.bt_setting);

        profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this,ProfileClick_detailActivity.class);
                startActivity(intent);
            }
        });
        bt_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this,MyProfileDetailActivity.class);
                startActivity(intent);
            }
        });

    }


    }
