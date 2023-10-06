package com.safonov_iv.roelredit.EditMap.PanelItem.Panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row.*;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.ActionOnClick;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.ActionOnClickImpl;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.StatusModelItem;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.PanelInt;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.StatusModelItemCharacterAdd;
import com.safonov_iv.roelredit.GenerateObject.Model.CharacterBitmapModel;
import com.safonov_iv.roelredit.GenerateObject.Model.ModelProperties;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.R;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.*;

public class AddGroupMapValue implements PanelInt {
    private final Map<String, ModelProperties> characterBitmaps;
    private final Paint paintBorderInfo;
    private final Paint paintStatusInfo;
    private final StatusModelItem statusModelCharacterAdd;
    private final Context context;
    private final MapValue mapValue;
    private final EditGroupMapValue editGroupMapValue;

    public AddGroupMapValue(Context context, MapValue mapValue, EditGroupMapValue editGroupMapValue) {
        this.context = context;
        this.mapValue = mapValue;
        this.editGroupMapValue = editGroupMapValue;
        this.characterBitmaps = CharacterBitmapModel.getInstance().getCharacterBitmaps();

        paintBorderInfo = new Paint();
        paintBorderInfo.setColor(ContextCompat.getColor(context, R.color.ColorBorderStatus));
        paintStatusInfo = new Paint();
        paintStatusInfo.setTextSize((float) Setting.getInstance().getCurrentWidth() / 100 * 2);
        paintStatusInfo.setColor(ContextCompat.getColor(context, R.color.ColorTextStatus));

        statusModelCharacterAdd = new StatusModelItemCharacterAdd(context, DefaultValue.addPanel.ROW_NUMBER_CHARACTER_ADD);

        updateStatus();


    }


    private void updateStatus() {

        statusModelCharacterAdd.reset();

        int screenX = Setting.getInstance().getCurrentWidth();
        int screenY = Setting.getInstance().getCurrentHeight();

        int rectWidth = (int) (screenX * DefaultValue.addPanel.ROW_MULTIPLIER_SIZE_WIDTH_CHARACTER_ADD);
        int rectHeight = (int) (screenY * DefaultValue.addPanel.ROW_MULTIPLIER_SIZE_HEIGHT_CHARACTER_ADD);

        int groupIdHead = 1;
        int groupIdEnd = 2;
        int groupIdRow = 3;


        //init head
        //init end
        Paint paintBorderHeadEnd = new Paint();
        paintBorderHeadEnd.setColor(ContextCompat.getColor(context, R.color.ColorBorderEnd));
        final RowStatusPanelCharacterAddHead rowStatusPanelCharacterAddHead = new RowStatusPanelCharacterAddHead(context, paintBorderHeadEnd, paintStatusInfo, groupIdHead);
        statusModelCharacterAdd.addHead(rowStatusPanelCharacterAddHead);
        statusModelCharacterAdd.addEnd(new RowStatusPanelCharacterAddEnd(context, statusModelCharacterAdd, paintBorderHeadEnd, paintStatusInfo, groupIdEnd));

        //init detail
        characterBitmaps.forEach((key, value) -> statusModelCharacterAdd.addRow(
                new RowStatusPanelCharacterAdd(context, rowStatusPanelCharacterAddHead, key, value, mapValue.getMapGroup(), paintBorderInfo, paintStatusInfo, groupIdRow)
        ));

        //left-bottom
        Rect rectStatus = new Rect(0, 0, rectWidth, rectHeight);
        int margin = 10;
        rectStatus.offsetTo(2400 - rectWidth, screenY - rectHeight - margin * 2);
        statusModelCharacterAdd.setBorder(rectStatus, margin, DefaultValue.addPanel.ROW_MULTIPLIER_SIZE_HEIGHT_CHARACTER_ADD);


    }


    @Override
    public boolean getCollision(int positionX, int positionY) {
        final RowStatusPanel row = statusModelCharacterAdd.getCollisionRow(positionX, positionY);






        if (row != null) {
            if (!row.action()) {
                final Optional<ActionOnClickImpl> first = row.getMessages().stream()
                        .filter(t -> t.getCollision(positionX, positionY)).findFirst();
                first.ifPresent(ActionOnClick::action);
            } else {
                editGroupMapValue.updateStatus();
            }
            return true;

        }


        return false;
    }




    @Override
    public void shift(int distanceX, int distanceY) {
        statusModelCharacterAdd.shift(distanceX, distanceY);

    }

    @Override
    public boolean getAction() {
        return false;
    }

    public void draw(Canvas canvas) {
        statusModelCharacterAdd.draw(canvas);
    }


    public void reset() {

    }


    public void update() {
        statusModelCharacterAdd.update();
    }


}
