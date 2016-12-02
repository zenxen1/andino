package com.sds.study.andino.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sds.study.andino.R;
import com.sds.study.andino.network.ClientThread;

/**
 * Created by 김승현 on 2016-11-30.
 */

public class RegistActivity extends AppCompatActivity {
    String TAG;
    Button bt;
    EditText name, regist_id, regist_pass, regist_email;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=getClass().getName();
        setContentView(R.layout.regist_layout);

        name = (EditText) findViewById(R.id.name);
        regist_id = (EditText) findViewById(R.id.regist_id);
        regist_pass = (EditText) findViewById(R.id.regist_pass);
        regist_email = (EditText) findViewById(R.id.regist_email);

        bt = (Button) findViewById(R.id.regist_to_login);

        bt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                /*StringBuffer sb = new StringBuffer();
                sb.append("{");
                sb.append("\"title\":\"regist\",");
                sb.append("\"name\":\"" + name.getText().toString() + "\",");
                sb.append("\"id\":\"" + regist_id.getText().toString() + "\",");
                sb.append("\"password\":\"" + regist_pass.getText().toString() + "\",");
                sb.append("\"email\":\"" + regist_email.getText().toString() + "\"");
                sb.append("}");

                Log.d(TAG,sb.toString());*/


                enroll();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void enroll(){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"title\":\"regist\",");
        sb.append("\"name\":\"" + name.getText().toString() + "\",");
        sb.append("\"id\":\"" + regist_id.getText().toString() + "\",");
        sb.append("\"password\":\"" + regist_pass.getText().toString()+ "\",");
        sb.append("\"nickname\":\"" + regist_email.getText().toString()+"\"");
        sb.append("}");

        Log.d(TAG,sb.toString());
        ClientThread.getInstance().sendMsg(sb.toString());
    }

}
