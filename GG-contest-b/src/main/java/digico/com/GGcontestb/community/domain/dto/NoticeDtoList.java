package digico.com.GGcontestb.community.domain.dto;

import java.util.List;

import lombok.Data;

@Data
public class NoticeDtoList {

    private List<NoticeDto> noticeList;
    private Integer totalCnt;
}
