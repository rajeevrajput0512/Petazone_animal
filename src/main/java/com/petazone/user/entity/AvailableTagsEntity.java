package com.petazone.user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(schema = "tag_management", name = "available_tags")
@Getter
@Setter
public class AvailableTagsEntity {


    @Id
    @Column(name = "tag_id")
    Long tagId;

    @Column(name = "wo_id")
    Integer woId;

    @Column(name = "tag_type")
    String tagType;

    @Column(name = "status")
    String status;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_on")
    LocalDateTime updatedOn;

}
