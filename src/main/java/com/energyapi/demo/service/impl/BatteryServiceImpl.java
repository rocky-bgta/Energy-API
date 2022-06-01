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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {

    private static final ModelMapper modelMapper = new ModelMapper();

    private final BatteryRepository batteryRepository;

    public BatteryServiceImpl(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }


    @Override
    public ResponseObject createBatteries(List<BatteryModel> batteryModels) {
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
    public ResponseObject getBatteriesByPostCodeRange(Integer start, Integer end) {
        ResponseObject responseObject;
        List<BatteryEntity> batteryList = batteryRepository.findByPostCodeRange(start,end);

        List<BatteryEntity> sortedBatteryListByName = batteryList.stream()
                .sorted(Comparator.comparing(n->n.getName().toLowerCase()))
                .collect(Collectors.toList());


        responseObject = UtilityMethods.buildResponseObject(sortedBatteryListByName,
                MessageConstant.SUCCESSFULLY_GET_ALL_BATTERY,
                HttpStatus.OK);
        return responseObject;
    }
}
