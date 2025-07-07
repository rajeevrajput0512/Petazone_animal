package com.petazone.user.service;


import com.petazone.user.entity.AvailableTagsEntity;
import com.petazone.user.entity.WorkOrderEntity;
import com.petazone.user.repository.AvailableTagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
public class AvailableTagService {

    @Autowired
    AvailableTagsRepository availableTagsRepository;

    public List<Long> getAllTagsByWoId(Integer woId) throws Exception {
        try {
            Thread.sleep(4000);
            List<AvailableTagsEntity> result1 = availableTagsRepository.findAllByWoId(woId);
            return result1.stream().map(AvailableTagsEntity::getTagId).toList();
        } catch (Exception e) {
            throw new Exception("dljasldjasldasdasdas");
        }
    }
}
