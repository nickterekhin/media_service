package com.guithub.helpers;

/**
 * Created by Nick on 05.07.17.
 */
public enum ActionsList {
    LIST("list"),
    EDIT("edit"),
    ADD("add"),
    DELETE("delete"),
    STATUS("status");

    String type;
    ActionsList(String type) {
        this.type = type;
    }
    static public ActionsList getType(String pType) {
        if(pType==null) return LIST;
        for (ActionsList type: ActionsList.values()) {
            if (type.getTypeValue().equals(pType)) {
                return type;
            }
        }
        return LIST;
    }
    public String getTypeValue() {
        return type;
    }
}
