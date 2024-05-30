package software.nipunatheekshana.shoe_shop_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import software.nipunatheekshana.shoe_shop_management_system.entity.SizeEntity;


import java.util.Optional;

@Repository
public interface SizeRepo extends JpaRepository<SizeEntity, String> {
    Optional<SizeEntity> findBySize(@Param("size") Integer size);
}