package com.exmaple.Demo.model;

public class Question {
    private int id ;
    private String title;
    private String description;
    private Long gmtcreate;
    private Long gmtmodified;
    private int commentcount = 0;
    private int viewcount = 0;
    private int likecount = 0;
    private String tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGmtcreate() {
        return gmtcreate;
    }

    public void setGmtcreate(Long gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    public Long getGmtmodified() {
        return gmtmodified;
    }

    public void setGmtmodified(Long gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

    public int getVewcount() {
        return viewcount;
    }

    public void setVewcount(int vewcount) {
        this.viewcount = vewcount;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
