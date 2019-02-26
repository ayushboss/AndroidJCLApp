package com.ayushcoding.www.jclapp;

/**
 * Created by Ayush on 6/27/2016.
 */
public class LiteratureItem {
    private String nameLit, descLit;

    public LiteratureItem(String nameLit, String descLit) {
        this.nameLit = nameLit;
        this.descLit = descLit;
    }

    public String getNameLit() {
        return nameLit;
    }

    public void setNameLit(String nameLit) {
        this.nameLit = nameLit;
    }

    public String getDescLit() {
        return descLit;
    }

    public void setDescLit(String descLit) {
        this.descLit = descLit;
    }
}
