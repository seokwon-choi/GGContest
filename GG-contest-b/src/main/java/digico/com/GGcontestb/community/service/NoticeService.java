package digico.com.GGcontestb.community.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import digico.com.GGcontestb.community.domain.dto.NoticeDetailDto;
import digico.com.GGcontestb.community.domain.dto.NoticeDto;
import digico.com.GGcontestb.community.domain.dto.NoticeDtoList;
import digico.com.GGcontestb.community.domain.entity.NoticeEntity;
import digico.com.GGcontestb.community.domain.repository.NoticeRepository;
import digico.com.GGcontestb.file.domain.dto.FileDto;
import digico.com.GGcontestb.file.domain.dto.FileResDto;
import digico.com.GGcontestb.file.domain.entity.FileEntity;
import digico.com.GGcontestb.file.domain.repository.FileRepository;
import digico.com.GGcontestb.response.Response;
import digico.com.GGcontestb.response.StatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final FileRepository fileRepository;



    //공지사항 등록
    @Transactional
    public Response<Object> createNotice(NoticeDetailDto noticeDto, MultipartFile attachments) throws IOException {

        NoticeEntity noticeEntity = new NoticeEntity();

        BeanUtils.copyProperties(noticeDto, noticeEntity, "attachments");

        noticeEntity.setCretDt(LocalDateTime.now());
        noticeEntity.setUpdDt(LocalDateTime.now());

        if(attachments!= null){
            FileEntity fileEntity = new FileEntity();
            fileEntity.setBytes(Base64.getEncoder().encode(attachments.getBytes()))
                    .setContsType(attachments.getContentType())
                    .setFileNm(attachments.getOriginalFilename())
                    .setSize(attachments.getSize());

            FileEntity returnFile = fileRepository.save(fileEntity); // 파일들을 모두 저장해준다.

            noticeEntity.setFileId(returnFile.getId());
        }

        noticeRepository.save(noticeEntity);

        return new Response<Object>().responseOk(StatusEnum.SUCCESS);

    }

        // if (attachments != null) {

        //     ArrayList<Long> attachmentsList = new ArrayList<>();
        //     for (MultipartFile file : attachments) {
        //         FileEntity fileEntity = new FileEntity();
        //         fileEntity.setBytes(Base64.getEncoder().encode(file.getBytes()))
        //                 .setContsType(file.getContentType())
        //                 .setFileNm(file.getOriginalFilename())
        //                 .setSize(file.getSize());

        //         FileEntity returnFile = fileRepository.save(fileEntity); // 파일들을 모두 저장해준다.
        //         attachmentsList.add(returnFile.getId());
        //     }

        //     noticeEntity.setAttachments(attachmentsList);
        // }else{
        //     noticeEntity.setAttachments(new ArrayList<Long>());
        // }


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

        Optional<NoticeEntity> noticeOp = noticeRepository.findById(id);
        NoticeEntity notice = noticeOp.get();
        NoticeDetailDto noticeDto = new NoticeDetailDto();

        BeanUtils.copyProperties(notice, noticeDto);

        return new Response<NoticeDetailDto>().responseOk(noticeDto);
    }


    //수정
    public Response<Object> updateNotice(NoticeDetailDto noticeDto,  MultipartFile attachments) throws IOException {
    
        //NoticeEntity noticeEntity = new NoticeEntity();
    
        Optional<NoticeEntity> oldOpEntity = noticeRepository.findById(noticeDto.getId());
        NoticeEntity oldEntity = oldOpEntity.get();

        //현재 시각으로 update
        oldEntity.setUpdDt(LocalDateTime.now());

        if(attachments!= null){
            BeanUtils.copyProperties(noticeDto, oldEntity, "attachments");

            Optional<FileEntity> fileLists = fileRepository.findById(oldEntity.getFileId());

            //파일은 지운다.
            fileRepository.delete(fileLists.get());

            fileRepository.getById(null);
            FileEntity fileEntity = new FileEntity();
            fileEntity.setBytes(Base64.getEncoder().encode(attachments.getBytes()))
                    .setContsType(attachments.getContentType())
                    .setFileNm(attachments.getOriginalFilename())
                    .setSize(attachments.getSize());

            //기존 파일은 지워준다.
            fileRepository.delete(fileEntity);

            FileEntity returnFile = fileRepository.save(fileEntity); // 파일들을 모두 저장해준다.

            oldEntity.setFileId(returnFile.getId());
        }else{
            BeanUtils.copyProperties(noticeDto, oldEntity);
        }

        noticeRepository.save(oldEntity);

        return new Response<Object>().responseOk(StatusEnum.SUCCESS);
    }




    //파일 조회
    public Response<FileResDto> getNoticeFile(Long attachments) throws IOException {

        Optional<FileEntity> fileLists = fileRepository.findById(attachments);

        FileResDto fileResDto = new FileResDto();
        BeanUtils.copyProperties(fileLists, fileResDto, "bytes");
        String byteString = new String(fileLists.get().getBytes());
        fileResDto.setBytesString(byteString);
        

        return new Response<FileResDto>().responseOk(fileResDto);

    }
}
