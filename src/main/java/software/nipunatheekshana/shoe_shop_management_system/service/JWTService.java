package software.nipunatheekshana.shoe_shop_management_system.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String  token, UserDetails userDetails);
}