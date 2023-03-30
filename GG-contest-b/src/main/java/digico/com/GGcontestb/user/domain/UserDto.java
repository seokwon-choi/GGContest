package digico.com.GGcontestb.user.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class UserDto {
  private String id;

  @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
  @Size(min = 5, max = 50)
  private String userId;

  private String pwd;

  @Size(max = 20)
  private String userNm;

  private LocalDateTime cretDt;
  private LocalDateTime updDt;
  private String cretId;
  private String updId;

  
}
