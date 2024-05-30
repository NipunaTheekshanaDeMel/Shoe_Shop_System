package software.nipunatheekshana.shoe_shop_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import software.nipunatheekshana.shoe_shop_management_system.entity.UserEntity;


import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.employeeEntity e WHERE e.employeeId = :employeeId")
    Optional<UserEntity> findByEmployeeId(@Param("employeeId") String employeeId);
}