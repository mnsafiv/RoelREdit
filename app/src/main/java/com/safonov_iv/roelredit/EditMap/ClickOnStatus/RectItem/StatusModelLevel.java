package com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem;

import android.graphics.Paint;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterProgress;

public class StatusModelLevel extends StructureText {
    private final CharacterProgress info;


    public StatusModelLevel(CharacterProgress info, Paint paintStatusInfo, int height) {
        super(String.valueOf(info.getLevel()), paintStatusInfo, height,10,10);
        this.info = info;
        updateStatus();

    }


    @Override
    public void updateStatus() {
        super.updateStatus();
        super.setStr(String.valueOf(info.getLevel()));
    }


    @Override
    public boolean action() {

        return false;
    }


}
