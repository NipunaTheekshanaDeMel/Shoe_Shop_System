package software.nipunatheekshana.shoe_shop_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Gender;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Level;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;



import java.util.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String customerId;
    private String name;
    private Gender gender;
    @PastOrPresent(message = "Join date must be in the past or present")
    private Date joinedDate;
    @Past(message = "Date of birth should be in the past")
    private Date dob;
    private String address;
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact;
    @Email(message = "Invalid email format")
    private String email;
    //TODO: get tha last purchase date with sale entity
    private Date lastSaleDate;
}