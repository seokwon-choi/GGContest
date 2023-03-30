package digico.com.GGcontestb.community.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import digico.com.GGcontestb.file.domain.entity.FileEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain=true)
// @MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String contents;
    //private ArrayList<Long> attachments = new ArrayList<Long>();
    private Long fileId;

    @CreatedDate
    private LocalDateTime cretDt;
    @LastModifiedDate
    private LocalDateTime updDt;
    @CreatedBy
    private String cretId;
    @LastModifiedBy
    private String updId;




}
