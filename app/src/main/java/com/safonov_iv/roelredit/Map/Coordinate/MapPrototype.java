package com.safonov_iv.roelredit.Map.Coordinate;


import lombok.Getter;

import java.util.Map;

@Getter
public class MapPrototype {
    private Long mapNameId;
    private String mapName;
    private Map<Integer,MapValue> mapValues;

    public MapPrototype() {
    }


    public MapPrototype(Long mapNameId, String mapName, Map<Integer, MapValue> mapValues) {
        this.mapNameId = mapNameId;
        this.mapName = mapName;
        this.mapValues = mapValues;
    }

    public MapPrototype(String mapName, Map<Integer, MapValue> mapValues) {
        this.mapName = mapName;
        this.mapValues = mapValues;
    }

}
