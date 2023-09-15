package com.safonov_iv.roelredit.Map.Coordinate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safonov_iv.roelredit.Cursor.Layer.FieldSetting;
import com.safonov_iv.roelredit.Cursor.Layer.GridDraw;

import java.util.Map;

public class MapPrototype {
    private Long mapNameId;
    private String mapName;
    private Map<Integer,MapValue> mapValues;

    @JsonIgnore
    private FieldSetting setting;
    @JsonIgnore
    private GridDraw grid;

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

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public Map<Integer, MapValue> getMapValues() {
        return mapValues;
    }

    public void setMapValues(Map<Integer, MapValue> mapValues) {
        this.mapValues = mapValues;
    }

    public Long getMapNameId() {
        return mapNameId;
    }

    public void setMapNameId(Long mapNameId) {
        this.mapNameId = mapNameId;
    }

    public FieldSetting getSetting() {
        return setting;
    }

    public void setSetting(FieldSetting setting) {
        this.setting = setting;
    }

    public GridDraw getGrid() {
        return grid;
    }

    public void setGrid(GridDraw grid) {
        this.grid = grid;
    }
}
