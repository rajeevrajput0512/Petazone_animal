package com.petazone.user.controller;


import com.petazone.user.dto.request.KeyRequestDTO;
import com.petazone.user.dto.response.ApiResponseCommon;
import com.petazone.user.dto.response.CommonMasterDTO;

import com.petazone.user.service.CommonMasterService;
import com.petazone.user.utils.ResponseUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petazone/v1/common")
public class CommonMasterController {
    @Autowired
    private CommonMasterService commonMasterService;

    @PostMapping(value = "/getAllByKey")
    public ResponseEntity<ApiResponseCommon<List<CommonMasterDTO>>> getListOfSameKeys(@Valid @RequestBody KeyRequestDTO requestDTO) {
        List<CommonMasterDTO> data = commonMasterService.getAllByKey(requestDTO.getValue());
        return ResponseEntity.ok(ResponseUtils.createSuccessResponseWithMsg(data, "Success"));
    }

    @PostMapping(value = "/getAllMatchingKeys")
    public ResponseEntity<ApiResponseCommon<List<CommonMasterDTO>>> getAllMatchingKeys(@RequestParam String value) {
        List<CommonMasterDTO> data = commonMasterService.getMatchingKeyNames(value);
        return ResponseEntity.ok(ResponseUtils.createSuccessResponse(data));
    }

}
