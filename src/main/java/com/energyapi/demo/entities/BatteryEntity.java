/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 1-Jun-2022
 * Time: 11:44 PM
 * Modified By:
 * Modified date:
 * (C) CopyRight Salahin ltd.
 */

package com.energyapi.demo.entities;

import com.energyapi.demo.core.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "battery")
public class BatteryEntity extends BaseEntity {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", nullable = false)
	private UUID id;
	
	@Column(name="postcode")
	private Integer postcode;
	
	@Column(name="watt")
	private Integer watt;
}
