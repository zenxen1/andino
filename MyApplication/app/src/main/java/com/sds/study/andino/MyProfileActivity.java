package com.sds.study.andino;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


/**
 * Created by 석환 on 2016-11-28.
 */

public class MyProfileActivity extends AppCompatActivity {

    RoundProfile profile_pic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        profile_pic = (RoundProfile)findViewById(R.id.profile_pic);

    }
}
