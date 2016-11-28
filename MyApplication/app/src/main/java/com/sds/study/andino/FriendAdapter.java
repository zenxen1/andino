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

public class FriendAdapter extends BaseAdapter {

    private Context mContext=null;
    private ArrayList<FriendData> gData=new ArrayList<FriendData>();
    public FriendAdapter(Context context){
        this.mContext = context;
    }

    public void addItem(FriendData gd){
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

        ItemView itemView;
        if(converView ==null){
           // converView = inflater.inflate(this.layout, parent, false);
            itemView = new ItemView(mContext,gData.get(position));
        }else {
            itemView = (ItemView) converView;
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
