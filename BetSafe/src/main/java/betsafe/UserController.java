package betsafe;

import betsafe.model.User;
import betsafe.repository.UserRepository;
import betsafe.security.jwt.AuthenticationRequest;
import betsafe.security.jwt.AuthenticationResponse;
import betsafe.security.jwt.JwtUtil;
import betsafe.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/register")
    public @ResponseBody User registerUser(@RequestBody User user) {
        userService.signUpUser(user);
        return user;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println(authenticationRequest.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Bad username or password");
        }
        final UserDetails userDetails = userService.loadUserByUsername(
                authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/user")
    public User secret(@RequestHeader(name="Authorization") String token){
        String username = jwtUtil.extractUsername(token.substring(7));
        return (User) userService.loadUserByUsername(username);
    }


}

