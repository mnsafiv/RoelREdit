package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;

import com.safonov_iv.roelredit.GenerateObject.Battle.Calculate.StatsDetail;
import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CharacterModel implements Cloneable, Serializable {
    private final CharacterInfo info;
    private StatsDetail stats;
    private final CharacterSkills skills;



    public CharacterModel(int icon_id, CharacterPrototype characterPrototype, String key, int level) {
        info = new CharacterInfo(1,icon_id,key,
                new CharacterProgress(level, 0,characterPrototype.getCharacterTier()));
        this.stats = GenerateObjectAccess.calculateStats.getStats(characterPrototype, level);
        skills = new CharacterSkills(characterPrototype.getSkills());
    }


    public StatsDetail getStats() {
        return stats;
    }

    @NotNull
    @Override
    public Object clone() throws CloneNotSupportedException {
        CharacterModel characterModel = (CharacterModel) super.clone();
		characterModel.setStats((StatsDetail) stats.clone());
		List<CharacterSkill> characterSkillList = new ArrayList<>();
		skills.getSkills().forEach(t-> {
			try {
				characterSkillList.add((CharacterSkill) t.clone());
			} catch (CloneNotSupportedException e) {
				throw new RuntimeException(e);
			}
		});
		characterModel.getSkills().setSkills(characterSkillList);
        return characterModel;

    }

    public CharacterInfo getInfo() {
        return info;
    }

    public void setStats(StatsDetail stats) {
        this.stats = stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterModel)) return false;
        CharacterModel that = (CharacterModel) o;
        return Objects.equals(info, that.info) && Objects.equals(stats, that.stats);
    }



    @Override
    public int hashCode() {
        return Objects.hash(info, stats);
    }

    public CharacterSkills getSkills() {
        return skills;
    }

    public void addCharacterProgress(int expProgress) {
        info.addProgress(expProgress);

        System.out.println();

    }
}
