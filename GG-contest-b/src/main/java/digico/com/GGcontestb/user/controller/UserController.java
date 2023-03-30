package digico.com.GGcontestb.user.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import digico.com.GGcontestb.response.Response;
import digico.com.GGcontestb.user.domain.SignInRequestDto;
import digico.com.GGcontestb.user.domain.TokenDto;
import digico.com.GGcontestb.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/google/v1")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;


  @PostMapping("/signIn")
	public Response<TokenDto> login(@RequestBody SignInRequestDto signInRequestDto) {
		return userService.login(signInRequestDto);
	}
	
}
