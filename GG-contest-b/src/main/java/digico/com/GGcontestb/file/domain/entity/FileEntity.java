package digico.com.GGcontestb.file.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain=true)
public class FileEntity {

    @Id
    //@org.springframework.data.annotation.Id
    private String id;
    private String fileNm;
    private byte[] bytes;
    private String contsType;
    private Long size;

}
