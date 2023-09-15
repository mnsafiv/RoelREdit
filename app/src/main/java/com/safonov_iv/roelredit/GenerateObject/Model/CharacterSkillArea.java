package com.safonov_iv.roelredit.GenerateObject.Model;


import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.SkillArea;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class CharacterSkillArea {
    private static Map<String, SkillArea> skillAreas;


    private static void init(){
        skillAreas = new HashMap<>();
        List<Boolean> area = Arrays.asList(true);

        System.out.println();
        skillAreas.put("base",new SkillArea(area));



        area = Arrays.asList(true,true,true);
        skillAreas.put("advance",new SkillArea(area));

        area = Arrays.asList(false,true,true,true,true,true,true);
        skillAreas.put("circle",new SkillArea(area));
    }

    public static SkillArea getSkillAreas(String key) {
        if(skillAreas==null){
            init();
        }

        return skillAreas.get(key);
    }
}
