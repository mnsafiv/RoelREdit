package com.safonov_iv.roelredit.GenerateObject.Model;



import com.safonov_iv.roelredit.R;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CharacterBitmapModel {
    private static volatile CharacterBitmapModel characterBitmapModel;
    private final ConcurrentHashMap<String, ModelProperties> characterBitmaps = new ConcurrentHashMap<>();


    private CharacterBitmapModel() {
        characterBitmaps.put("Archer", new ModelProperties(R.drawable.character_archer_001, 3003, 1, 2));
        characterBitmaps.put("Cup", new ModelProperties(R.drawable.character_cup_001, 2001, 1, 2));
        characterBitmaps.put("Mage", new ModelProperties(R.drawable.character_girl_mage_001, 3001, 1, 2));
        characterBitmaps.put("Warrior", new ModelProperties(R.drawable.character_girl_warrior_001, 3002, 1, 2));
        characterBitmaps.put("LightMage", new ModelProperties(R.drawable.character_girl_mage_002, 3004, 1, 2));
    }

    public static CharacterBitmapModel getCharacterBitmapModel() {
        if(characterBitmapModel==null){
            characterBitmapModel=new CharacterBitmapModel();
        }
        return characterBitmapModel;
    }

    public Integer getBitmapId(String key) {
        return characterBitmaps.get(key).getId_bitmap();
    }


    public Integer getId(String key) {
        return characterBitmaps.get(key).getId();
    }


    public Map<String, ModelProperties> getCharacterBitmaps() {
        return characterBitmaps;
    }


}
