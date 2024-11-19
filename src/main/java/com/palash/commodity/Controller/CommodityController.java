package com.palash.commodity.Controller;

import com.palash.commodity.Entity.Commodity;
import com.palash.commodity.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
@CrossOrigin("*")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Commodity>> getAll(){
        try{
            return new ResponseEntity<>(commodityService.getAllCommodities(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Commodity> addCommodity(@RequestBody Commodity commodity){
        try{
            return new ResponseEntity<>(commodityService.createCommodity(commodity),HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Commodity> updateCommodity(@PathVariable Long id, @RequestBody Commodity newCommodity){
        try{
            return new ResponseEntity<>(commodityService.updateCommodity(id,newCommodity),HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteCommodity(@PathVariable Long id){
        try{
            commodityService.deleteCommodity(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
