package com.fuwei.pojo;

public class CarrerDetail {

    private int cid;
    private String name;
    private String picture;
    private String introduce;
    private String doorsill;
    private String difficult;
    private String growth;
    private String scarcity;
    private String studying;
    private String suggest;
    private String specific;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getDoorsill() {
        return doorsill;
    }

    public void setDoorsill(String doorsill) {
        this.doorsill = doorsill;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getScarcity() {
        return scarcity;
    }

    public void setScarcity(String scarcity) {
        this.scarcity = scarcity;
    }

    public String getStudying() {
        return studying;
    }

    public void setStudying(String studying) {
        this.studying = studying;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    @Override
    public String toString() {
        return "CarrerDetail{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", introduce='" + introduce + '\'' +
                ", doorsill='" + doorsill + '\'' +
                ", difficult='" + difficult + '\'' +
                ", growth='" + growth + '\'' +
                ", scarcity='" + scarcity + '\'' +
                ", studying='" + studying + '\'' +
                ", suggest='" + suggest + '\'' +
                ", specific='" + specific + '\'' +
                '}';
    }
}
