/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 01-Jun-2022
 * Time: 4:19 AM
 * Modified By:
 * Modified date:
 * (C) CopyRight Salahin ltd.
 */

package com.energyapi.demo.repository;

import com.energyapi.demo.entities.BatteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BatteryRepository extends JpaRepository<BatteryEntity, UUID> {
	List<BatteryEntity> findAll();

}
