package com.energyapi.demo.service;

import com.energyapi.demo.core.ResponseObject;
import com.energyapi.demo.model.BatteryModel;

import java.util.List;

public interface BatteryService {
	ResponseObject createBatteries(List<BatteryModel> batteryModel);
	ResponseObject getBatteriesByPostCodeRange(Integer start, Integer end);
}
