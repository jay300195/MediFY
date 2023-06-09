package com.medify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.Store;
import com.medify.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public Store saveStore(Store store) {
		return storeRepository.save(store);
	}

	@Override
	public List<Store> fetchAllStores() {	
		return storeRepository.findAll();
	}

	@Override
	public Store getStoreById(Long id) {
		Optional<Store> store=storeRepository.findById(id);
		if(store.isPresent())
		{
			return store.get();
		}
		return null;
	}

	@Override
	public Store updateStoreById(Long id, Store store) {
		return storeRepository.save(store);
	}

	@Override
	public void deleteStoreById(Long id) {
		 storeRepository.deleteById(id);
	}

	@Override
	public List<Store> fetchAllStoresByAdminId(Long adminId) {
		return storeRepository.findByAdminId(adminId);
	}

}
