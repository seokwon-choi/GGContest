package digico.com.GGcontestb.file.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain=true)
public class FileEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String fileNm;
    @Column(length = 100000000)
    private byte[] bytes;
    private String contsType;
    private Long size;

}
