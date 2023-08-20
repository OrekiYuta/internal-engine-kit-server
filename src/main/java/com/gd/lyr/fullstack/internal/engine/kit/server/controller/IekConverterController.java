package com.gd.lyr.fullstack.internal.engine.kit.server.controller;


import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.ApiResponse;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.dto.ConverterDTO;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.vo.ConverterVO;
import com.gd.lyr.fullstack.internal.engine.kit.server.service.IekConverterService;
import com.gd.lyr.fullstack.internal.engine.kit.server.utils.PojoUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yan.Ru.Li
 * @description IekConverterController
 * @date 2023/7/7 21:22:22
 */
@CrossOrigin
@RestController
@RequestMapping("/iek")
public class IekConverterController {
    private final IekConverterService iekConverterService;

    public IekConverterController(IekConverterService iekConverterService) {
        this.iekConverterService = iekConverterService;
    }


    @PostMapping("/converter")
    public ResponseEntity<ApiResponse<ConverterVO>> createLocator(@RequestBody ConverterVO converterVo) {
        ConverterDTO converterDTO = PojoUtils.convertVOToDTO(converterVo, ConverterDTO.class);

        ConverterDTO createConverter = iekConverterService.createConverter(converterDTO);

        ConverterVO result = PojoUtils.convertDTOToVO(createConverter, ConverterVO.class);
        ApiResponse<ConverterVO> response = ApiResponse.successResponse(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
