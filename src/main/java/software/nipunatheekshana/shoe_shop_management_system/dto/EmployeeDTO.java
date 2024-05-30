package software.nipunatheekshana.shoe_shop_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Gender;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Role;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String employeeId;
    private String name;
    private String profilePic;
    private Gender gender;
    private String civilState;
    private String designation;
    @Past(message = "Date of birth should be in the past")
    private Date dob;
    @PastOrPresent(message = "Join date must be in the past or present")
    private Date joinedDate;
    private String address;
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact;
    @Email(message = "Invalid email format")
    private String email;
    private String guardian;
    private String emergencyContact;
    private Role accessRole;
}