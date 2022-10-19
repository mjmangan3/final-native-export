package com.vereview.model;

/**
 * Created by mjmangan on 9/9/17.
 */
public enum PageLocationType {
    ORIGINAL("ORIGINAL"),
    TEXT("TEXT"),
    REDACTED("REDACTED"),
    REDACTED_TEXT("REDACTED_TEXT");

    private String type;

    PageLocationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static PageLocationType getType(String type){
        for(PageLocationType p : PageLocationType.values()){
            if(p.getType().equalsIgnoreCase(type)){
                return p;
            }
        }
        return null;
    }
}
