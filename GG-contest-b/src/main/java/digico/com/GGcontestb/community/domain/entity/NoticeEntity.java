package digico.com.GGcontestb.community.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import digico.com.GGcontestb.file.domain.entity.FileEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain=true)
public class NoticeEntity {

    @Id
    @GeneratedValue()
    private Integer id;
    private String title;
    private String contents;
    private ArrayList<FileEntity> arrayList = new ArrayList<FileEntity>();
    
    @CreatedDate
    private LocalDateTime cretDt;
    @LastModifiedDate
    private LocalDateTime updDt;
    @CreatedBy
    private String cretId;
    @LastModifiedBy
    private String updId;

    

    
}
