package digico.com.GGcontestb.file.domain.dto;

import lombok.Data;

@Data
public class FileResDto {

    private Long id;
    
    private String fileNm;

    private String bytesString;

    private String contsType;
    
    private Long size;
}
