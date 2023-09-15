package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;

import java.io.Serializable;
import java.util.Objects;

public class CharacterInfo implements Serializable {
    private final long id;
    private final int icon_id;
    private final String name;
    private final CharacterProgress characterProgress;

    public CharacterInfo(long id, int icon_id, String name, CharacterProgress characterProgress) {
        this.id = id;
        this.icon_id = icon_id;
        this.name = name;
        this.characterProgress = characterProgress;
    }

    public CharacterProgress getCharacterProgress() {
        return characterProgress;
    }

    public int getIcon_id() {
        return icon_id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterInfo)) return false;
        CharacterInfo that = (CharacterInfo) o;
        return id == that.id && icon_id == that.icon_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, icon_id);
    }

    public void addProgress(int expProgress) {
        characterProgress.addProgress(expProgress);
    }

}
