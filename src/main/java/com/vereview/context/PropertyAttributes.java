package com.vereview.context;

/**
 * Created by mjmangan on 8/9/17.
 */
public enum PropertyAttributes {
    DB_USERNAME("db_username"),
    DB_PASSWORD("db_password"),
    DB_INSTANCE("db_instance"),
    DB_SERVER("db_server"),
    STORAGE_USERNAME("storage_username"),
    STORAGE_PASSWORD("storage_password"),
    THREAD_COUNT("thread_count"),
    EXPORT_PATH_USERNAME("export_path_username"),
    EXPORT_PATH_PASSWORD("export_path_password");

    private String attribute;

    PropertyAttributes(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
