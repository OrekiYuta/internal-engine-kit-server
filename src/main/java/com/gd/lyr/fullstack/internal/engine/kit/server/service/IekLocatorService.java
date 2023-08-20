package com.gd.lyr.fullstack.internal.engine.kit.server.service;

import com.gd.lyr.fullstack.internal.engine.kit.server.constants.DbColumnConstants;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.dto.LocatorDTO;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.entity.IekLocator;
import com.gd.lyr.fullstack.internal.engine.kit.server.repository.IekLocatorRepository;
import com.gd.lyr.fullstack.internal.engine.kit.server.utils.PojoUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Yan.Ru.Li
 * @description IekLocatorService
 * @date 2023/7/7 21:41:09
 */
@Service
public class IekLocatorService {
    private final IekLocatorRepository iekLocatorRepository;

    public IekLocatorService(IekLocatorRepository iekLocatorRepository) {
        this.iekLocatorRepository = iekLocatorRepository;
    }

    public List<LocatorDTO> getAllLocators() {
        List<IekLocator> iekLocatorList = iekLocatorRepository.findAll();

        List<IekLocator> sortedList = iekLocatorList.stream()
                .sorted((loc1, loc2) -> loc2.getUpdatedAt().compareTo(loc1.getUpdatedAt()))
                .collect(Collectors.toList());

        return PojoUtils.convertEntityToDTOList(sortedList, LocatorDTO.class);
    }

    public LocatorDTO createLocator(LocatorDTO locatorDTO) {
        IekLocator iekLocator = PojoUtils.convertDTOToEntity(locatorDTO, IekLocator.class);

        iekLocator.setBizz(UUID.randomUUID().toString());
        iekLocator.setIsActive(DbColumnConstants.IS_ACTIVE_Y);
        LocalDateTime now = LocalDateTime.now();
        iekLocator.setCreatedAt(now);
        iekLocator.setUpdatedAt(now);
        IekLocator save = iekLocatorRepository.save(iekLocator);

        return PojoUtils.convertEntityToDTO(save, LocatorDTO.class);
    }

    public LocatorDTO getLocatorDetails(String bizz) {
        IekLocator iekLocator = iekLocatorRepository.findByBizz(bizz);

        return PojoUtils.convertEntityToDTO(iekLocator, LocatorDTO.class);
    }

    public LocatorDTO updateLocator(String bizz, LocatorDTO locatorDTO) {
        IekLocator iekLocator = PojoUtils.convertDTOToEntity(locatorDTO, IekLocator.class);

        IekLocator existingIekLocator = iekLocatorRepository.findByBizz(bizz);
        if (existingIekLocator != null) {

            existingIekLocator.setTitle(iekLocator.getTitle());
            existingIekLocator.setWebsite(iekLocator.getWebsite());
            existingIekLocator.setAccount(iekLocator.getAccount());
            existingIekLocator.setHexSecret(iekLocator.getHexSecret());
            existingIekLocator.setRemark(iekLocator.getRemark());
            existingIekLocator.setUpdatedAt(LocalDateTime.now());

            IekLocator save = iekLocatorRepository.save(existingIekLocator);

            return PojoUtils.convertEntityToDTO(save, LocatorDTO.class);
        }
        return LocatorDTO.builder().build();
    }

    public boolean deleteLocator(String bizz) {
        IekLocator existingIekLocator = iekLocatorRepository.findByBizz(bizz);
        if (existingIekLocator != null) {
            iekLocatorRepository.delete(existingIekLocator);
            return true;
        }
        return false;
    }
}
