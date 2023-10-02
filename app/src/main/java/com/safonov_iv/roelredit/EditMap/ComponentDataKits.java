package com.safonov_iv.roelredit.EditMap;

import android.content.Context;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.EditMap.PanelItem.Create.*;
import com.safonov_iv.roelredit.EditMap.PanelItem.ResolutionIcon;
import com.safonov_iv.roelredit.GenerateObject.Component.BitmapConfig;
import com.safonov_iv.roelredit.EditMap.PanelItem.FieldRemove;
import com.safonov_iv.roelredit.GenerateObject.Component.PrototypeDecor;
import com.safonov_iv.roelredit.GenerateObject.Component.PrototypeGrid;
import com.safonov_iv.roelredit.R;
import lombok.Getter;

import java.util.*;

@Getter
public class ComponentDataKits {
    private final PanelItemKit panelItemKit;

    public ComponentDataKits(Context context, ResolutionIcon resolution, Camera camera) {
        panelItemKit = new PanelItemKit(camera);

        final Map<String, BitmapConfig> gridKey = PrototypeGrid.getInstance().getKeys();
        final Map<String, BitmapConfig> decorKey = PrototypeDecor.getInstance().getKeys();



        gridKey.forEach((key, value) -> {
            final Set<String> values = value.getKeys();
            Set<PanelEditMap> curIcons = new LinkedHashSet<>();
            values.forEach(n -> curIcons.add(new FieldValue(n, PrototypeGrid.getInstance().getBitmapComponent(n))));
            panelItemKit.add(key, curIcons);
        });

        decorKey.forEach((key, value) -> {
            final Set<String> values = value.getKeys();
            Set<PanelEditMap> curIcons = new LinkedHashSet<>();
            values.forEach(n -> curIcons.add(new FieldDecor(n, key, PrototypeDecor.getInstance().getBitmapComponent(n), resolution)));
            panelItemKit.add(key, curIcons);
        });


        Set<PanelEditMap> curIcons = new LinkedHashSet<>();
//        curIcons.add(new FieldGroup(context));
        curIcons.add(new FieldShow(context));
        curIcons.add(new FieldRemove(context, camera.getCursor(), R.drawable.remove_edit));
        panelItemKit.add("EditGroup", curIcons);

        panelItemKit.init();

    }
}
