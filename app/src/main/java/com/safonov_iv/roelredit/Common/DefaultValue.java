package com.safonov_iv.roelredit.Common;

import com.safonov_iv.roelredit.Common.Item.AddPanel;
import com.safonov_iv.roelredit.Common.Item.EditPanel;
import com.safonov_iv.roelredit.Cursor.Layer.GridType;

public class DefaultValue {

    public static final double DEFAULT_POSITION_STATUS_X = 0.0;
    public static final double DEFAULT_POSITION_STATUS_Y = 0.0;
    public static final double MAX_WIDTH_STATUS = 0.35;
    public static final double MAX_HEIGHT_STATUS = 0.30;
    public static final double TARGET_WIDTH_STATUS = 0.20;
    public static final double TARGET_HEIGHT_STATUS = 0.20;
    public static final double TARGET_CURSOR_SIZE_STATUS = 0.03;

    public static final String PLAYER_KEY = "playerGroup";
    public static final String OPPONENT_KEY = "opponentKey";


    public static GridType GRID_TYPE;


    public static final double MAX_UPS = 30;
    public static final int TIME_TO_FINISH = 5;
    public static final String SETTING_KEY = "setting";
    public static final int COMMON_MULTIPLIER_PROGRESS = 100;
    public static final int ELITE_MULTIPLIER_PROGRESS = 120;
    public static final int HERO_MULTIPLIER_PROGRESS = 200;
    public static final int FIELD_CAPACITY = 10000;


    //panel edit/add head,end and row
    public static EditPanel editPanel=new EditPanel();
    public static AddPanel addPanel=new AddPanel();
    public static final int RESOLUTION = 30000;


    public static final int NO_EXIST_GROUP = -1;


    public static float DEFAULT_FIELD_SIZE = 200;
    public static float DEFAULT_CAMERA_RESOLUTION = 1000;
    public static float CAMERA_SENSE = 100;

}
