package com.vereview.csv;

/**
 * Created by mjmangan on 9/2/17.
 */
public enum RelitivityDelimiters {
    COLUMN(new Character((char)20).toString()),
    QUOTE(new Character((char)254).toString()),
    NEW_LINE("\r\n"), //removed -> new Character((char)174).toString()
    MULTI_VALUE(new Character((char)59).toString()),
    NESTED_VALUE(new Character((char)92).toString());

    private String character;

    RelitivityDelimiters(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
