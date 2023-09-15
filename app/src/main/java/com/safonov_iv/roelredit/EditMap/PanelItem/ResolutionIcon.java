package com.safonov_iv.roelredit.EditMap.PanelItem;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.PanelInt;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.R;

public class ResolutionIcon implements PanelInt {
    private final Paint paintBorder;
    private final Paint paintBase;
    private final Paint paintShift;
    private final Rect rect;
    private final Rect rectBase;
    private final Rect rectShift;
    private double resolution = 1.0;

    private int positionX;
    private final int positionY;
    private final int positionMax;
    private final int positionMin;
    private final int size;

    public ResolutionIcon(Context context, int positionX, int positionY, int size, int radius) {
        this.size = size;
        int margin = 2;
        rectBase = new Rect(positionX, positionY, positionX + size, positionY + size / 5);
        rect = new Rect(positionX + margin, positionY + margin, positionX + size - margin, positionY + size / 5 - margin);


        positionY -= radius;
        positionMin = positionX + radius;
        this.positionX = positionX + radius;
        this.positionY = positionY;
        positionMax = positionX - radius * 2 + size;


        rectShift = new Rect(0, 0, radius, size / 5 + radius * 2);


        rectShift.offsetTo((positionMin + positionMax) / 2, positionY);



        paintBorder = new Paint();
        paintBorder.setColor(ContextCompat.getColor(context, R.color.ColorResolutionBorder));

        paintBase = new Paint();
        paintBase.setColor(ContextCompat.getColor(context, R.color.ColorResolutionBase));

        paintShift = new Paint();
        paintShift.setColor(ContextCompat.getColor(context, R.color.ColorResolutionShift));


    }


    public void draw(Canvas canvas) {

        canvas.drawRect(rectBase, paintBase);
        canvas.drawRect(rect, paintBorder);
        canvas.drawRect(rectShift, paintShift);
    }


    @Override
    public boolean getCollision(int positionX, int positionY) {
        return rectBase.contains(positionX, positionY);
    }

    @Override
    public void shift(int distanceX, int distanceY) {
        if (distanceX > 100) {
            return;
        }


        positionX += distanceX;


        if (positionX > positionMax) {
            positionX = positionMax;
        }
        if (positionX < positionMin) {
            positionX = positionMin;
        }

        rectShift.offsetTo(positionX, positionY);

        resolution = (double) (positionX - positionMin) / (double) (positionMax - positionMin) + 0.5;


    }

    @Override
    public boolean getAction(MapPrototype map) {
        return false;
    }

    public double getResolution() {
        return resolution;
    }
}
