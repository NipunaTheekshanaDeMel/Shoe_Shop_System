package software.nipunatheekshana.shoe_shop_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.nipunatheekshana.shoe_shop_management_system.reqAndresp.reponse.JwtAuthResponse;
import software.nipunatheekshana.shoe_shop_management_system.reqAndresp.secure.SignIn;
import software.nipunatheekshana.shoe_shop_management_system.reqAndresp.secure.SignUp;
import software.nipunatheekshana.shoe_shop_management_system.service.AuthenticationService;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }

}
