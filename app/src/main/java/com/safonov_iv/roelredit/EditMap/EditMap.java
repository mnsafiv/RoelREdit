package com.safonov_iv.roelredit.EditMap;

import android.content.Context;
import android.graphics.Canvas;
import com.safonov_iv.roelredit.EditMap.PanelItem.ResolutionIcon;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Repo.Data.MapDataSave;
import com.safonov_iv.roelredit.Repo.ModelDto.MapPrototypeDto;
import com.safonov_iv.roelredit.Common.Setting;
import com.safonov_iv.roelredit.Raw.SaveMapIcon;

public class EditMap {

    private final MapPrototype mapPrototype;


    private final SaveMapIcon saveMapIcon;
    private final PanelKit panelKit;

    private final ResolutionIcon resolutionIcon;


    public EditMap(Context context, MapPrototype mapPrototype) {
        this.mapPrototype = mapPrototype;
        resolutionIcon = new ResolutionIcon(context, 2150, 50, 200, 30);
        ComponentDataKits data = new ComponentDataKits(context, resolutionIcon,Setting.getInstance().getCamera());
        panelKit = new PanelKit(data);

        Setting.getInstance().getCamera().getPanelControl().addActivePanel(resolutionIcon);
        saveMapIcon = new SaveMapIcon(context, Setting.getInstance());

    }

    public void draw(Canvas canvas) {
        panelKit.draw(canvas);
        saveMapIcon.draw(canvas);
        resolutionIcon.draw(canvas);


    }

    public boolean getCollision(int activeCursorX, int activeCursorY) {
        //check collision with panel interface
        if (panelKit.getCollision(activeCursorX, activeCursorY)) {
            return true;
        }

        //temp button - need fix
        if (saveMapIcon.getCollision(activeCursorX, activeCursorY)) {
            MapPrototypeDto mapPrototypeDto = new MapPrototypeDto();
            mapPrototypeDto.updateMapPrototype(mapPrototype);
            MapDataSave mapDataSave = new MapDataSave(mapPrototypeDto);
            Thread threadQuery = new Thread(mapDataSave);
            threadQuery.start();
            return true;
        }
        //check collision with display
        return panelKit.getAction();
    }

    public void update() {
        panelKit.update();
    }
}
