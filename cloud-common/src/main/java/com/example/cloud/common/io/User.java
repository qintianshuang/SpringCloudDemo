package com.example.cloud.common.io;

public class User {

    private String uid;
    private String name;

    public User() {
        super();
    }

    public User(final String uid, final String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(final String uid) {
        this.uid = uid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
