package software.nipunatheekshana.shoe_shop_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Gender;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Level;


import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer")
@Entity
public class CustomerEntity implements SuperEntity {
    @Id
    private String customerCode;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date joinDate;
    @Enumerated(EnumType.STRING)
    private Level level;
    private int totalPoints;
    private Date dob;
    private String addressNo;
    private String lane;
    private String mainCity;
    private String mainState;
    private String postalCode;
    private String contactNumber;
    @Column(unique = true)
    private String email;
    private Timestamp recentPurchaseDate;
}
