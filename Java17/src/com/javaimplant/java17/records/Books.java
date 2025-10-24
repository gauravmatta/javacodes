package com.javaimplant.java17.records;

public record Books(int id, String name,String author) {
    @Override
    public String toString() {
        return "id:" + id + ", name:" + name + ", author:" + author;
    }
}
