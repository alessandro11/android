package com.ae11.batterylevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.BatteryManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by m3cool on 23/05/15.
 */
public class BatteryView extends View {
    private Paint rectangle;
    private Paint level;
    private RectF rectF;
    private Paint text;
    private int textWidth;
    private int batt_level;

    public void setBatt_level(int batt_level) {
        this.batt_level = batt_level;
    }

    // Constructor required for in-code creation
    public BatteryView(Context context) {
        super(context);
        init(context);
    }

    // Constructor required for inflation from resource file.
    public BatteryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    // Constructor required for inflation from resource file.
    public BatteryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        rectangle = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectangle.setColor(Color.DKGRAY);
        rectangle.setStrokeWidth(1);
        rectangle.setStyle(Paint.Style.FILL_AND_STROKE);

        level = new Paint(Paint.ANTI_ALIAS_FLAG);
        level.setColor(Color.YELLOW);
        level.setStrokeWidth(2);
        level.setStyle(Paint.Style.FILL_AND_STROKE);

        text = new Paint(Paint.ANTI_ALIAS_FLAG);
        text.setStyle(Paint.Style.FILL_AND_STROKE);
        text.setColor(Color.RED);
        text.setTextSize(30.0f);
        textWidth = (int)level.measureText("100 %");

        rectF = new RectF(0, 0, 0, 0);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureH = measureHeight(heightMeasureSpec);
        int measureW = measureWidth(widthMeasureSpec);

        rectF.bottom = measureH;
        rectF.right = measureW;
        setMeasuredDimension(measureW, measureH);
    }
    private int measureHeight(int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        int result = 300;

        if( specMode != MeasureSpec.UNSPECIFIED ) {
            result = (int)(specSize * 0.6);
        }

        return result;
    }
    private int measureWidth(int widthMeasureSpec) {
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        int result = 50;

        if( specMode != MeasureSpec.UNSPECIFIED ) {
            result = (int)(specSize * 0.4);
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float x, y, h;
        canvas.drawRoundRect(rectF, 20, 20, rectangle);
        x = (rectF.right - textWidth) / 2;
        y = (rectF.bottom - textWidth) / 2;
        h = rectF.bottom * (100.0f - (float)batt_level) / 100.0f;
        canvas.drawRoundRect(0, h, rectF.right, rectF.bottom, 0, 0, level);
        canvas.drawText(String.valueOf(batt_level) + " %", x,  y, text);

        //super.onDraw(canvas);
    }

}
