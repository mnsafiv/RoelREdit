package com.safonov_iv.roelredit.GenerateObject.Component;

import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.Map.Coordinate.Enum.BattleMapType;
import com.safonov_iv.roelredit.Map.Coordinate.Enum.MapType;
import com.safonov_iv.roelredit.Map.Coordinate.IconCoordinate;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.*;

public class MapComponent {


    private static final Random random = new Random();

    public static Map<Integer, MapValue> getMap(MapType mapType, Setting setting) {
        int sizeAreaX = 20;
        int sizeAreaY = 20;
        Map<Integer, MapValue> map = new HashMap<>();
        Random random = new Random();

        switch (mapType) {
            case Simply:

                for (int i = 0; i < sizeAreaX; i++) {
                    for (int j = 0; j < sizeAreaY; j++) {
                        int key = i + j * DefaultValue.FIELD_CAPACITY;

                        final int value = random.nextInt(5) - 1;

                        Set<IconCoordinate> icons = new HashSet<>();


                        final BitmapConfig bitmapConfig = getRandomBitmapConfig();
                        final String randomBackGroundType = getRandomBackGround(bitmapConfig);
                        MapValue mapValue = new MapValue(key, 1, bitmapConfig.getKey(), randomBackGroundType);

                        for (int k = 0; k < value; k++) {
                            icons.add(getRandomIconCoordinate(setting, mapValue));
                        }

                        mapValue.add(icons);



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
        return new HashMap<>();
    }

    private static String getRandomBackGround(BitmapConfig bitmapConfig) {
        final List<String> collect = new ArrayList<>(bitmapConfig.getKeys());
        return collect.get(random.nextInt(collect.size()));
    }

    private static IconCoordinate getRandomIconCoordinate(Setting setting, MapValue mapValue) {
        int size = (int) setting.getFieldSetting().getSize();

        Random random = new Random();
        int vectorX = random.nextInt(size / 3) - size / 6;
        int vectorY = random.nextInt(size / 3) - size / 6;
        final Map<String, BitmapConfig> map = PrototypeDecor.getInstance().getKeys();
        final List<String> keys = new ArrayList<>(PrototypeDecor.getInstance().getKeys().keySet());
        final String key = keys.get(random.nextInt(keys.size()));
        final List<String> iconsKey = new ArrayList<>(Objects.requireNonNull(map.get(key)).getKeys());

        return new IconCoordinate(vectorX, vectorY, 1, key, iconsKey.get(random.nextInt(iconsKey.size())), mapValue);
    }

    private static BitmapConfig getRandomBitmapConfig() {
        final Map<String, BitmapConfig> map = PrototypeGrid.getInstance().getKeys();
        final List<String> collect = new ArrayList<>(map.keySet());
        final String key = collect.get(random.nextInt(collect.size()));
        return map.get(key);
    }


}
