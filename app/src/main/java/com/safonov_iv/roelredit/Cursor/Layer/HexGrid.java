package com.safonov_iv.roelredit.Cursor.Layer;


import android.graphics.*;
import com.safonov_iv.roelredit.Cursor.Display.Camera;


public class HexGrid extends GridDraw {
    private double start;
    private final Camera camera;
    final double section = Math.toRadians(60);

    public HexGrid(float radius, GridType gridType, Camera camera) {
        super(radius);
        this.camera = camera;


        switch (gridType) {
            case HexVertical:
                start = Math.toRadians(0);
                break;
            case HexHorizontal:
                start = Math.toRadians(30);
                break;
        }


    }


    @Override
    public void draw(Canvas canvas, int coordinate, Paint paint, FieldSetting setting) {
        canvas.drawPath(
                calculatePathCamera(
                        setting.getCenterAreaPositionX(coordinate),
                        setting.getCenterAreaPositionY(coordinate)),
                paint);


//        Bitmap bitmap1 = BitmapFactory.decodeResource(setting.getContext().getResources(), R.drawable.field_yellow_grass_1);
//        bitmap1 = Bitmap.createScaledBitmap(bitmap1, 200, 200, false);
//        final int width = bitmap1.getWidth();
//        final int height = bitmap1.getHeight();
//        final Bitmap outputBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        final Path path = calculatePathCamera(
//                setting.getCenterAreaPositionX(coordinate),
//                setting.getCenterAreaPositionY(coordinate));
//
//        final Canvas canvas1 = new Canvas(outputBitmap);
//        canvas1.clipPath(path);
//        canvas1.drawBitmap(bitmap1, 0, 0, null);
//
//
//        canvas.drawBitmap(outputBitmap,
//                Utils.getStartXForRectObject(setting.getCenterAreaPositionX(coordinate), bitmap1.getWidth()),
//                Utils.getStartYForRectObject(setting.getCenterAreaPositionY(coordinate), bitmap1.getHeight()),
//                null);


//        final Matrix m = new Matrix();
//        final Path path = calculatePathCamera(
//                setting.getCenterAreaPositionX(coordinate),
//                setting.getCenterAreaPositionY(coordinate));
//
//
//        String mText = "Test text \n text \n Test new line";
//
//        TextPaint mTextPaint = new TextPaint();
//        mTextPaint.setTextSize(30);
//        StaticLayout.Builder builder = StaticLayout.Builder.obtain(mText, 0, mText.length(), mTextPaint, canvas.getWidth());
//        StaticLayout myStaticLayout = builder.build();
//
//        canvas.save();
//
//        int textX = 500;
//        int textY = 500;
//
//        canvas.translate(textX, textY);
//        myStaticLayout.draw(canvas);
//        canvas.restore();


        //delete after
        Paint paintText = new Paint();
        float nextX = (float) camera.getDistanceToCameraX(
                setting.getCenterAreaPositionX(coordinate) - setting.getRadius() / 3);
        float nextY = (float) camera.getDistanceToCameraY(
                setting.getCenterAreaPositionY(coordinate) - setting.getRadius() / 3);
        String str = String.valueOf(coordinate);
        canvas.drawText(str, nextX, nextY, paintText);

    }


    @Override
    public void draw(Canvas canvas, int coordinate, Bitmap bitmap, FieldSetting setting) {
        Paint paint = new Paint();
        canvas.drawPath(
                calculatePathCamera(
                        setting.getCenterAreaPositionX(coordinate),
                        setting.getCenterAreaPositionY(coordinate)),
                paint);

        PointF points = setting.getCoordinateStartBitmap(bitmap, coordinate);

        canvas.drawBitmap(bitmap, (float) camera.getDistanceToCameraX(points.x), (float) camera.getDistanceToCameraY(points.y), null);


    }

    @Override
    public void draw(Canvas canvas, float positionX, float positionY, Paint paint, FieldSetting setting) {
        canvas.drawPath(
                calculatePathCamera(
                        positionX,
                        positionY),
                paint);

    }

    @Override
    public Path getPath() {
        int x = 100;
        int y = 100;
        Path hex = new Path();
        hex.reset();
        hex.moveTo(
                (float) (x + radius * Math.cos(start)),
                (float) (y + radius * Math.sin(start)));



        for (int i = 1; i < 6; i++) {
            hex.lineTo(
                    (float) (x + radius * Math.cos(section * i + start)),
                    (float) (y + radius * Math.sin(section * i + start)));


        }

        System.out.println();

        hex.close();


        return hex;
    }


    private Path calculatePathCamera(float x, float y) {
        Path hex = new Path();
        hex.reset();
        hex.moveTo(
                (float) camera.getDistanceToCameraX(x + radius * Math.cos(start)),
                (float) camera.getDistanceToCameraY(y + radius * Math.sin(start)));
        for (int i = 1; i < 6; i++) {
            hex.lineTo(
                    (float) camera.getDistanceToCameraX(x + radius * Math.cos(section * i + start)),
                    (float) camera.getDistanceToCameraY(y + radius * Math.sin(section * i + start)));

        }

        hex.close();

        return hex;
    }


}


