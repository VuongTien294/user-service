package tien.baseproject.userservice.service;


import tien.baseproject.userservice.dto.*;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    BaseResponse<Long> register(RegisterRequest registerRequest);

    BaseResponse<UserProfileResponse> getUserInfo(HttpServletRequest request);

    BaseResponse<Oauth2AccessToken> loginByEmail(LoginRequest loginRequest);

    BaseResponse<Oauth2AccessToken> refreshToken(RefreshTokenRequest refreshTokenRequest);
}
