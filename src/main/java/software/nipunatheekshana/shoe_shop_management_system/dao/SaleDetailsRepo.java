package software.nipunatheekshana.shoe_shop_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import software.nipunatheekshana.shoe_shop_management_system.entity.SaleDetailsEntity;


import java.util.List;

public interface SaleDetailsRepo extends JpaRepository<SaleDetailsEntity, String> {
    @Query("SELECT sd FROM SaleDetailsEntity sd WHERE sd.saleEntity.orderId = :orderId")
    List<SaleDetailsEntity> findSaleDetailsByOrderId(@Param("orderId") String orderId);
}