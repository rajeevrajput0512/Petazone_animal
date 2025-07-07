package com.petazone.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(schema = "tag_management", name = "work_orders")
@Getter
@Setter
public class WorkOrderEntity {

    @Id
    @Column(name = "wo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer woId;

    @Column(name = "request_status")
    Integer requestStatus;

    @Column(name = "created_at", insertable = false, updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_on", insertable = false)
    LocalDateTime updatedOn;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "no_of_tag_request")
    Integer noOfTags;

    @PreUpdate
    public void preUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
}
