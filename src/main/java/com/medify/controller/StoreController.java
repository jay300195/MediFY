package com.medify.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medify.entity.Store;
import com.medify.service.StoreService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getStore() {
        return storeService.fetchAllStores();
    }
    
    @GetMapping("/getStoreByUserId/{userId}")
    public List<Store> getStoreByUserId(@PathVariable Long userId) {
        return storeService.fetchAllStoresByAdminId(userId);
    }

    @GetMapping("/{storeId}")
    public Store getStore(@PathVariable Long storeId) {
        return storeService.getStoreById(storeId);
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store savedStore = storeService.saveStore(store);
        return ResponseEntity.ok(savedStore);
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable Long storeId, @RequestBody Store store) {
        Store currentStore = storeService.updateStoreById(null, store);
        return ResponseEntity.ok(currentStore);
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<Store> deleteStore(@PathVariable Long storeId) {
        storeService.deleteStoreById(storeId);
        return ResponseEntity.ok().build();
    }

}
