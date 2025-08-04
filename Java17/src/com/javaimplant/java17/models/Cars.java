package com.javaimplant.java17.models;

public class Cars {
    private String cname;
    private String cBrand;

    public Cars(String cname, String cBrand) {
        this.cname = cname;
        this.cBrand = cBrand;
    }

    public Cars() {
    }

    public String getCname() {
        return cname;
    }

    public String getcBrand() {
        return cBrand;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setcBrand(String cBrand) {
        this.cBrand = cBrand;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cname='" + cname + '\'' +
                ", cBrand='" + cBrand + '\'' +
                '}';
    }
}
