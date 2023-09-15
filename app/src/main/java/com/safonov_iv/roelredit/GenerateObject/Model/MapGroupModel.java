package com.safonov_iv.roelredit.GenerateObject.Model;


import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterModel;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterProgress;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class MapGroupModel implements Serializable {

    private final long sequence;
    private int iconId;
    private final ModelGroupPersons modelGroupPersons;

    public MapGroupModel(int iconId, List<CharacterModel> modelGroupPersons) {
        this.modelGroupPersons = new ModelGroupPersons(modelGroupPersons);
        this.iconId = iconId;
        this.sequence = ++MapGroupSequence.sequence;
    }

    public MapGroupModel() {
        this.iconId = DefaultValue.NO_EXIST_GROUP;
        this.sequence = ++MapGroupSequence.sequence;
        this.modelGroupPersons = new ModelGroupPersons(new ArrayList<>());
    }

    public MapGroupModel(List<CharacterModel> modelGroupPersons) {
        this.modelGroupPersons = new ModelGroupPersons(modelGroupPersons);
        this.iconId = initIconId();
        this.sequence = ++MapGroupSequence.sequence;
    }

    private int initIconId() {
        if (modelGroupPersons.getPlayerPersons().size() < 1) {
            return DefaultValue.NO_EXIST_GROUP;
        }

        AtomicInteger curGrade = new AtomicInteger(0);
        AtomicInteger curLevel = new AtomicInteger(0);
        AtomicInteger curId = new AtomicInteger(0);
        modelGroupPersons.getPlayerPersons().forEach(t -> {
            CharacterProgress characterProgress = t.getInfo().getCharacterProgress();

            if (curGrade.get() == characterProgress.getCharacterTier().grade
                    && curLevel.get() < characterProgress.getLevel()) {
                curLevel.set(characterProgress.getLevel());
                curId.set(t.getInfo().getIcon_id());
            }
            if (curGrade.get() < characterProgress.getCharacterTier().grade) {
                curGrade.set(characterProgress.getCharacterTier().grade);
                curLevel.set(characterProgress.getLevel());
                curId.set(t.getInfo().getIcon_id());
            }
        });
        return curId.get();
    }

    public ModelGroupPersons getModelGroupPersons() {
        return modelGroupPersons;
    }

    public int getIconId() {
        return iconId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapGroupModel)) return false;
        MapGroupModel that = (MapGroupModel) o;
        return sequence == that.sequence && Objects.equals(modelGroupPersons, that.modelGroupPersons);
    }


    @Override
    public int hashCode() {
        return Objects.hash(sequence, modelGroupPersons);
    }

    public boolean add(CharacterModel characterModel) {
        if (modelGroupPersons.getPlayerPersons().add(characterModel)) {
            this.iconId = initIconId();
            return true;
        }
        return false;

    }

    public boolean remove(CharacterModel characterModel) {
        if (modelGroupPersons.getPlayerPersons().remove(characterModel)) {
            this.iconId = initIconId();
            return true;
        }
        return false;

    }
}
