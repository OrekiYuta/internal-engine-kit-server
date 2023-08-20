package com.gd.lyr.fullstack.internal.engine.kit.server.controller;


import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.ApiResponse;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.dto.LocatorDTO;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.vo.LocatorVO;
import com.gd.lyr.fullstack.internal.engine.kit.server.service.IekLocatorService;
import com.gd.lyr.fullstack.internal.engine.kit.server.utils.PojoUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yan.Ru.Li
 * @description IekLocatorController
 * @date 2023/7/7 21:22:22
 */
@CrossOrigin
@RestController
@RequestMapping("/iek")
public class IekLocatorController {
    private final IekLocatorService iekLocatorService;

    public IekLocatorController(IekLocatorService iekLocatorService) {
        this.iekLocatorService = iekLocatorService;
    }

    @GetMapping("/locator")
    public ResponseEntity<ApiResponse<List<LocatorVO>>> getAllLocators() {

        List<LocatorDTO> allLocators = iekLocatorService.getAllLocators();

        List<LocatorVO> locatorVOList = PojoUtils.convertDTOToVOList(allLocators, LocatorVO.class);
        ApiResponse<List<LocatorVO>> response = ApiResponse.successResponse(locatorVOList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/locator")
    public ResponseEntity<ApiResponse<LocatorVO>> createLocator(@RequestBody LocatorVO locatorVo) {
        LocatorDTO locatorDTO = PojoUtils.convertVOToDTO(locatorVo, LocatorDTO.class);

        LocatorDTO createLocator = iekLocatorService.createLocator(locatorDTO);

        LocatorVO result = PojoUtils.convertVOToDTO(createLocator, LocatorVO.class);
        ApiResponse<LocatorVO> response = ApiResponse.successResponse(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/locator/{bizz}")
    public ResponseEntity<ApiResponse<LocatorVO>> getLocatorDetails(@PathVariable String bizz) {

        LocatorDTO locatorDetails = iekLocatorService.getLocatorDetails(bizz);

        LocatorVO result = PojoUtils.convertVOToDTO(locatorDetails, LocatorVO.class);
        ApiResponse<LocatorVO> response = ApiResponse.successResponse(result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/locator/{bizz}")
    public ResponseEntity<ApiResponse<LocatorVO>> updateLocator(@PathVariable String bizz, @RequestBody LocatorVO locatorVo) {
        LocatorDTO locatorDTO = PojoUtils.convertVOToDTO(locatorVo, LocatorDTO.class);

        LocatorDTO updateLocator = iekLocatorService.updateLocator(bizz, locatorDTO);

        LocatorVO result = PojoUtils.convertVOToDTO(updateLocator, LocatorVO.class);
        ApiResponse<LocatorVO> response = ApiResponse.successResponse(result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/locator/{bizz}")
    public ResponseEntity<ApiResponse<Boolean>> deleteLocator(@PathVariable String bizz) {

        boolean deleteLocatorFlag = iekLocatorService.deleteLocator(bizz);

        ApiResponse<Boolean> booleanApiResponse = ApiResponse.successResponse(deleteLocatorFlag);
        return ResponseEntity.status(HttpStatus.OK).body(booleanApiResponse);
    }
}
