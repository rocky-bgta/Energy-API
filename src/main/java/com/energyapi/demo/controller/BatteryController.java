/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 01-Jun-2022
 * Time: 12:31 PM
 * Modified By:
 * Modified date:
 * (C) CopyRight Salahin ltd.
 */

package com.energyapi.demo.controller;

import com.energyapi.demo.core.ResponseObject;
import com.energyapi.demo.model.BatteryModel;
import com.energyapi.demo.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/battery",
	consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE, MediaType.ALL_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)
public class BatteryController {
	
    private final BatteryService batteryService;
	
    @Autowired
	public BatteryController(BatteryService batteryService) {
		this.batteryService = batteryService;
	}
	
	@PostMapping("create")
    public ResponseEntity createBattery(@RequestBody List<BatteryModel> batteryModels){
        ResponseObject responseObject;
		System.out.println(batteryModels);
		responseObject = this.batteryService.createBattery(batteryModels);
		return new ResponseEntity(responseObject,HttpStatus.CREATED);

    }
	

	@GetMapping("list")
	public ResponseEntity<ResponseObject> getAllBatteries(){
		ResponseObject responseObject;
		responseObject = this.batteryService.getAllBatteries();
		return new ResponseEntity(responseObject,HttpStatus.OK);
	}

	
}
