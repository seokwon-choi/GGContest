package digico.com.GGcontestb.community.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticeDto {
    
    private Long id;
    private String title;
    private String contents;
 
    private LocalDateTime cretDt;
    private LocalDateTime updDt;
    private String cretId;
    private String updId;
}
