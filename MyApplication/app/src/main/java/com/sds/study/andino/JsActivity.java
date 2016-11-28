package com.sds.study.andino;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by efro2 on 2016-11-25.
 */

public class JsActivity extends AppCompatActivity {
    ListView listView;
    BaloonAdapter baloonAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsactivity_layout);
        listView=(ListView)findViewById(R.id.listView);
        BaloonAdapter baloonAdapter=new BaloonAdapter(this);
        listView.setAdapter(baloonAdapter);
    }
}
