package com.guithub.domain;

/**
 * Created by Nick on 27.05.17.
 */
public enum Permissions {
    All("SupperAdmin"),
    ADMIN("Admin"),
    GUEST("Guest"),
    COLLABORATORS("Collaborator"),
    PROJECT_OWNER("Owner"),
    PROJECT_MANAGER("Manager");

    String perms;
    Permissions(String perms) {
        this.perms = perms;
    }
    public static Permissions getPermissionByType(String type)
    {
        for(Permissions rolePermission : values()){
            if(rolePermission.perms.equals(type)){
                return rolePermission;
            }
        }
        return GUEST;
    }

    public String getGroupName() {
        return perms;
    }
}
