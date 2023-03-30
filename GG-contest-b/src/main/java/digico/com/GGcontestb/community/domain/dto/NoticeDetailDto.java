package digico.com.GGcontestb.community.domain.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import digico.com.GGcontestb.file.domain.entity.FileEntity;
import lombok.Data;

@Data
public class NoticeDetailDto {
    
    private Long id;
    private String title;
    private String contents;
    //private ArrayList<FileEntity> arrayList = new ArrayList<FileEntity>();
    private Long fileId;
 
    private LocalDateTime cretDt;
    private LocalDateTime updDt;
    private String cretId;
    private String updId;
}
