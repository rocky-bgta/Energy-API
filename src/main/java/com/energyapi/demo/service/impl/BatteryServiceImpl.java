package com.energyapi.demo.service.impl;

import com.energyapi.demo.constant.MessageConstant;
import com.energyapi.demo.core.ResponseObject;
import com.energyapi.demo.entities.BatteryEntity;
import com.energyapi.demo.model.BatteryModel;
import com.energyapi.demo.repository.BatteryRepository;
import com.energyapi.demo.service.BatteryService;
import com.energyapi.demo.utilities.UtilityMethods;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BatteryServiceImpl implements BatteryService {

    private static final ModelMapper modelMapper = new ModelMapper();

    private final BatteryRepository batteryRepository;

    public BatteryServiceImpl(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }


    @Override
    public ResponseObject createBattery(List<BatteryModel> batteryModels) {
        ResponseObject responseObject;
        List<BatteryEntity> batteryEntities = Arrays.asList(modelMapper.map(batteryModels, BatteryEntity[].class));
        batteryEntities = batteryRepository.saveAll(batteryEntities);
        batteryModels = Arrays.asList(modelMapper.map(batteryEntities, BatteryModel[].class));
        responseObject = UtilityMethods.buildResponseObject(batteryModels,
                MessageConstant.SUCCESSFULLY_BATTERY_LIST_CREATED,
                HttpStatus.CREATED);

        return responseObject;
    }

    @Override
    public ResponseObject getAllBatteries() {
        return null;
    }
}
