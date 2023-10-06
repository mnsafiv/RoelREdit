package com.safonov_iv.roelredit.Map.Coordinate;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class MapPrototype {
    private static volatile MapPrototype mapPrototype;
    @Setter
    private Long mapNameId;
    @Setter
    private String mapName;
    @Setter
    private Map<Integer, MapValue> mapValues;

    private MapPrototype() {
    }

    public synchronized static MapPrototype getInstance() {
        if (mapPrototype == null) {
            mapPrototype = new MapPrototype();
        }
        return mapPrototype;
    }

}
