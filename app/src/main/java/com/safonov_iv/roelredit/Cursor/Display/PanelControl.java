package com.safonov_iv.roelredit.Cursor.Display;



import com.safonov_iv.roelredit.EditMap.PanelItem.Create.PanelEditMap;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.PanelInt;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PanelControl {
    private PanelInt active;

    private final Set<PanelInt> panels = new HashSet<>();
    private final Set<PanelInt> activePanels = new HashSet<>();

    public void addPanel(PanelInt panel) {
        panels.add(panel);
    }

    public void addActivePanel(PanelInt panel) {
        activePanels.add(panel);
    }

    public boolean getCollision(int positionX, int positionY) {
        final Optional<PanelInt> first = panels.stream().filter(t -> t.getCollision(positionX, positionY)).findFirst();
        return first.isPresent();
    }

    public boolean getActionCollision(int positionX, int positionY) {
        final Optional<PanelInt> first = activePanels.stream().filter(t -> t.getCollision(positionX, positionY)).findFirst();
        active = first.orElse(null);
        return first.isPresent();
    }


    public void addPanel(Set<PanelEditMap> allIcons) {
        panels.addAll(allIcons);
    }

    public void removePanel(Set<PanelEditMap> allIcons) {
        allIcons.forEach(panels::remove);
    }

    public void shift(int distanceX, int distanceY) {
        if(active!=null){
            active.shift(distanceX,distanceY);
        }

    }

    public void removeActivePanel(PanelInt panel) {
        activePanels.remove(panel);

    }
}
