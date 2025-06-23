package com.petazone.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "common_master", schema = "cmn_tbl")
public class CommonMaster {

    @EmbeddedId
    private CommonMasterPK id;

    @Column(name = "value")
    private String value;

    @Column(name = "is_active")
    private Boolean isActive;


    public CommonMasterPK getId() {
        return id;
    }

    public void setId(CommonMasterPK id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
