package digico.com.GGcontestb.community.domain.dto;

import java.util.ArrayList;

import digico.com.GGcontestb.file.domain.entity.FileEntity;

public class NoticeDto {
    
    private Integer id;
    private String title;
    private String contents;
    private ArrayList<FileEntity> arrayList = new ArrayList<FileEntity>();
 
    
}
