package tien.baseproject.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tien.baseproject.userservice.constant.ErrorCodes;
import tien.baseproject.userservice.constant.TokenTypeEnum;
import tien.baseproject.userservice.dto.*;
import tien.baseproject.userservice.entity.User;
import tien.baseproject.userservice.exception.BadRequestException;
import tien.baseproject.userservice.exception.NotFoundException;
import tien.baseproject.userservice.exception.UserRegistrationException;
import tien.baseproject.userservice.mapper.Mapper;
import tien.baseproject.userservice.repository.UserRepository;
import tien.baseproject.userservice.service.UserService;
import tien.baseproject.userservice.utils.HeaderUtils;
import tien.baseproject.userservice.utils.JwtTokenUtils;
import tien.baseproject.userservice.utils.ServletUtils;
import tien.baseproject.userservice.utils.UserCacheUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JwtTokenUtils jwtTokenUtils;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserCacheUtils userCacheUtils;
    private final Mapper<UserProfileResponse, User, RegisterRequest> userMapper;

    @Override
    public BaseResponse<Long> register(RegisterRequest registerRequest) {
        BaseResponse<Long> response = new BaseResponse<>();
        User user = userRepository.findByUsername(registerRequest.getEmail()).orElse(null);
        if (user != null) {
            throw new UserRegistrationException(Collections.singletonList(ErrorCodes.USER_ALREADY_EXISTED));
        }
        user = userRepository.save(userMapper.toEntity(registerRequest));
        response.setData(user.getId());
        return response;
    }

    @SneakyThrows
    @Override
    public BaseResponse<UserProfileResponse> getUserInfo(HttpServletRequest request) {
        BaseResponse<UserProfileResponse> baseResponse = new BaseResponse<>();
        Long userId = HeaderUtils.getUserId(request);

        User user = userCacheUtils.getUserFromCache(userId);
        if (user == null) {
            user = userRepository
                    .findById(userId)
                    .orElseThrow(() -> new NotFoundException(Collections.singletonList(ErrorCodes.USER_NOT_FOUND)));
            if (user != null) {
                userCacheUtils.saveUserToCache(user);
            }
        }
        baseResponse.setData(userMapper.toDto(user));
        return baseResponse;
    }

    @Override
    public BaseResponse<Oauth2AccessToken> loginByEmail(LoginRequest loginRequest) {
        User user = userRepository
                .findByUsername(loginRequest.getEmail())
                .orElseThrow(() -> new NotFoundException(Collections.singletonList(ErrorCodes.USER_NOT_FOUND)));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadRequestException(Collections.singletonList(ErrorCodes.INVALID_PASSWORD));
        }

        BaseResponse<Oauth2AccessToken> response = new BaseResponse<>();

        response.setData(jwtTokenUtils.generateOauth2AccessToken(user));

        return response;
    }

    @SneakyThrows
    @Override
    public BaseResponse<Oauth2AccessToken> refreshToken(RefreshTokenRequest refreshTokenRequest) {
        BaseResponse<Oauth2AccessToken> response = new BaseResponse<>();
        if (jwtTokenUtils.getTokenType(refreshTokenRequest.getRefreshToken()).equals(TokenTypeEnum.REFRESH_TOKEN.getCode())) {
            userRepository
                    .findById(jwtTokenUtils.getUserIdFromToken(refreshTokenRequest.getRefreshToken()))
                    .ifPresent(user -> response.setData(jwtTokenUtils.generateOauth2AccessToken(user)));
        }
        return response;
    }
}
