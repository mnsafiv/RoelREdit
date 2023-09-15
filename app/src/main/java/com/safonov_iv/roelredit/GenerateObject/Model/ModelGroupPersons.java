package com.safonov_iv.roelredit.GenerateObject.Model;


import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterModel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ModelGroupPersons implements Serializable {
    private final List<CharacterModel> playerPersons;

    public ModelGroupPersons(List<CharacterModel> playerPersons) {
        this.playerPersons = playerPersons;
    }

    public List<CharacterModel> getPlayerPersons() {
        return playerPersons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelGroupPersons)) return false;
        ModelGroupPersons that = (ModelGroupPersons) o;
        return Objects.equals(playerPersons, that.playerPersons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerPersons);
    }
}
