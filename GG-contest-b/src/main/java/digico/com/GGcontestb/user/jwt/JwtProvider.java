package digico.com.GGcontestb.user.jwt;

import java.security.PrivateKey;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


import digico.com.GGcontestb.user.domain.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtProvider {

  public static String getToken(PrivateKey privateKey, UserEntity userEntity){

    Map<String, Object> headers = new HashMap<>();
    headers.put("type", "JWT");

    Map<String, Object> payloads = new HashMap<>();
    payloads.put("userId", userEntity.getUserId());
    payloads.put("userNm", userEntity.getUserNm());

    String jwt = Jwts
        .builder()
        .setHeader(headers)
        .setClaims(payloads)
        .signWith(SignatureAlgorithm.RS256, privateKey)
        .compact();
     return jwt;
   }
}
