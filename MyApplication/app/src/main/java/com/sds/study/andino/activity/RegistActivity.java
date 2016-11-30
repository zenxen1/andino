package com.sds.study.andino.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sds.study.andino.R;

/**
 * Created by 김승현 on 2016-11-30.
 */

public class RegistActivity extends AppCompatActivity{

    Button bt;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.regist_layout);

        bt=(Button) findViewById(R.id.regist_to_login);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
