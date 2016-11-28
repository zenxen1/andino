package com.sds.study.andino;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by efro2 on 2016-11-25.
 */

public class BaloonAdapter extends BaseAdapter {
    ArrayList<Speech> list=new ArrayList<Speech>();
    JsActivity jsActivity;
    String TAG;
    public BaloonAdapter(JsActivity jsActivity) {
        this.jsActivity = jsActivity;
        TAG=getClass().getName();
        Speech speech = new Speech();
        speech.setId("지석");
        speech.setContent("이젠 파일 직접 올리지 않습니다. \n메일주소 적어주시면 보내드릴게요..\n" +
                "어떤분이 다른동에 가셔서 자기거인냥");
        speech.setTime("12:42");
        for (int i=0;i<8;i++) {
            list.add(speech);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Speech dto=(Speech) list.get(i);
        if(0==(i%2.0)){
            Log.d(TAG,"1");
            view=new ItemRightBaloon(jsActivity,dto);
        }else {
            Log.d(TAG,"2");
            view=new ItemLeftBaloon(jsActivity,dto);
        }
        return view;
    }
}
