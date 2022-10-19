package com.vereview.context;

/**
 * Created by mjmangan on 8/9/17.
 */
public enum PropertyAttributes {
    DB_USERNAME("db_username"),
    DB_PASSWORD("db_password"),
    DB_INSTANCE("db_instance"),
    DB_SERVER("db_server");

    private String attribute;

    PropertyAttributes(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
