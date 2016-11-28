package com.sds.study.andino.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sds.study.andino.R;
import com.sds.study.andino.model.dto.Speech;

/**
 * Created by efro2 on 2016-11-25.
 */

public class ItemLeftBaloon extends LinearLayout{
    TextView txt_id,txt_content,txt_time;
    ImageView img_profile;
    Context context;
    String TAG;
    public ItemLeftBaloon(Context context,Speech speech) {
        super(context);
        this.context=context;
        TAG=getClass().getName();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_left_baloon,this);
        txt_id=(TextView)this.findViewById(R.id.txt_id);
        txt_content=(TextView)this.findViewById(R.id.txt_content);
        txt_time=(TextView)this.findViewById(R.id.txt_time);
        img_profile=(ImageView)this.findViewById(R.id.img_profile);
        setdata(speech);
    }
    public void setdata(Speech speech){
        txt_id.setText(speech.getId());
        txt_content.setText(speech.getContent());
        txt_time.setText(speech.getTime());
        img_profile.setImageResource(R.drawable.batman);
    }

}
