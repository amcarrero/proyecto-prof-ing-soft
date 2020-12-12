package com.ing.soft.proyecto.model;

import org.springframework.data.annotation.Id;

public class UrlContent {

    @Id
    public String id;

    public String url;
    public int content;

    public UrlContent(String url, int content) {
        this.url = url;
        this.content = content;
    }

    public UrlContent() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
}
