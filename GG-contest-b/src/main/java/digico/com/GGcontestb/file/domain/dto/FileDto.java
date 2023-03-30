package digico.com.GGcontestb.file.domain.dto;

import lombok.Data;

@Data
public class FileDto {

    private Long id;
    private String fileNm;
    private byte[] bytes;
    private String contsType;
    private Long size;
    
}
