package com.sds.study.andino.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.sds.study.andino.R;
import com.sds.study.andino.RoundProfile;
import com.sds.study.andino.network.ClientThread;

import static com.sds.study.andino.R.id.profile_pic;

/**
 * Created by 석환 on 2016-11-29.
 */

public class MyProfileDetailActivity extends AppCompatActivity {

    ImageView imgbackground;
    RoundProfile roundProfile;
    ImageButton bt_nickname;
    EditText txt_nickname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_detail);
        imgbackground = (ImageView) findViewById(R.id.imgback);
        imgbackground.setScaleType(ImageView.ScaleType.FIT_XY); //꽉채우기.
        ImageView roundProfile = (ImageView) findViewById(R.id.roundProfile);
        roundProfile.setScaleType(ImageView.ScaleType.FIT_XY);
        txt_nickname = (EditText) findViewById(R.id.txt_nickname);
        bt_nickname = (ImageButton) findViewById(R.id.bt_nickname);
        bt_nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer();
                sb.append("{");
                sb.append("\"title\":\"nickname\",");
                sb.append("\"nickname\":\"" + txt_nickname.getText().toString() + "\",");
                sb.append("\"member_id \":\"" + "1" + "\"");
                sb.append("}");
                ClientThread.getInstance().sendMsg(sb.toString());
            }
        });
    }


}
