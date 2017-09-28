package com.guithub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;

import javax.persistence.*;



@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name="ugroup")
    private long groupId;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name="createdAt")
    private DateTime createdAt;

    @Column(name = "active")
    private boolean active;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ugroup",referencedColumnName = "id", insertable = false, updatable = false)
    private UserGroup userGroup;

    public User() {
        this.groupId  = 2;
        this.username = "Guest";
        this.active = true;
    }

    public User(long groupId,String username, String password, String email, boolean active) {
        this.groupId  = groupId;
        this.username = username;
        this.password = DigestUtils.md5Hex(password);
        this.email = email;
        this.active = active;
        this.createdAt = DateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean hasPermission(Permissions permission)
    {
        return this.userGroup.isPermissionSetted(permission);
    }
}
