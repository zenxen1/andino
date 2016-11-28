package com.sds.study.andino;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by efro2 on 2016-11-25.
 */

public class ItemRightBaloon extends LinearLayout{
    TextView txt_id,txt_content,txt_time;
    ImageView img_profile;
    public ItemRightBaloon(Context context, Speech speech) {
        super(context);
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_right_baloon,this);
        TextView txt_id=(TextView)this.findViewById(R.id.txt_id);
        TextView txt_content=(TextView)this.findViewById(R.id.txt_content);
        TextView txt_time=(TextView)this.findViewById(R.id.txt_time);
        txt_id.setText(speech.getId());
        txt_content.setText(speech.getContent());
        txt_time.setText(speech.getTime());
    }
    public void setdata(Speech speech){
        txt_id.setText(speech.getId());
        txt_content.setText(speech.getContent());
        txt_time.setText(speech.getTime());
    }

}
