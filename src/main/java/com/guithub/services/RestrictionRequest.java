package com.guithub.services;

/**
 * Created by Nick on 27.05.17.
 */
public enum RestrictionRequest {

    PROFILE("/profile"),
    ADMIN("/admin"),
    LOGIN("/login");

    String type;

    RestrictionRequest(String type) {
        this.type = type;
    }

    static public RestrictionRequest getType(String pType) {
        for (RestrictionRequest type: RestrictionRequest.values()) {
            if (type.getTypeValue().equals(pType)) {
                return type;
            }
        }
        return null;
    }

    public String getTypeValue() {
        return type;
    }
}
