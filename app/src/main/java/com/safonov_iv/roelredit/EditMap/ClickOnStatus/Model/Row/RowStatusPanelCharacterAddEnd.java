package com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.RowStatusPanelPreference;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.StatusModelItem;

public class RowStatusPanelCharacterAddEnd extends RowStatusPanel {


    private StatusModelItem statusModelCharacterEdit;


    public RowStatusPanelCharacterAddEnd(Context context, StatusModelItem statusModelCharacterEdit, Paint paintBorderInfo, Paint paintStatusInfo, int groupId) {
        super(context, paintBorderInfo, paintStatusInfo, DefaultValue.addPanel.ROW_SIZE_CHARACTER_ADD_END);
        this.statusModelCharacterEdit = statusModelCharacterEdit;
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
    }


}
