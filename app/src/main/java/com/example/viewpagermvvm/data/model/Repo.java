package com.example.viewpagermvvm.data.model;

import java.io.Serializable;

public class Repo implements Serializable
{
String id,node_id,full_name,description;
Owner owner;

    public Repo() {
    }

    public Repo(String id, String node_id, String full_name, String description, Owner owner) {
        this.id = id;
        this.node_id = node_id;
        this.full_name = full_name;
        this.description = description;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "id='" + id + '\'' +
                ", node_id='" + node_id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                '}';
    }
}
