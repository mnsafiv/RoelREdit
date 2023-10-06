package com.safonov_iv.roelredit.Repo.ModelDto;

import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class MapPrototypeDto {
    private Long mapNameId;
    private String mapName;
    private List<MapValue> mapValues;

    public MapPrototype getMapPrototype() {
        Map<Integer, MapValue> mapValues = new HashMap<>();
        this.mapValues.forEach(t -> {
            t.getIconCoordinates().forEach(n -> n.setMapValueOwner(t));
            mapValues.put(t.getCoordinate(), t);
        });
        MapPrototype mapPrototype = MapPrototype.getInstance();
        mapPrototype.setMapValues(mapValues);
        mapPrototype.setMapName(mapName);
        mapPrototype.setMapNameId(mapNameId);
        return mapPrototype;
    }

    public void updateMapPrototype(MapPrototype mapPrototype) {
        mapNameId=mapPrototype.getMapNameId();
        mapName=mapPrototype.getMapName();
        mapValues = new ArrayList<>(mapPrototype.getMapValues().values());
    }

}
