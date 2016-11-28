package com.sds.study.andino.model.dto;

/**
 * Created by 김승현 on 2016-11-10.
 */

public class FriendData_talk {
    private String title;
    private int icon;
    private String comment;

    public FriendData_talk(int icon, String title){
        this.icon=icon;
        this.title=title;

    }
    public int getIcon(){
        return icon;
    }
    public String getTitle(){
        return title;
    }
    public String getComment(){
        return comment;
    }

}
