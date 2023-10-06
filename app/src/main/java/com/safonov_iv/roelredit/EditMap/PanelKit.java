package com.safonov_iv.roelredit.EditMap;

import android.graphics.Canvas;
import com.safonov_iv.roelredit.EditMap.PanelItem.Create.PanelEditMap;
import org.jetbrains.annotations.NotNull;

public class PanelKit {

    private final PanelItemKit panelItemKit;
    private PanelEditMap active;


    public PanelKit(@NotNull ComponentDataKits data) {
        panelItemKit = data.getPanelItemKit();

    }


    public boolean getAction() {
        if (active == null) {
            return false;
        }
        return active.getAction();
    }


    public boolean getCollision(int activeCursorX, int activeCursorY) {
        if(panelItemKit.getCollision(activeCursorX,activeCursorY)){
            PanelEditMap activePanelEditMap = panelItemKit.getActivePanelEditMap();
            if(activePanelEditMap!=null)
                setActive(activePanelEditMap);
            return true;
        }

        return false;
    }

    private void setActive(PanelEditMap activePanelEditMap) {
        if(active==activePanelEditMap)
            return;

        if(active!=null)
            active.reset();

        active=activePanelEditMap;
    }


    public void draw(Canvas canvas) {
        panelItemKit.draw(canvas);

    }

    public void update() {
        if (active != null) {
            active.update();
        }

    }

}
