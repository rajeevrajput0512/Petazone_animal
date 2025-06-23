package com.petazone.user.service;

import com.petazone.user.dto.response.CommonMasterDTO;
import com.petazone.user.entity.CommonMaster;
import com.petazone.user.repository.CommonMasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommonMasterService {


    private final CommonMasterRepository commonMasterRepository;
    private final ModelMapper modelMapper;

    public CommonMasterService(ModelMapper modelMapper, CommonMasterRepository commonMasterRepository) {
        this.modelMapper = modelMapper;
        this.commonMasterRepository = commonMasterRepository;

    }

    public List<CommonMasterDTO> getAllByKey(String key) {
        List<CommonMaster> resultEntity = commonMasterRepository.findByIdKey(key);
        List<CommonMasterDTO> resultDto = new ArrayList<>();
        for (CommonMaster item : resultEntity) {
            CommonMasterDTO temp = new CommonMasterDTO();
            temp.setId(item.getId().getId());
            temp.setValue(item.getValue());
            temp.setKey(item.getId().getKey());
            System.out.println(temp);
            resultDto.add(temp);
        }

        return resultDto;
    }

    @Transactional
    public List<CommonMasterDTO> getMatchingKeyNames(String value) {
        List<CommonMaster> result = commonMasterRepository.findRelatedKeyNames(value);
        modelMapper.typeMap(CommonMaster.class, CommonMasterDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getId().getId(), CommonMasterDTO::setId);
                    mapper.map(src -> src.getId().getKey(), CommonMasterDTO::setKey);
                });
        return result.stream()
                .map(item -> modelMapper.map(item, CommonMasterDTO.class))
                .collect(Collectors.toList());
    }
}
