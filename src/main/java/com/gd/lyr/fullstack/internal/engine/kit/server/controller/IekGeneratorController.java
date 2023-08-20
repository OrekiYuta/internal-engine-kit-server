package com.gd.lyr.fullstack.internal.engine.kit.server.controller;


import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.ApiResponse;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.dto.GeneratorDTO;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.vo.GeneratorVO;
import com.gd.lyr.fullstack.internal.engine.kit.server.service.IekGeneratorService;
import com.gd.lyr.fullstack.internal.engine.kit.server.utils.PojoUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yan.Ru.Li
 * @description IekGeneratorController
 * @date 2023/7/7 21:22:22
 */
@CrossOrigin
@RestController
@RequestMapping("/iek")
public class IekGeneratorController {

    private final IekGeneratorService iekGeneratorService;

    public IekGeneratorController(IekGeneratorService iekGeneratorService) {
        this.iekGeneratorService = iekGeneratorService;
    }

    @PostMapping("/generator")
    public ResponseEntity<ApiResponse<GeneratorVO>> createGenerator(@RequestBody GeneratorVO generatorVo) {
        GeneratorDTO generatorDTO = PojoUtils.convertVOToDTO(generatorVo, GeneratorDTO.class);

        GeneratorDTO createGenerator = iekGeneratorService.createGenerator(generatorDTO);

        GeneratorVO result = PojoUtils.convertDTOToVO(createGenerator, GeneratorVO.class);
        ApiResponse<GeneratorVO> response = ApiResponse.successResponse(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
