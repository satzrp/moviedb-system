package com.example.learning.moviereview.user;

import com.example.learning.moviereview.common.response.ApiResponse;
import com.example.learning.moviereview.user.dto.UserLoginRequest;
import com.example.learning.moviereview.user.dto.UserRegisterRequest;
import com.example.learning.moviereview.user.dto.UserAuthenticationResponse;
import com.example.learning.moviereview.user.dto.UserView;
import com.example.learning.moviereview.user.exceptions.UserEmailAlreadyExistsException;
import com.example.learning.moviereview.user.exceptions.UserNotFoundException;
import com.example.learning.moviereview.utils.jwt.JwtManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import static com.example.learning.moviereview.mapper.UserMapper.userToUserAuthenticationResponse;
import static com.example.learning.moviereview.mapper.UserMapper.userToUserView;

@Slf4j
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

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserAuthenticationResponse>> register(
            @RequestBody UserRegisterRequest userRegisterRequest) {
        try {
            User newUser = userService.register(
                    userRegisterRequest.email(),
                    userRegisterRequest.password(),
                    userRegisterRequest.name());
            var jwtToken = jwtManager.generateJwtToken(newUser);
            var userAuthResponse = userToUserAuthenticationResponse(newUser, jwtToken);
            return ResponseEntity.ok(new ApiResponse<>(userAuthResponse, "", "SUCCESS"));
        } catch (UserEmailAlreadyExistsException e) {
            log.error("Invalid Registration Attempt: {}", userRegisterRequest.email());
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse<>(null, "User already exists", "FAIL"));
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserAuthenticationResponse>> login(
            @RequestBody UserLoginRequest userLoginRequest) {
        try {
            var user = userService.login(userLoginRequest.email(), userLoginRequest.password());
            var jwtToken = jwtManager.generateJwtToken(user);
            var userAuthResponse = userToUserAuthenticationResponse(user, jwtToken);
            return ResponseEntity.ok(new ApiResponse<>(userAuthResponse, "", "SUCCESS"));
        } catch (BadCredentialsException ex) {
            log.error("Invalid Login Attempt: {}", userLoginRequest.email());
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse<>(null, "Invalid Login Credentials", "FAIL"));
        }
    }

    // TODO: send valid response for UserNotFoundException
    @GetMapping("/{userId}")
    public ResponseEntity<UserView> getUserDetails(@PathVariable Integer userId)
            throws UserNotFoundException {
        var user = userService.getUserDetails(userId);
        return ResponseEntity.ok(userToUserView(user));
    }
}
