package com.sds.study.andino;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
/**
 * Created by 석환 on 2016-11-28.
 */


public class RoundProfile extends ImageView {

    // 라운드처리 강도 값을 크게하면 라운드 범위가 커짐
    public static float radius = 18.0f;

    public RoundProfile(Context context) {
        super(context);
    }

    public RoundProfile(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundProfile(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
70
    @Override
    protected void onDraw(Canvas canvas) {
        Path clipPath = new Path();
        RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}