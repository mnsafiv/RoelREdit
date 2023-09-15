package com.safonov_iv.roelredit.GenerateObject.Model;

public class ModelProperties {
    private final int id;
    private final int id_bitmap;
    private final int row;
    private final int number;

    public ModelProperties(int id, int id_bitmap, int row, int rowNumber) {
        this.id = id;
        this.id_bitmap = id_bitmap;
        this.row = row;
        this.number = rowNumber;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public int getId_bitmap() {
        return id_bitmap;
    }
}