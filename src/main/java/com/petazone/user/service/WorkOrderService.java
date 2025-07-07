package com.petazone.user.service;


import com.petazone.user.entity.WorkOrderEntity;
import com.petazone.user.repository.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service

public class WorkOrderService {

    @Autowired
    WorkOrderRepository workOrderRepository;

    public List<Integer> getAllWorkOrderByStatus() throws Exception {

        List<WorkOrderEntity> result1 = workOrderRepository.findAllByRequestStatus(2);
        List<WorkOrderEntity> result2 = workOrderRepository.findAllByRequestStatus(3);
        List<WorkOrderEntity> result3 = workOrderRepository.findAllByRequestStatus(1);
        Thread.sleep(1000);
        List<WorkOrderEntity> result4 = workOrderRepository.findAllByRequestStatus(4);
        return Stream.of(result3, result2, result1, result4)
                .flatMap(Collection::stream)
                .filter(a -> a.getWoId() == 2 || a.getWoId() == 3 || a.getWoId() == 5 || a.getWoId() == 6 || a.getWoId() == 7)
                .map(WorkOrderEntity::getWoId).toList();
    }

}
