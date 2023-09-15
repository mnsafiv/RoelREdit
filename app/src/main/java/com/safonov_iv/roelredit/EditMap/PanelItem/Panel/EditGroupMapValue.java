package com.safonov_iv.roelredit.EditMap.PanelItem.Panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row.*;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.ActionOnClick;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.StatusModelItem;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.PanelInt;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.StatusModelItemCharacterEdit;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.GenerateObject.Model.ModelGroupPersons;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.R;
import com.safonov_iv.roelredit.Common.Setting;

public class EditGroupMapValue implements PanelInt {


    private final Paint paintBorderInfo;
    private final Paint paintStatusInfo;
    private StatusModelItem statusModelCharacterEdit;
    private final Context context;
    private final MapValue mapValue;


    public EditGroupMapValue(Context context, MapValue mapValue) {
        this.context = context;
        this.mapValue = mapValue;

        paintBorderInfo = new Paint();
        paintBorderInfo.setColor(ContextCompat.getColor(context, R.color.ColorBorderStatus));
        paintStatusInfo = new Paint();
        paintStatusInfo.setTextSize(Setting.getSetting().getCurrentWidth() / 100 * 2);
        paintStatusInfo.setColor(ContextCompat.getColor(context, R.color.ColorTextStatus));

        updateStatus();


    }

    public void updateStatus() {
        StatusModelItem statusModelCharacterEdit = new StatusModelItemCharacterEdit(context, DefaultValue.editPanel.ROW_NUMBER_CHARACTER_EDIT);

        if (mapValue.getMapGroup() == null) {
            mapValue.setMapGroup(new MapGroupModel());
        }

        final ModelGroupPersons modelGroupPersons = mapValue.getMapGroup().getModelGroupPersons();


        int screenX = Setting.getSetting().getCurrentWidth();
        int screenY = Setting.getSetting().getCurrentHeight();

        int rectWidth = (int) (screenX * DefaultValue.editPanel.ROW_MULTIPLIER_SIZE_WIDTH_CHARACTER_EDIT);
        int rectHeight = (int) (screenY * DefaultValue.editPanel.ROW_MULTIPLIER_SIZE_HEIGHT_CHARACTER_EDIT);


        //init head
        //init end

        Paint paintBorderHeadEnd = new Paint();
        paintBorderHeadEnd.setColor(ContextCompat.getColor(context, R.color.ColorBorderEnd));

        int groupIdHead = 1;
        RowStatusPanel headCharacterModelStatusEdit = new RowStatusPanelCharacterEditHead(context, statusModelCharacterEdit, mapValue, paintBorderHeadEnd, paintStatusInfo, groupIdHead);
        RowStatusPanel endCharacterModelStatusEdit = new RowStatusPanelCharacterEditEnd(context, statusModelCharacterEdit, paintBorderHeadEnd, paintStatusInfo, groupIdHead);
        statusModelCharacterEdit.addHead(headCharacterModelStatusEdit);
        statusModelCharacterEdit.addEnd(endCharacterModelStatusEdit);


        //init detail
        int groupIdRow = 2;
        modelGroupPersons.getPlayerPersons().forEach(t -> statusModelCharacterEdit.addRow(
                new RowStatusPanelCharacterEdit(context, mapValue.getMapGroup(), t, paintBorderInfo, paintStatusInfo, groupIdRow)
        ));

        Rect rectStatus = new Rect(0, 0, rectWidth, rectHeight);
        int margin = 10;
        rectStatus.offsetTo(margin, screenY - rectHeight - margin * 2);
        statusModelCharacterEdit.setBorder(rectStatus, margin, DefaultValue.editPanel.ROW_MULTIPLIER_SIZE_HEIGHT_CHARACTER_EDIT);

        this.statusModelCharacterEdit = statusModelCharacterEdit;


    }


    @Override
    public boolean getCollision(int positionX, int positionY) {
        if (statusModelCharacterEdit.getRectBorder().contains(positionX, positionY)) {
            final ActionOnClick collision = statusModelCharacterEdit.getCollision(positionX, positionY);
            if (collision != null) {
                if (collision.action()) {
                    updateStatus();
                }

            }
            return true;
        }


        return false;
    }

    @Override
    public void shift(int distanceX, int distanceY) {
        statusModelCharacterEdit.shift(distanceX, distanceY);

    }

    @Override
    public boolean getAction(MapPrototype map) {
        return false;
    }

    public void draw(Canvas canvas) {
        statusModelCharacterEdit.draw(canvas);
    }


    public void reset() {

    }


    public void update() {
        statusModelCharacterEdit.update();
    }
}
