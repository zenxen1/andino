package com.sds.study.andino.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.sds.study.andino.R;
import com.sds.study.andino.gesture.uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by 석환 on 2016-11-29.
 */

public class ProfileClick_detailActivity extends ActionBarActivity {

    ImageView viewdetail;
    PhotoViewAttacher mAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profiledetail_click);
        ImageView viewdetail = (ImageView) findViewById(R.id.viewdetail);
      //  viewdetail.setScaleType(ImageView.ScaleType.FIT_XY);
    mAttacher=new PhotoViewAttacher(viewdetail);
        mAttacher.setScaleType(ImageView.ScaleType.FIT_XY);
    }
}
