package tien.baseproject.userservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Oauth2AccessToken {
    private String accessToken;
    private String refreshToken;
}
