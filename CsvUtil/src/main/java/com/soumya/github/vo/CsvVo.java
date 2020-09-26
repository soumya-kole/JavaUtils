package com.soumya.github.vo;

public class CsvVo {

    private String realtime_start;
    private String realtime_end;
    private String units;
    private String name;
    private String age;
    private String house;
    private String notes;

    public void setRealtime_start(String realtime_start) {
        this.realtime_start = realtime_start;
    }

    public void setRealtime_end(String realtime_end) {
        this.realtime_end = realtime_end;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRealtime_start() {
        return realtime_start;
    }

    public String getRealtime_end() {
        return realtime_end;
    }

    public String getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHouse() {
        return house;
    }

    public String getNotes() {
        return notes;
    }

}
