package com.petazone.user.repository;

import com.petazone.user.entity.WorkOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrderEntity, Integer> {
    List<WorkOrderEntity> findAllByRequestStatus(Integer status);
}
