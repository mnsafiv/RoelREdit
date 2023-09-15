package com.safonov_iv.roelredit.EditMap;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.EditMap.PanelItem.Create.PanelEditMap;
import com.safonov_iv.roelredit.EditMap.PanelItem.SelectItemKit;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PanelItemKit {
    private final HashSet<SelectItemKit> selectItems;
    private SelectItemKit activeCollection;
    private PanelEditMap activeItem;
    private final Camera camera;

    public PanelItemKit(Camera camera) {
        this.camera = camera;
        this.selectItems = new HashSet<>();
    }

    public void init() {
        int shiftX = Setting.getSetting().getCurrentWidth() * Setting.getSetting().getCurrentHeight() / DefaultValue.RESOLUTION;
        int shiftY = Setting.getSetting().getCurrentWidth() * Setting.getSetting().getCurrentHeight() / DefaultValue.RESOLUTION;

        AtomicInteger x = new AtomicInteger(1);
        AtomicInteger y = new AtomicInteger(1);

        final Rect targetRect = new Rect(0, 0, shiftX, shiftY);

        selectItems.forEach(t -> {
            Rect rect = new Rect(targetRect);
            rect.offsetTo(shiftX * x.getAndAdd(1), shiftY * y.get());
            t.setRect(rect);

            camera.getPanelControl().addPanel(t);

            AtomicInteger x1 = new AtomicInteger(1);
            int y1 = 2;

            t.getItems().forEach(item -> {
                Rect rectItem = new Rect(targetRect);
                rectItem.offsetTo(shiftX * x1.getAndAdd(1), shiftY * y1);
                item.setRect(rectItem);
            });
        });


    }

    public PanelEditMap getActivePanelEditMap() {
        if (activeItem != null) {
            return activeItem;
        }
        return null;
    }


    public boolean getCollision(int x, int y) {
        Optional<SelectItemKit> item = selectItems.stream().filter(t -> t.getCollision(x, y)).findFirst();
        if (item.isPresent()) {
            setActive(item.get());
            return true;
        }
        if (activeCollection != null) {
            final Optional<PanelEditMap> first = activeCollection.getItems().stream().filter(t -> t.getCollision(x, y)).findFirst();
            if (first.isPresent()) {
                activeItem = first.get();
                return true;
            }
        }
        return false;

    }




    private void setActive(SelectItemKit selectItemKit) {
        if (activeCollection == selectItemKit)
            return;

        if (activeCollection != null) {
            camera.getPanelControl().removePanel(activeCollection.getItems());
            activeCollection.reset();

        }

        activeCollection = selectItemKit;
        camera.getPanelControl().addPanel(activeCollection.getItems());
    }


    public void draw(Canvas canvas) {
        selectItems.forEach(t -> t.draw(canvas));
        if (activeCollection != null) {
            activeCollection.drawStatus(canvas);
        }

    }

    public void add(String key, Set<PanelEditMap> items) {
        selectItems.add(new SelectItemKit(items));
    }
}
