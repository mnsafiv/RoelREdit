package com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.RowStatusPanelPreference;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.*;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.GenerateObject.Model.ModelProperties;
import com.safonov_iv.roelredit.GenerateObject.Component.PersonComponent;

public class RowStatusPanelCharacterAdd extends RowStatusPanel {

    private String name;
    private ModelProperties value;
    private RowStatusPanelCharacterAddHead rowStatusPanelCharacterAddHead;
    private MapGroupModel mapGroup;

    public RowStatusPanelCharacterAdd(Context context, RowStatusPanelCharacterAddHead rowStatusPanelCharacterAddHead, String name, ModelProperties value, MapGroupModel mapGroup, Paint paintBorderInfo, Paint paintStatusInfo, int groupId) {
        super(context, paintBorderInfo, paintStatusInfo, DefaultValue.addPanel.ROW_SIZE_CHARACTER_ADD);
        this.rowStatusPanelCharacterAddHead = rowStatusPanelCharacterAddHead;
        this.mapGroup = mapGroup;
        this.rowStatusPanelPreference = new RowStatusPanelPreference(groupId,messages);
        this.name = name;
        this.value = value;

    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(rectCur, paintBorderInfo);
        messages.forEach(t -> t.draw(canvas));
    }


    @Override
    public void shift(int distanceX, int distanceY) {
        rectCur.offsetTo(rectCur.left, rectCur.top + distanceY);
        messages.forEach(t -> t.shiftY(distanceY));

    }

    @Override
    public void drawPart(Canvas canvas) {
        canvas.drawRect(rectCur, paintBorderInfo);

    }

    @Override
    public boolean action() {
        mapGroup.getModelGroupPersons().getPlayerPersons().add(PersonComponent.getPersonComponent().getGenerateModel(name, rowStatusPanelCharacterAddHead.getLevel()));
        return true;
    }

    @Override
    public void init(int height) {
        messages.clear();
        ActionOnClickImpl bitmap = new StructureBitmap(value.getId_bitmap(), height);
        ActionOnClickImpl nameText = new StructureText(name, paintStatusInfo, height, 10, 10);
        messages.add(bitmap);
        messages.add(nameText);
    }
}
