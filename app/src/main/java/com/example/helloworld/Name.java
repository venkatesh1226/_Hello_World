package com.example.helloworld;

import java.net.URI;

public class Name {
    private String name;
    private String imageId;

    public Name(String name,String imageId) {
        this.name = name;
        this.imageId=imageId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}