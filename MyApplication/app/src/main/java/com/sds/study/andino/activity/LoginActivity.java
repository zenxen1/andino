package com.sds.study.andino.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sds.study.andino.R;

/**
 * Created by 김승현 on 2016-11-30.
 */

public class LoginActivity extends AppCompatActivity {
    String TAG;
    Button bt,login_to_regist;
    EditText idInput, passInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=getClass().getName();
        setContentView(R.layout.login_layout);



        bt=(Button) findViewById(R.id.login_to_main);
        login_to_regist=(Button)findViewById(R.id.login_to_regist);
        idInput=(EditText)findViewById(R.id.idInput);
        passInput=(EditText)findViewById(R.id.passwordInput);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //로그인 누르면 서버를 통해 DB의 회원가입 상황과 비교

               /* StringBuffer sb = new StringBuffer();
                sb.append("{");
                sb.append("\"title\":\"login\",");
                sb.append("\"id\":\""+idInput.getText().toString()+"\",");
                sb.append("\"password\":\""+passInput.getText().toString()+"\"");
                sb.append("}");
                //RoomActivity.clientThread.sendMsg(sb.toString());*/

                Intent intent = new Intent(getApplicationContext(), RoomActivity.class);
                startActivity(intent);
            }
        });

        login_to_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistActivity.class);
                startActivity(intent);
            }
        });


    }
}
