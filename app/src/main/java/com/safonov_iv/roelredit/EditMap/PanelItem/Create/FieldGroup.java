package com.safonov_iv.roelredit.EditMap.PanelItem.Create;

import android.content.Context;
import android.graphics.*;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.EditMap.PanelItem.Panel.AddGroupMapValue;
import com.safonov_iv.roelredit.EditMap.PanelItem.Panel.EditGroupMapValue;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.R;
import com.safonov_iv.roelredit.Common.Setting;
import org.jetbrains.annotations.NotNull;

public class FieldGroup extends PanelEditProperties {


    private final Camera camera;
    private final Rect bitmapRect;
    private final Context context;
    private EditGroupMapValue editGroupMapValue;
    private AddGroupMapValue addGroupMapValue;


    public FieldGroup(@NotNull Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_show_group);
        this.context = context;
        bitmapRect = new Rect(0, 0, bitmap.getHeight(), bitmap.getWidth());

        camera = Setting.getInstance().getCamera();


    }

    @Override
    public boolean getAction() {
        reset();
        final MapValue mapValue = MapPrototype.getInstance().getMapValues().get(camera.getCursor().getCursorCoordinate());

        if (mapValue != null) {
            editGroupMapValue = new EditGroupMapValue(context, mapValue);
            addGroupMapValue = new AddGroupMapValue(context, mapValue,editGroupMapValue);
            camera.getPanelControl().addActivePanel(editGroupMapValue);
            camera.getPanelControl().addActivePanel(addGroupMapValue);

            return true;
        }
        return false;
    }


    @Override
    public boolean getCollision(int positionX, int positionY) {
        boolean collision = false;
        if (editGroupMapValue != null) {
            collision = editGroupMapValue.getCollision(positionX, positionY);
        }

        if (!collision && addGroupMapValue != null) {
            collision = addGroupMapValue.getCollision(positionX, positionY);
        }
        return collision || super.getCollision(positionX, positionY);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, bitmapRect, rect, null);
        if (addGroupMapValue != null) {
            addGroupMapValue.draw(canvas);
        }
        if (editGroupMapValue != null) {
            editGroupMapValue.draw(canvas);
        }

    }


    @Override
    public void reset() {
        if (addGroupMapValue != null) {
            addGroupMapValue.reset();
            Setting.getInstance().getCamera().getPanelControl().removeActivePanel(addGroupMapValue);
            addGroupMapValue = null;
        }

        if (editGroupMapValue != null) {
            editGroupMapValue.reset();
            Setting.getInstance().getCamera().getPanelControl().removeActivePanel(editGroupMapValue);
            editGroupMapValue = null;
        }
    }

    @Override
    public void update() {
        if (editGroupMapValue != null) {
            editGroupMapValue.update();
        }
        if (addGroupMapValue != null) {
            addGroupMapValue.update();
        }


    }


}
