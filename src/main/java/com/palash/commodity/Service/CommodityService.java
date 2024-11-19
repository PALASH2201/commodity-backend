package com.palash.commodity.Service;

import com.palash.commodity.Entity.Commodity;
import com.palash.commodity.Repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {
    @Autowired
    private CommodityRepository commodityRepository;

    public Commodity createCommodity(Commodity commodity){
        commodity.setTotalValue(Long.parseLong(commodity.getQuantity()) * commodity.getUnitPrice());
        return commodityRepository.save(commodity);
    }

    public void deleteCommodity(Long id){
        commodityRepository.deleteById(id);
    }

    public List<Commodity> getAllCommodities(){
        return commodityRepository.findAll();
    }

    public Commodity getCommodityById(Long id){
        return commodityRepository.findCommodityById(id);
    }

    public Commodity updateCommodity(Long id, Commodity commodity) {
        return commodityRepository.findById(id).map(existingCommodity -> {
            existingCommodity.setName(commodity.getName());
            existingCommodity.setCategory(commodity.getCategory());
            existingCommodity.setUnitPrice(commodity.getUnitPrice());
            existingCommodity.setQuantity(commodity.getQuantity());
            existingCommodity.setTotalValue(commodity.getTotalValue());
            return commodityRepository.save(existingCommodity);
        }).orElseThrow(() -> new RuntimeException("Commodity not found with id " + id));
    }
}
