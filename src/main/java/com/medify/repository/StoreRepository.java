package com.medify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medify.entity.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	List<Store> findByAdminId(Long adminId);
}
