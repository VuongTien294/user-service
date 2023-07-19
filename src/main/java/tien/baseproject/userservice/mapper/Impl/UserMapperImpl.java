package tien.baseproject.userservice.mapper.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tien.baseproject.userservice.dto.RegisterRequest;
import tien.baseproject.userservice.dto.UserProfileResponse;
import tien.baseproject.userservice.entity.User;
import tien.baseproject.userservice.mapper.Mapper;

@Component("userMapper")
@RequiredArgsConstructor
public class UserMapperImpl implements Mapper<UserProfileResponse, User, RegisterRequest> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserProfileResponse toDto(User entity) {
        return UserProfileResponse
                .builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .username(entity.getUsername())
                .roleType(entity.getRoleType())
                .build();
    }

    @Override
    public User toEntity(RegisterRequest request) {
        return User
                .builder()
                .email(request.getEmail())
                .username(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }


}
