package com.safonov_iv.roelredit.Raw;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.R;
import com.safonov_iv.roelredit.Common.Setting;

public class SaveMapIcon extends IconProperties{
    private int colorActive;
    private int colorNoActive;
    private boolean useActivePoint;

    public SaveMapIcon(Context context, Setting setting) {
        super(setting.getCamera().getCursor());
        positionX = Setting.getInstance().getCurrentWidth() * 7 / 10;
        positionY = Setting.getInstance().getCurrentHeight() * 14 / 15;


        bitmapIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_use_active_point);
        colorNoActive = ContextCompat.getColor(context, R.color.borderNoUseActivePoint);
        colorActive = ContextCompat.getColor(context, R.color.borderUseActivePoint);
        bitmapRect = new Rect(0, 0, bitmapIcon.getWidth(), bitmapIcon.getHeight());
        bitmapIcon = Utils.changeColor(bitmapIcon, colorActive, 0);

        positionX = Setting.getInstance().getCurrentWidth();
        positionY = Setting.getInstance().getCurrentHeight() - bitmapIcon.getHeight()*2;





    }




    public void updateIconActive(boolean useActivePoint) {
        if(this.useActivePoint!=useActivePoint) {
            this.useActivePoint = useActivePoint;

            if(useActivePoint) {
                bitmapIcon = Utils.changeColor(bitmapIcon, colorNoActive, colorActive);
            }
            else {
                bitmapIcon = Utils.changeColor(bitmapIcon, colorActive, colorNoActive);
            }



        }
    }


}
