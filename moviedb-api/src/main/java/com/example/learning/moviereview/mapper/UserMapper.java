package com.example.learning.moviereview.mapper;

import com.example.learning.moviereview.user.dto.UserAuthenticationResponse;
import com.example.learning.moviereview.user.dto.UserView;
import com.example.learning.moviereview.user.User;

public class UserMapper {

    private UserMapper() {}

    public static UserView userToUserView(User user) {
        return new UserView(
                user.getId(), user.getName(), user.getEmail());
    }

    public static UserAuthenticationResponse userToUserAuthenticationResponse(
            User user, String jwtToken) {
        return new UserAuthenticationResponse(user.getId(), user.getEmail(), jwtToken);
    }
}
