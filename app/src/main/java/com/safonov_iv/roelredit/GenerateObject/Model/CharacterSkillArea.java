package com.safonov_iv.roelredit.GenerateObject.Model;


import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.SkillArea;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public final class CharacterSkillArea {
    private static CharacterSkillArea characterSkillArea;
    private Map<String, SkillArea> skillAreas;

    public static CharacterSkillArea getInstance() {
        if(characterSkillArea==null){
            characterSkillArea=new CharacterSkillArea();
        }
        return characterSkillArea;
    }

    public CharacterSkillArea() {
        skillAreas = new HashMap<>();

        skillAreas.put("base",new SkillArea(Collections.singletonList(true)));
        skillAreas.put("advance",new SkillArea(Arrays.asList(true,true,true)));
        skillAreas.put("circle",new SkillArea(Arrays.asList(false,true,true,true,true,true,true)));
    }

    private void init(){
        skillAreas = new HashMap<>();

        skillAreas.put("base",new SkillArea(Collections.singletonList(true)));
        skillAreas.put("advance",new SkillArea(Arrays.asList(true,true,true)));
        skillAreas.put("circle",new SkillArea(Arrays.asList(false,true,true,true,true,true,true)));
    }

    public SkillArea getSkillAreas(String key) {
        return skillAreas.get(key);
    }
}
