package tien.baseproject.userservice.utils;

import tien.baseproject.userservice.exception.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Objects;

public class HeaderUtils {
    public static final String ROLE = "roles";
    public static final String WALLET_ADDRESS = "wallet_address";
    public static final String USER_ID = "user_id";

    public static Long getUserId(HttpServletRequest request) {
        String userId = request.getHeader(USER_ID);
        if (Objects.isNull(userId)) {
            throw new NotFoundException(Collections.singletonList("Not found userId"));
        }

        return Long.valueOf(userId);
    }
}
