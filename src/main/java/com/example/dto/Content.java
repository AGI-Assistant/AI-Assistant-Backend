package com.example.dto;

public class Content {

    private String content;
    private String error;

    private String partialContent;

    public Content(String content, String error, String partialContent) {
        this.content = content;
        this.error = error;
        this.partialContent = partialContent;
    }

    public String getPartialContent() {
        return partialContent;
    }

    public void setPartialContent(String partialContent) {
        this.partialContent = partialContent;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
