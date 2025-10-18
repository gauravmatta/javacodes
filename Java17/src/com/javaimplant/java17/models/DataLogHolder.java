package com.javaimplant.java17.models;

public class DataLogHolder {
    private int id;
    private String dValue;

    public DataLogHolder(int id, String dValue) {
        this.id = id;
        this.dValue = dValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue;
    }

    public int getId() {
        return id;
    }

    public String getdValue() {
        return dValue;
    }

    @Override
    public String toString() {
        return "DataLogHolder [id=" + id + ", dValue=" + dValue + "]";
    }
}
