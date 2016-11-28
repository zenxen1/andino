package com.sds.study.andino;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by 김승현 on 2016-11-10.
 */

public class FriendAdapter_talk extends BaseAdapter {

    private Context mContext=null;
    private ArrayList<FriendData_talk> gData=new ArrayList<FriendData_talk>();
    public FriendAdapter_talk(Context context){
        this.mContext = context;
    }

    public void addItem(FriendData_talk gd){
        gData.add(gd);
    }

    //아이템의  갯수를 리턴
    @Override
    public int getCount() {
        return gData.size();
    }

    public Object getItem(int position){
        return gData.get(position).getTitle();
    }

    public long getItemId(int position){
        return position;
    }
    public View getView(int position, View converView, ViewGroup parent){

        ItemView_talk itemView;
        if(converView ==null){
           // converView = inflater.inflate(this.layout, parent, false);
            itemView = new ItemView_talk(mContext,gData.get(position));
        }else {
            itemView = (ItemView_talk) converView;
        }
            itemView.setmIcon(gData.get(position).getIcon());
            itemView.setTitle(gData.get(position).getTitle());
            //itemView.setComment(gData.get(position).getComment());


        if((position%2)==1){

            itemView.setBackgroundColor(Color.CYAN);
        }else{

            itemView.setBackgroundColor(Color.RED);
        }

        return itemView;

    }

}
