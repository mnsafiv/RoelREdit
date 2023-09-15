package com.safonov_iv.roelredit.GenerateObject;

import android.content.Context;
import com.safonov_iv.roelredit.GenerateObject.Battle.Calculate.CalculateStats;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusPrototype;
import com.safonov_iv.roelredit.GenerateObject.Component.PersonComponent;
import com.safonov_iv.roelredit.GenerateObject.Component.PrototypeDecor;
import com.safonov_iv.roelredit.GenerateObject.Component.PrototypeGrid;
import com.safonov_iv.roelredit.GenerateObject.Model.CharacterBitmapModel;
import com.safonov_iv.roelredit.GenerateObject.Component.CharacterMap;

public class GenerateObjectAccess {


    public static CharacterMap characterMap;
    public static PrototypeDecor prototypeDecor;
    public static PrototypeGrid prototypeGrid;
    public static PersonComponent personComponent;
    public static CharacterBitmapModel characterBitmapModel;
    public static BonusPrototype bonusPrototype;
    public static CalculateStats calculateStats = new CalculateStats();

    public GenerateObjectAccess(Context context) {
        characterBitmapModel = CharacterBitmapModel.getCharacterBitmapModel();
        prototypeDecor = PrototypeDecor.getPrototypeDecor(context);
        personComponent = PersonComponent.getPersonComponent();
        prototypeGrid = PrototypeGrid.getPrototypeGrid(context);
        bonusPrototype = BonusPrototype.getBonusPrototype();
        characterMap = CharacterMap.getCharacterMap(context);
    }

}
