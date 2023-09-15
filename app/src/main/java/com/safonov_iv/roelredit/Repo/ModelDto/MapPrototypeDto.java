package com.safonov_iv.roelredit.Repo.ModelDto;

import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapPrototypeDto {
    private Long mapNameId;
    private String mapName;
    private List<MapValue> mapValues;

    public MapPrototypeDto() {
    }

    public MapPrototypeDto(Long mapNameId, String mapName, List<MapValue> mapValues) {
        this.mapNameId = mapNameId;
        this.mapName = mapName;
        this.mapValues = mapValues;
    }

    public Long getMapNameId() {
        return mapNameId;
    }

    public void setMapNameId(Long mapNameId) {
        this.mapNameId = mapNameId;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public List<MapValue> getMapValues() {
        return mapValues;
    }

    public void setMapValues(List<MapValue> mapValues) {
        this.mapValues = mapValues;
    }

    public MapPrototype getMapPrototype(@NotNull Setting setting) {
        Map<Integer, MapValue> mapValues = new HashMap<>();
        this.mapValues.forEach(t -> {
            t.getIconCoordinates().forEach(n -> n.setMapValueOwner(t));
            mapValues.put(t.getCoordinate(), t);
        });
        MapPrototype mapPrototype = new MapPrototype(mapNameId, mapName, mapValues);
        mapPrototype.setSetting(setting.getFieldSetting());
        mapPrototype.setGrid(setting.getGrid());

        return mapPrototype;
    }

    public void updateMapPrototype(MapPrototype mapPrototype) {
        mapNameId=mapPrototype.getMapNameId();
        mapName=mapPrototype.getMapName();
        mapValues = mapPrototype.getMapValues().entrySet().stream().map(t->t.getValue()).collect(Collectors.toList());
    }

}
