package digico.com.GGcontestb.community.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import digico.com.GGcontestb.community.domain.dto.NoticeDetailDto;
import digico.com.GGcontestb.community.domain.dto.NoticeDto;
import digico.com.GGcontestb.community.domain.dto.NoticeDtoList;
import digico.com.GGcontestb.community.domain.entity.NoticeEntity;
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
    @Transactional
    public Response<NoticeDtoList> getNoticeList() throws IOException {

        List<NoticeEntity> pageNotice = noticeRepository.findAll();

        List<NoticeDto> noticeList = new ArrayList<>();

        for(NoticeEntity notice: pageNotice){
            NoticeDto noticeDto = new NoticeDto();

            BeanUtils.copyProperties(notice, noticeDto);

            noticeList.add(noticeDto);
        }

        NoticeDtoList dtoList = new NoticeDtoList();
        dtoList.setNoticeList(noticeList);
        dtoList.setTotalCnt(noticeList.size());

        return new Response<NoticeDtoList>().responseOk(dtoList);
    }

    //상세조회
    public Response<NoticeDetailDto> getNoticeDetail(Long id) throws IOException {

        NoticeEntity notice = noticeRepository.findById(id);
        NoticeDetailDto noticeDto = new NoticeDetailDto();

        BeanUtils.copyProperties(notice, noticeDto);

        return new Response<NoticeDetailDto>().responseOk(noticeDto);
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
