package com.safonov_iv.roelredit.GenerateObject.Component;

import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.Map.Coordinate.Enum.BattleMapType;
import com.safonov_iv.roelredit.Map.Coordinate.Enum.MapType;
import com.safonov_iv.roelredit.Map.Coordinate.IconCoordinate;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.*;
import java.util.stream.Collectors;

public class MapComponent {


    private static Random random = new Random();

    public static Map<Integer, MapValue> getMap(MapType mapType, Setting setting) {
        int sizeAreaX = 10;
        int sizeAreaY = 10;
        Map<Integer, MapValue> map = new HashMap<>();
        Random random = new Random();

        switch (mapType) {
            case Simply:

                for (int i = 0; i < sizeAreaX; i++) {
                    for (int j = 0; j < sizeAreaY; j++) {
                        int key = i + j * 1000;

                        final int value = random.nextInt(5) - 2;

                        Set<IconCoordinate> icons = new HashSet<>();


                        final BitmapConfig bitmapConfig = getRandomBitmapConfig();
                        final String randomBackGroundType = getRandomBackGround(bitmapConfig);
                        MapValue mapValue = new MapValue(key, 1, bitmapConfig.getKey(), randomBackGroundType, icons);

                        for (int k = 0; k < value; k++) {
                            icons.add(getRandomIconCoordinate(setting, mapValue));
                        }

                        final int modelGroupCounter = random.nextInt(2);
                        if (modelGroupCounter == 1) {
                            final MapGroupModel mapGroupModel = GroupComponent.getMapGroupModel(BattleMapType.mediumEasy);
                            mapValue.setMapGroup(mapGroupModel);
                        }
                        map.put(key, mapValue);
                    }
                }
                return map;

            case Base:
                break;

            case None:
                return map;

        }
        return null;
    }

    private static String getRandomBackGround(BitmapConfig bitmapConfig) {
        final List<String> collect = bitmapConfig.getKeys().stream().collect(Collectors.toList());
        return collect.get(random.nextInt(collect.size()));
    }

    private static IconCoordinate getRandomIconCoordinate(Setting setting, MapValue mapValue) {
        int size = (int) setting.getFieldSetting().getSize();

        Random random = new Random();
        int vectorX = random.nextInt(size / 3) - size / 6;
        int vectorY = random.nextInt(size / 3) - size / 6;
        final Map<String, BitmapConfig> map = GenerateObjectAccess.prototypeDecor.getKeys();
        final List<String> keys = GenerateObjectAccess.prototypeDecor.getKeys().entrySet().stream().map(t -> t.getKey()).collect(Collectors.toList());
        final String key = keys.get(random.nextInt(keys.size()));
        final List<String> iconsKey = map.get(key).getKeys().stream().collect(Collectors.toList());

        return new IconCoordinate(vectorX, vectorY, 1, key, iconsKey.get(random.nextInt(iconsKey.size())), mapValue);
    }

    private static BitmapConfig getRandomBitmapConfig() {
        final Map<String, BitmapConfig> map = GenerateObjectAccess.prototypeGrid.getKeys();
        final List<String> collect = map.entrySet().stream().map(t -> t.getKey()).collect(Collectors.toList());
        final String key = collect.get(random.nextInt(collect.size()));
        return map.get(key);
    }


}
