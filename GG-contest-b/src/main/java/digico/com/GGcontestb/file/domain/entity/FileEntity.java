package digico.com.GGcontestb.file.domain.entity;

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
    //@org.springframework.data.annotation.Id
    private Long id;
    private String fileNm;
    private byte[] bytes;
    private String contsType;
    private Long size;

}
