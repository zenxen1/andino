package com.sds.study.andino;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by efro2 on 2016-11-25.
 */

public class JsActivity extends AppCompatActivity {
    ListView listView;
    BaloonAdapter baloonAdapter;
    ImageView js_to_invite;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsactivity_layout);
        listView=(ListView)findViewById(R.id.listView);
        BaloonAdapter baloonAdapter=new BaloonAdapter(this);
        listView.setAdapter(baloonAdapter);

        js_to_invite=(ImageView)findViewById(R.id.js_to_invite);

        js_to_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"친구 초대 화면으로 이동",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity_talk.class);
                startActivity(intent);
            }
        });

    }
}
