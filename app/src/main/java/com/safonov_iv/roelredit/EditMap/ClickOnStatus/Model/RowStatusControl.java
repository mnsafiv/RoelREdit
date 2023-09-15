package com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model;

import android.graphics.Rect;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row.RowStatusPanel;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RowStatusControl {
    private Set<RowStatusPanel> detailInfo = new LinkedHashSet<>();
    private Rect rectBase;
    private int showMaxRow;


    public void addRow(RowStatusPanel rowStatusPanel) {
        detailInfo.add(rowStatusPanel);
    }

    public int getShowMaxRow() {
        return showMaxRow;
    }


    public void setShowMaxRow(int showMaxRow) {
        this.showMaxRow = showMaxRow;
    }

    public Set<RowStatusPanel> getDetailInfo() {
        return detailInfo;
    }



    public void calculate(Rect row) {
        AtomicInteger count = new AtomicInteger(0);
        detailInfo.stream().forEach(entry -> {
            Rect rect = new Rect(row);
            rect.offsetTo(row.left, row.top + row.height() * count.getAndIncrement());
            entry.init(rect.height());
            entry.calculate(rect);
        });

        rectBase = new Rect(0, 0, row.width(), row.height() * showMaxRow);
        rectBase.offsetTo(row.left,row.top);

    }

    public Rect getRectBase() {
        return rectBase;
    }


    public int getHeight() {
        return detailInfo.stream().map(t -> t.getRect().height()).reduce(0, (a, b) -> a + b);
    }

    public void alignment() {
        Map<Integer, List<Float>> positionsX = new HashMap<>();
        detailInfo.stream().map(t -> t.getRowStatusPanelPreference()).forEach(t -> {
            if (positionsX.containsKey(t.getId())) {
                final List<Float> values = positionsX.get(t.getId());
                for (int i = 0; i < values.size(); i++) {
                    if (values.get(i) < t.getPosition().get(i).x) {
                        values.set(i, t.getPosition().get(i).x);
                    }
                }
            } else
                positionsX.put(t.getId(), t.getPosition().stream().map(n -> n.x).collect(Collectors.toList()));
        });
        detailInfo.forEach(t -> t.calculate(positionsX));


    }

}
