package com.safonov_iv.roelredit.GenerateObject.Component;


import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterModel;
import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;
import com.safonov_iv.roelredit.GenerateObject.Model.GroupTypeDifficult;
import com.safonov_iv.roelredit.GenerateObject.Model.GroupTypeEnvironment;
import com.safonov_iv.roelredit.GenerateObject.Model.GroupTypeGrade;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.Map.Coordinate.Enum.BattleMapType;

import java.util.ArrayList;
import java.util.List;

public class GroupComponent {

    public static MapGroupModel getMapGroupModel(GroupTypeDifficult difficult, GroupTypeEnvironment environment, GroupTypeGrade grade, BattleMapType mapType) {


        final PersonComponent personComponent = GenerateObjectAccess.personComponent;


        List<CharacterModel> playerPersons = new ArrayList<>();


        switch (environment) {
            case easy:
        }
        switch (difficult) {
            case easy001:
                playerPersons.add(personComponent.getGenerateModel("Cup", 10));
                playerPersons.add(personComponent.getGenerateModel("Cup", 10));
                playerPersons.add(personComponent.getGenerateModel("Archer", 10));
                playerPersons.add(personComponent.getGenerateModel("Archer", 10));
                playerPersons.add(personComponent.getGenerateModel("Mage", 5));
                break;
            case easy002:
                playerPersons.add(personComponent.getGenerateModel("Cup", 3));
                playerPersons.add(personComponent.getGenerateModel("Cup", 3));
                playerPersons.add(personComponent.getGenerateModel("Archer", 5));
                playerPersons.add(personComponent.getGenerateModel("Archer", 5));
                playerPersons.add(personComponent.getGenerateModel("Mage", 15));
                break;
            case easy003:
                playerPersons.add(personComponent.getGenerateModel("Cup", 8));
                playerPersons.add(personComponent.getGenerateModel("Cup", 8));
                playerPersons.add(personComponent.getGenerateModel("Archer", 11));
                playerPersons.add(personComponent.getGenerateModel("Archer", 11));
                playerPersons.add(personComponent.getGenerateModel("Warrior", 10));
                break;
            case hard001:
                playerPersons.add(personComponent.getGenerateModel("Archer", 20));
                playerPersons.add(personComponent.getGenerateModel("Mage", 20));
                playerPersons.add(personComponent.getGenerateModel("Warrior", 25));
                playerPersons.add(personComponent.getGenerateModel("LightMage", 20));
                break;
        }

        return new MapGroupModel(playerPersons);
    }

    public static MapGroupModel getMapGroupModel(BattleMapType mapType) {
        final PersonComponent personComponent = PersonComponent.getPersonComponent();
        List<CharacterModel> playerPersons = new ArrayList<>();
        playerPersons.add(personComponent.getGenerateModel("Cup", 10));
        playerPersons.add(personComponent.getGenerateModel("Cup", 10));
        playerPersons.add(personComponent.getGenerateModel("Archer", 10));
        playerPersons.add(personComponent.getGenerateModel("Archer", 10));
        playerPersons.add(personComponent.getGenerateModel("Mage", 5));
        return new MapGroupModel(playerPersons);
    }

}
