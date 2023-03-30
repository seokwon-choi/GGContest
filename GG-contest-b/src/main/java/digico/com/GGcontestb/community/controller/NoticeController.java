package digico.com.GGcontestb.community.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import digico.com.GGcontestb.community.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/google/v1")
@RequiredArgsConstructor
@Slf4j
public class NoticeController {


    private final NoticeService noticeService;

    // Create
    // @PostMapping(value = "/createNotice", consumes = { MediaType.APPLICATION_JSON_VALUE,
    //         MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    // public Response<Object> createNotice(@RequestPart(value = "notice", required = true) AdmNoticeDto noticeDto,
    //         @RequestPart(value = "thumbNail", required = false) MultipartFile noticeImg,
    //         @RequestPart(value = "attachments", required = false) List<MultipartFile> imgFile) throws IOException {
    //     return noticeService.createNotice(noticeDto, noticeImg, imgFile);
    // }

    // // Readø
    // // 전체조회
    // @GetMapping(value = "/getNoticeList")
    // public Response<List<AdmNoticeDto>> getNoticeList(Pageable pageable, NoticeQueryParameter noticeQueryParameter) {
    //     return noticeService.getNoticeList(pageable, noticeQueryParameter);
    // }

    // // 상세조회
    // @GetMapping(value = "/getNoticeById")
    // public Response<AdmNoticeDto> getNoticeDetail(@RequestParam(value = "id") String objectId) {
    //     return noticeService.getNoticeDetail(objectId);
    // }

    // // Update
    // @PostMapping(value = "/notice", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE,
    //         MediaType.MULTIPART_FORM_DATA_VALUE })
    // public Response<Object> updateNotice(@RequestPart(value = "notice", required = true) AdmNoticeDto noticeDto,
    //         @RequestPart(value = "thumbNail", required = false) MultipartFile noticeImg,
    //         @RequestPart(value = "attachments", required = false) List<MultipartFile> imgFile) throws IOException {
    //     return noticeService.updateNotice(noticeDto, noticeImg, imgFile);
    // }


    // // GetFile
    // @GetMapping(value = "/getNoticeFile")
    // @ApiOperation(value = "이미지 파일 조회")
    // public Response<List<AdmFileResDto>> getNoticeFile(@RequestParam("objectList") List<String> attachments) {
    //     return noticeService.getNoticeFile(attachments);
    // }

    
}
