package com.palash.commodity.Service;

import com.palash.commodity.Entity.Commodity;
import com.palash.commodity.Repository.CommodityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommodityServiceTest {
    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityRepository commodityRepository;

    @Test
     void TestCreateCommodity() {
        Commodity commodity = new Commodity(null, "Steel", "Metal", 500L, "3000", 1500000L);
        Commodity savedCommodity = commodityService.createCommodity(commodity);
        assertNotNull(savedCommodity.getId());
        commodityRepository.delete(savedCommodity);
    }

    @Test
     void TestGetAllCommodity() {
        Commodity commodity = new Commodity(null, "Steel", "Metal", 500L, "3000", 1500000L);
        commodityRepository.save(commodity);
        assertFalse(commodityService.getAllCommodities().isEmpty());
        commodityRepository.delete(commodity);
    }

    @Test
     void TestDeleteCommodity() {
        Commodity commodity = new Commodity(null, "Steel", "Metal", 500L, "3000", 1500000L);
        Commodity savedCommodity = commodityRepository.save(commodity);
        commodityService.deleteCommodity(savedCommodity.getId());
        assertFalse(commodityRepository.findById(savedCommodity.getId()).isPresent());
    }

    @Test
     void TestUpdateCommodity() {
        Commodity commodity = new Commodity(null, "Steel", "Metal", 500L, "3000", 1500000L);
        Commodity savedCommodity = commodityRepository.save(commodity);
        Commodity updatedCommodity = new Commodity(savedCommodity.getId(), "Steel", "Metal", 500L, "5000", 2500000L);
        Commodity testCommodity = commodityService.updateCommodity(savedCommodity.getId(), updatedCommodity);
        assertEquals(updatedCommodity.getUnitPrice(), testCommodity.getUnitPrice());
        assertEquals(updatedCommodity.getTotalValue(), testCommodity.getTotalValue());
        commodityRepository.delete(testCommodity);
    }
}
