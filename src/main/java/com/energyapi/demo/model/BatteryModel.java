package com.energyapi.demo.model;

import com.energyapi.demo.core.BaseModel;
import lombok.Data;

import java.util.UUID;

@Data
public class BatteryModel extends BaseModel {

    private UUID id;
    private Integer postcode;
    private Integer watt;
}
