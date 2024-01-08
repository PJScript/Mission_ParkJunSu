package com.example.communitydemo.domain.board.entity;

import com.example.communitydemo.domain.GlobalTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.HashMap;

@Entity
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String value;
    private Date created_at;
    private Date updated_at;
    private GlobalTypes.YesOrNo is_deleted;

    public HashTag(){

    }
    public HashTag(Long id, String label, String value, Date created_at, Date updated_at, GlobalTypes.YesOrNo is_deleted) {
        this.id = id;
        this.label = label;
        this.value = value;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_deleted = is_deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public GlobalTypes.YesOrNo getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(GlobalTypes.YesOrNo is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "HashTag{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
