package com.sds.study.andino.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sds.study.andino.R;
import com.sds.study.andino.network.ClientThread;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by 김승현 on 2016-11-30.
 */

public class LoginActivity extends AppCompatActivity {
    String TAG;
    Button bt,login_to_regist;
    EditText idInput, passInput;
    public static Socket socket;
    public static ClientThread clientThread;//서버 요청시  사용 할것
    String ip = "192.168.0.38";//필요한 아이피로 바꿀것
    int port = 9090;
    public static LoginActivity loginActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginActivity=this;
        TAG=getClass().getName();
        connect();
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
    //서버와 연결
    public void connect() {
        if (socket==null) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        socket = new Socket(ip, port);//서버 연결
                        clientThread = ClientThread.getInstance();
                        clientThread.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }
}
