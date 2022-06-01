package com.energyapi.demo.service;

import com.energyapi.demo.core.ResponseObject;
import com.energyapi.demo.model.BatteryModel;

import java.util.List;

public interface BatteryService {
	ResponseObject createBattery(List<BatteryModel> batteryModel);
	ResponseObject getAllBatteries();
}
