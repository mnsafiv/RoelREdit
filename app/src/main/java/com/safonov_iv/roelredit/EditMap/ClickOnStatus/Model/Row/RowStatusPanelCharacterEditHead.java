package com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.RowStatusPanelPreference;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.ActionOnClickImpl;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.StructureText;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.StatusModelItem;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;

import java.util.List;

public class RowStatusPanelCharacterEditHead extends RowStatusPanel {
    private final String backGround;
    private final String coordinate;
    private StatusModelItem statusModelCharacterEdit;


    public RowStatusPanelCharacterEditHead(Context context, StatusModelItem statusModelCharacterEdit, MapValue mapValue, Paint paintBorderInfo, Paint paintStatusInfo, int groupId) {
        super(context, paintBorderInfo, paintStatusInfo, DefaultValue.editPanel.ROW_SIZE_CHARACTER_EDIT_HEAD);
        this.statusModelCharacterEdit = statusModelCharacterEdit;
        this.rowStatusPanelPreference = new RowStatusPanelPreference(groupId, messages);

        backGround = String.valueOf(mapValue.getValue());
        coordinate = String.valueOf(mapValue.getCoordinate());

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
        ActionOnClickImpl nameText = new StructureText(backGround, paintStatusInfo, height, 10, 10);
        ActionOnClickImpl nameCoordinate = new StructureText(coordinate, paintStatusInfo, height, 10, 10);
        messages.add(nameText);
        messages.add(nameCoordinate);
    }


}
