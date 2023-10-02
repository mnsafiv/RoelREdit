package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;

import com.safonov_iv.roelredit.GenerateObject.Battle.Calculate.CalculateStats;
import com.safonov_iv.roelredit.GenerateObject.Battle.Calculate.StatsDetail;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
public class CharacterModel implements Cloneable, Serializable {
    private final CharacterInfo info;
    private StatsDetail stats;
    private final CharacterSkills skills;



    public CharacterModel(int icon_id, CharacterPrototype characterPrototype, String key, int level) {
        info = new CharacterInfo(1,icon_id,key,
                new CharacterProgress(level, 0,characterPrototype.getCharacterTier()));
        this.stats = CalculateStats.getInstance().getStats(characterPrototype, level);
        skills = new CharacterSkills(characterPrototype.getSkills());
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

    public void addCharacterProgress(int expProgress) {
        info.addProgress(expProgress);

        System.out.println();

    }
}
