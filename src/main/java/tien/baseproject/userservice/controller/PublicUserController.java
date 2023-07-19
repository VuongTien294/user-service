package tien.baseproject.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tien.baseproject.userservice.dto.BaseResponse;
import tien.baseproject.userservice.dto.RegisterRequest;
import tien.baseproject.userservice.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/public-api/users")
@RequiredArgsConstructor
public class PublicUserController {

    private final UserService userService;

    @PostMapping()
    public BaseResponse<Long> register(@RequestBody @Valid RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

}
