package com.safonov_iv.roelredit.EditMap.ClickOnStatus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.RowStatusControl;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.Model.Row.RowStatusPanel;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.ActionOnClick;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem.ActionOnClickImpl;
import com.safonov_iv.roelredit.R;

import java.util.Optional;

public abstract class StatusModelItem {
    protected Rect rectBorder = new Rect();
    protected Rect rectBase = new Rect();
    protected Rect rectBaseControl = new Rect();

    protected Paint paintBorder;
    protected Paint paintBase;
    protected RowStatusControl rowModelItems;
    protected RowStatusPanel headModel;
    protected RowStatusPanel endModel;


    public StatusModelItem(Context context, int showMaxRow) {
        rowModelItems = new RowStatusControl();
        rowModelItems.setShowMaxRow(showMaxRow);
        paintBorder = new Paint();
        paintBorder.setColor(ContextCompat.getColor(context, R.color.ColorBorderEditValue));
        paintBase = new Paint();
        paintBase.setColor(ContextCompat.getColor(context, R.color.ColorBaseEditValue));
    }

    public void addRow(RowStatusPanel rowStatusPanel) {
        rowModelItems.addRow(rowStatusPanel);
    }

    public Rect getRectBorder() {
        return rectBorder;
    }

    public abstract void draw(Canvas canvas);

    public ActionOnClick getCollision(int positionX, int positionY) {
        if (rectBase.contains(positionX, positionY)) {
            final Optional<RowStatusPanel> first = rowModelItems.getDetailInfo().stream().filter(t -> t.getCollision(positionX, positionY)).findFirst();
            if (first.isPresent()) {
                final Optional<ActionOnClickImpl> actionOnClick = first.get().getMessages().stream().filter(t -> t.getCollision(positionX, positionY)).findFirst();
                if (actionOnClick.isPresent()) {
                    return actionOnClick.get();
                }

            }
        }
        if(headModel.getCollision(positionX,positionY)){
            final Optional<ActionOnClickImpl> first = headModel.getMessages().stream().filter(t -> t.getCollision(positionX, positionY)).findFirst();
            if(first.isPresent()){
                return first.get();
            }
        }
        if(endModel.getCollision(positionX,positionY)){
            final Optional<ActionOnClickImpl> first = endModel.getMessages().stream().filter(t -> t.getCollision(positionX, positionY)).findFirst();
            if(first.isPresent()){
                return first.get();
            }
        }

        return null;
    }


    public RowStatusPanel getCollisionRow(int positionX, int positionY) {
        if (rectBase.contains(positionX, positionY)) {
            final Optional<RowStatusPanel> first = rowModelItems.getDetailInfo().stream().filter(t -> t.getCollision(positionX, positionY)).findFirst();
            if (first.isPresent()) {
                return first.get();

            }
        }
        if(headModel.getCollision(positionX,positionY)){
            return headModel;
        }
        if(endModel.getCollision(positionX,positionY)){
            return endModel;
        }

        return null;
    }

    protected void initBaseRect() {
        rectBase.set(headModel.getRect().left, headModel.getRect().bottom, endModel.getRect().right, endModel.getRect().top);
    }

    private void initBaseControl() {
        rectBaseControl.set(headModel.getRect().left, headModel.getRect().top, endModel.getRect().right, endModel.getRect().bottom);
    }

    private void initBorder(int margin) {
        rectBorder.set(headModel.getRect().left - margin, headModel.getRect().top - margin, endModel.getRect().right + margin, endModel.getRect().bottom + margin);

    }

    public abstract void shift(int distanceX, int distanceY);

    public void addEnd(RowStatusPanel rowStatusPanel) {
        this.endModel = rowStatusPanel;
    }

    public void addHead(RowStatusPanel rowStatusPanel) {
        this.headModel = rowStatusPanel;
    }


    public void reset() {
        rowModelItems.getDetailInfo().clear();

    }

    public void update() {

    }


    public void setBorder(Rect rectStatus, int margin, double rowMultiplier) {
        final int height = rectStatus.height();
        final int width = rectStatus.width();

        double sizeMultiplier = endModel.getSizeMultiplier() + headModel.getSizeMultiplier();
        double rowMultipleTotal = rowModelItems.getDetailInfo().stream().limit(rowModelItems.getShowMaxRow())
                .map(RowStatusPanel::getSizeMultiplier).reduce(0.0, Double::sum);

        if (rowMultipleTotal == 0) {
            rowMultipleTotal = rowMultiplier * rowModelItems.getShowMaxRow();
        } else if (rowModelItems.getShowMaxRow() > rowModelItems.getDetailInfo().size())
            rowMultipleTotal = rowMultipleTotal / rowModelItems.getDetailInfo().size() * rowModelItems.getShowMaxRow();

        sizeMultiplier += rowMultipleTotal;

        final double resolutionEnd = endModel.getSizeMultiplier() / sizeMultiplier;
        final double resolutionHead = headModel.getSizeMultiplier() / sizeMultiplier;
        final double resolutionItem = rowMultipleTotal / sizeMultiplier;

        int headHeight = (int) (height * resolutionHead);
        int endHeight = (int) (height * resolutionEnd);
        int itemHeight = (int) (height * resolutionItem / rowModelItems.getShowMaxRow());

        Rect head = new Rect(0, 0, width, headHeight);
        head.offsetTo(rectStatus.left + margin, rectStatus.top + margin);
        headModel.calculate(head);

        Rect row = new Rect(0, 0, width, itemHeight);
        row.offsetTo(head.left, head.bottom);
        rowModelItems.calculate(row);

        Rect end = new Rect(0, 0, width, endHeight);
        Rect rectRowBase = rowModelItems.getRectBase();
        end.offsetTo(rectRowBase.left, rectRowBase.bottom);
        endModel.calculate(end);

        initBaseRect();
        initBaseControl();
        initBorder(margin);

        rowModelItems.alignment();

    }


}
