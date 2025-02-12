package com.example.demo.models;


import javax.persistence.*;

@Entity
public class PageVisit {
    @Id
    private String pageName;
    private int visitCount;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
}