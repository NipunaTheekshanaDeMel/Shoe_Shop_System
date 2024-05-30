package software.nipunatheekshana.shoe_shop_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import software.nipunatheekshana.shoe_shop_management_system.entity.RefundEntity;


public interface RefundRepo extends JpaRepository<RefundEntity, String> {
}