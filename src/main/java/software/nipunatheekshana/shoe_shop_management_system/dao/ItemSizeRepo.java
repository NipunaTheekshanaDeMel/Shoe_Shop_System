package software.nipunatheekshana.shoe_shop_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import software.nipunatheekshana.shoe_shop_management_system.entity.ItemSizeEntity;


import java.util.Optional;

@Repository
public interface ItemSizeRepo extends JpaRepository<ItemSizeEntity, String> {
    @Query(value = "SELECT * FROM item_size WHERE itemCode = :itemCode AND sizeId = :sizeId", nativeQuery = true)
    Optional<ItemSizeEntity> findByItemCodeAndSizeId(@Param("itemCode") String itemCode, @Param("sizeId") String sizeId);
}