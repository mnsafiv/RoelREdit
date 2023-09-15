package com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterModel;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.RowStatusPanelPreference;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.*;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.R;

import java.util.Arrays;

public class RowStatusPanelCharacterEdit extends RowStatusPanel {

    private MapGroupModel mapGroupModel;
    private CharacterModel characterModel;

    public RowStatusPanelCharacterEdit(Context context, MapGroupModel mapGroupModel, CharacterModel characterModel, Paint paintBorder, Paint paintStatusInfo, int groupId) {
        super(context, paintBorder, paintStatusInfo, DefaultValue.editPanel.ROW_SIZE_CHARACTER_EDIT);
        this.mapGroupModel = mapGroupModel;
        this.characterModel = characterModel;
        this.rowStatusPanelPreference = new RowStatusPanelPreference(groupId,messages);

    }






    @Override
    public void draw(Canvas canvas) {
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
    public void init(int height) {
        messages.clear();
        ActionOnClickImpl bitmap = new StructureBitmap(characterModel.getInfo().getIcon_id(), height);
        ActionOnClickImpl nameText = new StructureText(characterModel.getInfo().getName(), paintStatusInfo, height, 10, 10);
        ActionOnClickImpl levelText = new StatusModelLevel(characterModel.getInfo().getCharacterProgress(), paintStatusInfo, height);
        ActionOnClickImpl increaseButton = new ButtonIncreaseLevelEdit(context, R.drawable.icon_plus_minus, 1, 2, height, characterModel, levelText);
        ActionOnClickImpl decreaseButton = new ButtonDecreaseLevelEdit(context, R.drawable.icon_plus_minus, 2, 2, height, characterModel, levelText);
        ActionOnClickImpl removeButton = new ButtonRemove(context, R.drawable.remove_edit, 1, 1, height, mapGroupModel, characterModel);
        messages.addAll(Arrays.asList(bitmap,nameText,levelText,increaseButton,decreaseButton,removeButton));
    }


}
