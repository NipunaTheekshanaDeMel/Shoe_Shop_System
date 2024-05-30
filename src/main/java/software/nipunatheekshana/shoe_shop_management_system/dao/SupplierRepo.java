package software.nipunatheekshana.shoe_shop_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.nipunatheekshana.shoe_shop_management_system.entity.SupplierEntity;


@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity,String> {
}