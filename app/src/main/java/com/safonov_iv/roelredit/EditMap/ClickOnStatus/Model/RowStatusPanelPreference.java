package com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model;

import android.graphics.PointF;
import android.graphics.Rect;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.ActionOnClickImpl;

import java.util.LinkedList;
import java.util.List;

public class RowStatusPanelPreference {
    private int id;
    private List<ActionOnClickImpl> messages;
    private List<PointF> pointFs = new LinkedList<>();
    private Rect rect;


    public RowStatusPanelPreference(int groupId, List<ActionOnClickImpl> messages) {
        this.id = groupId;
        this.messages = messages;
    }

    public int getId() {
        return id;
    }


    public List<PointF> getPosition() {
        return pointFs;
    }

    public boolean alignment(Rect rectCur) {
        rect = rectCur;
        pointFs.clear();
        messages.forEach(t -> pointFs.add(new PointF(t.getRect().left, t.getRect().top)));
        return checkPosition();
    }

    private boolean checkPosition() {
        ActionOnClickImpl actionOnClick = messages.stream().filter(t -> !rect.contains(t.getRect())).findFirst().get();
        return actionOnClick != null;
    }

    public void setRect(Rect rectCur) {
        this.rect = rectCur;
    }
}
