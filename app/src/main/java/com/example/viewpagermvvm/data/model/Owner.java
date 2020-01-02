package com.example.viewpagermvvm.data.model;

import java.io.Serializable;

public class Owner implements Serializable
{
String node_id,type,site_admin;

    public Owner(String node_id, String type, String site_admin) {
        this.node_id = node_id;
        this.type = type;
        this.site_admin = site_admin;
    }

    public Owner() {
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(String site_admin) {
        this.site_admin = site_admin;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "node_id='" + node_id + '\'' +
                ", type='" + type + '\'' +
                ", site_admin='" + site_admin + '\'' +
                '}';
    }
}
