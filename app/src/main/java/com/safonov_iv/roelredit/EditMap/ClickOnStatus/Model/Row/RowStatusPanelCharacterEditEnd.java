package com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.RowStatusPanelPreference;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.ActionOnClickImpl;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.StatusModelItem;

import java.util.List;

public class RowStatusPanelCharacterEditEnd extends RowStatusPanel {


    private StatusModelItem statusModelCharacterEdit;


    public RowStatusPanelCharacterEditEnd(Context context, StatusModelItem statusModelCharacterEdit, Paint paintBorderInfo, Paint paintStatusInfo, int groupId) {
        super(context, paintBorderInfo, paintStatusInfo, DefaultValue.editPanel.ROW_SIZE_CHARACTER_EDIT_END);
        this.statusModelCharacterEdit = statusModelCharacterEdit;
        rowStatusPanelPreference = new RowStatusPanelPreference(groupId, messages);

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
