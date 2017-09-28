package com.guithub.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Nick on 20.05.17.
 */
@Entity
@Table(name = "groups")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true)
    private long id;

    @Column(name="groupName", unique = true)
    private String groupName;

    @Column(name="permissions")
    private int permissions = 0;

    @Column(name="active")
    private boolean active;

    @OneToMany()
    @JoinColumn(name = "ugroup")
    private Set<User> users;

    public UserGroup() {

    }

    public UserGroup(String groupName, int permissions, boolean active) {
        this.groupName = groupName;
        this.permissions = permissions;
        this.active = active;
    }

    public UserGroup(String groupName, List<Permissions> permissionses, boolean active)
    {
        this.groupName = groupName;
        this.setPermissions(permissions);
        this.active = active;
    }
    public UserGroup(String groupName, Permissions permissions, boolean active)
    {
        this.groupName = groupName;
        this.setPermission(permissions);
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }
    public void setPermission(Permissions permission)
    {
        this.permissions  |= (~this.permissions)&(1<<permission.ordinal());
    }
    public void unsetPermission(Permissions permission)
    {
        this.permissions |= (this.permissions)&(1<<permission.ordinal());
    }
    public void setPermission(List<Permissions> permission)
    {
        for(Permissions perm : permission)
        {
            this.setPermission(perm);
        }
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public boolean isPermissionSetted(Permissions permission)
    {
        return ((this.permissions>>permission.ordinal())&1)==1;
    }
}
