package com.soumya.github.vo;

import com.opencsv.bean.CsvBindByName;

public class Product {

    @CsvBindByName(column = "ProductId")
    private String id;
    @CsvBindByName(column = "ProductName")
    private String name;
    @CsvBindByName(column = "Company")
    private String maker;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMaker() {
        return maker;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                '}';
    }
}
