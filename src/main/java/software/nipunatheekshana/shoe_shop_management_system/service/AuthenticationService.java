package software.nipunatheekshana.shoe_shop_management_system.service;

import software.nipunatheekshana.shoe_shop_management_system.reqAndresp.reponse.JwtAuthResponse;
import software.nipunatheekshana.shoe_shop_management_system.reqAndresp.secure.SignIn;
import software.nipunatheekshana.shoe_shop_management_system.reqAndresp.secure.SignUp;


public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
    JwtAuthResponse refreshToken(String accessToken);
}