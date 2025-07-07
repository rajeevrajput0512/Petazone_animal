package com.petazone.user.repository;

import com.petazone.user.entity.AvailableTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableTagsRepository extends JpaRepository<AvailableTagsEntity, Long> {
    List<AvailableTagsEntity> findAllByWoId(Integer woId);
}
