/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 01-Jun-2022
 * Time: 1:00 AM
 * Modified By:
 * Modified date:
 * (C) CopyRight Salahin ltd.
 */

package com.energyapi.demo.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseModel {

	@JsonIgnore
	private Date createdDate;
	
	@JsonIgnore
	private Date updatedDate;
}
