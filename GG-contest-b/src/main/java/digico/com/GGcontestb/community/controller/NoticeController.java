package digico.com.GGcontestb.community.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;

import digico.com.GGcontestb.community.domain.dto.NoticeDetailDto;
import digico.com.GGcontestb.community.domain.dto.NoticeDto;
import digico.com.GGcontestb.community.domain.dto.NoticeDtoList;
import digico.com.GGcontestb.community.domain.entity.NoticeEntity;
import digico.com.GGcontestb.community.service.NoticeService;
import digico.com.GGcontestb.file.domain.dto.FileResDto;
import digico.com.GGcontestb.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/google/v1")
@RequiredArgsConstructor
@Slf4j
public class NoticeController {

    private final NoticeService noticeService;

    // Create
    @PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Response<Object> createNotice(@RequestPart(value = "notice", required = true) NoticeDetailDto noticeDto,
            @RequestPart(value = "attachments", required = false) MultipartFile attach) throws IOException {
        return noticeService.createNotice(noticeDto, attach);
    }

    // Read
    // 전체조회
    @GetMapping(value = "/getNoticeList")
    public Response<NoticeDtoList> getNoticeList() throws IOException {
        return noticeService.getNoticeList();
    }

    // 상세조회
    @GetMapping(value = "/getNoticeById")
    public Response<NoticeDetailDto> getNoticeDetail(Long id) throws IOException {
        return noticeService.getNoticeDetail(id);
    }

    // Update
    // @PostMapping(value = "/notice", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE,
    //         MediaType.MULTIPART_FORM_DATA_VALUE })
    // public Response<Object> updateNotice(@RequestPart(value = "notice", required = true) AdmNoticeDto noticeDto,
    //         @RequestPart(value = "thumbNail", required = false) MultipartFile noticeImg,
    //         @RequestPart(value = "attachments", required = false) List<MultipartFile> imgFile) throws IOException {
    //     return noticeService.updateNotice(noticeDto, noticeImg, imgFile);
    // }


    // GetFile
    @GetMapping(value = "/getNoticeFile")
    public Response<FileResDto> getNoticeFile(@RequestParam("objectList") Long attachments) throws IOException {
        return noticeService.getNoticeFile(attachments);
    }


}
