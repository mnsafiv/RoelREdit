package com.safonov_iv.roelredit.EditMap.ClickOnStatus;

import android.content.Context;
import android.graphics.Canvas;
public final class StatusModelItemCharacterEdit extends StatusModelItem {

    private int distance = 0;
    private int maxDistance;
    private int vectorY = 0;

    public StatusModelItemCharacterEdit(Context context, int positionMax) {
        super(context, positionMax);

    }



    @Override
    public void draw(Canvas canvas) {

        canvas.drawRect(rectBorder, paintBorder);
        canvas.drawRect(rectBase, paintBase);

        rowModelItems.getDetailInfo().forEach(entry -> {
            if (rectBaseControl.contains(entry.getRect())) {
                entry.draw(canvas);
            }
        });

        headModel.draw(canvas);
        endModel.draw(canvas);

    }

    @Override
    protected void initBaseRect() {
        super.initBaseRect();
        maxDistance = rowModelItems.getHeight() - rowModelItems.getRectBase().height();
    }


    @Override
    public void shift(int distanceX, int distanceY) {
        distance += -distanceY;
        int speed = 5;
        rowModelItems.getDetailInfo().forEach(entry -> entry.shift(distanceX, distanceY));

        if (distance < 0) {
            vectorY = distance > -speed ? distance : -speed;
        } else if (distance > maxDistance) {
            vectorY = speed;
        } else vectorY = 0;


    }


    @Override
    public void update() {
        if (vectorY != 0) {
            shift(0, vectorY);

        }

    }


}
