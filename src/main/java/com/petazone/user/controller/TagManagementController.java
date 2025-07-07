package com.petazone.user.controller;

import com.petazone.user.service.AvailableTagService;
import com.petazone.user.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "/petazone/v1/tagManagement")
public class TagManagementController {

    public static Integer rajeev;

    static {
        rajeev = 1;
    }

    @Autowired
    WorkOrderService workOrderService;

    @Autowired
    AvailableTagService availableTagService;

    @GetMapping("/getAllApprovedWorkId")
    public List<Long> getAllValidWoId() throws Exception {
        List<Integer> validWordWoId = workOrderService.getAllWorkOrderByStatus();
        List<Long> allTags = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<List<Long>>> futures = new ArrayList<>();
//        for (Integer i : validWordWoId) {
//            allTags.addAll(availableTagService.getAllTagsByWoId(i));
//        }
        for (Integer i : validWordWoId) {
            Future<List<Long>> itr = executorService.submit(() -> availableTagService.getAllTagsByWoId(i));
            futures.add(itr);
        }
        for (Future<List<Long>> future : futures) {
            allTags.addAll(future.get());  // waits for the result and merges
        }
        executorService.shutdown();
        return allTags;
    }
}
