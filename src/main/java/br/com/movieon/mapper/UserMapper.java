package br.com.movieon.mapper;

import br.com.movieon.controller.request.UserRequest;
import br.com.movieon.controller.response.UserResponse;
import br.com.movieon.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {


    public static User toUser(UserRequest request) {

        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
