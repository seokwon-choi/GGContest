package digico.com.GGcontestb.file.domain.dto;

import lombok.Data;

@Data
public class FileDto {

    private String id;
    private String fileNm;
    private byte[] bytes;
    private String contsType;
    private Long size;
    
}
