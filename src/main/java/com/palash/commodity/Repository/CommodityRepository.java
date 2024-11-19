package com.palash.commodity.Repository;

import com.palash.commodity.Entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityRepository extends JpaRepository<Commodity,Long> {
    Commodity findCommodityById(Long id);
}
