package digico.com.GGcontestb.community.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import digico.com.GGcontestb.community.domain.dto.NoticeDetailDto;
import digico.com.GGcontestb.community.domain.repository.NoticeRepository;
import digico.com.GGcontestb.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    //공지사항 등록
    public Response<Object> createNotice(NoticeDetailDto noticeDto, List<MultipartFile> attachments) throws IOException {




        return new Response<Object>().responseOk(HttpStatus.OK);
    }


    //전체조회
    public Response<Object> getNoticeList() throws IOException {
        



        return new Response<Object>().responseOk(HttpStatus.OK);
    }

    //상세조회
    public Response<Object> getNoticeDetail() throws IOException {
    



        return new Response<Object>().responseOk(HttpStatus.OK);
    }

    //수정
    public Response<Object> updateNotice() throws IOException {
    



        return new Response<Object>().responseOk(HttpStatus.OK);
    }

    
    //파일 조회
    public Response<Object> getNoticeFile() throws IOException {
    



        return new Response<Object>().responseOk(HttpStatus.OK);
    }
}
