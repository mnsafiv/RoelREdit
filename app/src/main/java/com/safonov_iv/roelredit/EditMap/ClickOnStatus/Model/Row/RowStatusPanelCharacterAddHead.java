package com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.RowStatusPanelPreference;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.*;
import com.safonov_iv.roelredit.R;

import java.util.Arrays;

public class RowStatusPanelCharacterAddHead extends RowStatusPanel {
    private StructureTextInt levelText;


    public RowStatusPanelCharacterAddHead(Context context, Paint paintBorderInfo, Paint paintStatusInfo, int groupId) {
        super(context, paintBorderInfo, paintStatusInfo, DefaultValue.addPanel.ROW_SIZE_CHARACTER_ADD_HEAD);
        this.rowStatusPanelPreference = new RowStatusPanelPreference(groupId, messages);

    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(rectCur, paintBorderInfo);
        messages.forEach(t -> t.draw(canvas));
    }

    @Override
    public void update() {

    }


    @Override
    public void shift(int distanceX, int distanceY) {
        System.out.println();
    }

    @Override
    public void init(int height) {
        messages.clear();

        levelText = new StructureTextInt(1, paintStatusInfo, height, 10, 10);
        ActionOnClickImpl increaseButton = new ButtonIncreaseLevelAdd(context, R.drawable.icon_plus_minus, 1, 2, height, levelText);
        ActionOnClickImpl decreaseButton = new ButtonDecreaseLevelAdd(context, R.drawable.icon_plus_minus, 2, 2, height, levelText);

        messages.addAll(Arrays.asList(decreaseButton, levelText,increaseButton));


    }


    public int getLevel() {
        return levelText.getStrInt();
    }
}
