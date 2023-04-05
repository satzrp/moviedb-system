package com.example.learning.moviereview.user;

import com.example.learning.moviereview.user.dto.UserLoginRequest;
import com.example.learning.moviereview.user.dto.UserRegisterRequest;
import com.example.learning.moviereview.user.dto.UserAuthenticationResponse;
import com.example.learning.moviereview.user.dto.UserView;
import com.example.learning.moviereview.user.exceptions.UserEmailAlreadyExistsException;
import com.example.learning.moviereview.user.exceptions.UserNotFoundException;
import com.example.learning.moviereview.utils.jwt.JwtManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.learning.moviereview.mapper.UserMapper.userToUserAuthenticationResponse;
import static com.example.learning.moviereview.mapper.UserMapper.userToUserView;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    private final JwtManager jwtManager;

    @Autowired
    public UserController(UserService userService, JwtManager jwtManager) {
        this.userService = userService;
        this.jwtManager = jwtManager;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAuthenticationResponse> register(@RequestBody UserRegisterRequest userRegisterRequest)
            throws UserEmailAlreadyExistsException {
        var newUser = userService.register(
                userRegisterRequest.email(),
                userRegisterRequest.password(),
                userRegisterRequest.name());
        var jwtToken = jwtManager.generateJwtToken(newUser);
        var userAuthResponse = userToUserAuthenticationResponse(newUser, jwtToken);
        return ResponseEntity.ok(userAuthResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        var user = userService.login(userLoginRequest.email(), userLoginRequest.password());
        var jwtToken = jwtManager.generateJwtToken(user);
        var userAuthResponse = userToUserAuthenticationResponse(user, jwtToken);
        return ResponseEntity.ok(userAuthResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserView> getUserDetails(@PathVariable Integer userId)
            throws UserNotFoundException {
        var user = userService.getUserDetails(userId);
        return ResponseEntity.ok(userToUserView(user));
    }
}
