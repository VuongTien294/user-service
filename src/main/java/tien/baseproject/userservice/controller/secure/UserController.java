package tien.baseproject.userservice.controller.secure;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tien.baseproject.userservice.dto.BaseResponse;
import tien.baseproject.userservice.dto.UserProfileResponse;
import tien.baseproject.userservice.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public BaseResponse<UserProfileResponse> getUserInfo(HttpServletRequest request) {
        return userService.getUserInfo(request);
    }
}
