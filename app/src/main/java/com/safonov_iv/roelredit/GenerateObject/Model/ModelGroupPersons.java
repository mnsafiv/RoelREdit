package com.safonov_iv.roelredit.GenerateObject.Model;


import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
public class ModelGroupPersons implements Serializable {
    private final List<CharacterModel> playerPersons;
}
