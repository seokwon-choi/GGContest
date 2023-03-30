package digico.com.GGcontestb.user.service;

import java.io.IOException;
import java.security.PrivateKey;

import org.springframework.stereotype.Service;

import digico.com.GGcontestb.response.Response;
import digico.com.GGcontestb.user.domain.SignInRequestDto;
import digico.com.GGcontestb.user.domain.TokenDto;
import digico.com.GGcontestb.user.domain.UserEntity;
import digico.com.GGcontestb.user.jwt.JwtProvider;
import digico.com.GGcontestb.user.jwt.PemUtils;
import digico.com.GGcontestb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final JwtProvider jwtProvider;
  private final PemUtils pemUtils;

  public Response<TokenDto> login(SignInRequestDto signInRequestDto) {

    var userEntity = userRepository.findByUserId(signInRequestDto.getUserId());

    if(userEntity.isEmpty()){
      try {
        throw new Exception("없는 유저");
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    if(!userEntity.get().getPwd().equals(signInRequestDto.getPwd())){
      try {
        throw new Exception("비밀번호 불일치");
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }



    PrivateKey privateKey = null;
        try {
            privateKey = pemUtils.readPrivateKeyFromFile("/Users/choiseok-won/ggcontest/GGContest/GG-contest-b/src/main/resources/private-key8.pem", "RSA");
        } catch (IOException e) {
            e.printStackTrace();
        }
    String jwt = jwtProvider.getToken(privateKey, userEntity.get());
    TokenDto tokenDto = new TokenDto();
    tokenDto.setToken(jwt);

    return new Response().responseOk(tokenDto);
  }
  
}
