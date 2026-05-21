package com.sushma.olxmasterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sushma.olxmasterdata.entity.AdvertiseStatusEntity;

@Repository
public interface AdvertiseStatusRepository extends JpaRepository<AdvertiseStatusEntity, Integer> {
}
