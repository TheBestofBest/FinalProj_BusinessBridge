package com.app.businessBridge.domain.education.dto;


import com.app.businessBridge.domain.education.entity.Education;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class EducationDto {

    private Long id;

//    private String authorName;

    private String category;

    private String title;

    private String content;

    private Long hit;

    private String filePath;

//    private Long mettingRoomId;

    public EducationDto(Education education) {
        this.id = education.getId();
//        this.authorName = education.author.getName();
        this.category = education.getCategory();
        this.title = education.getTitle();
        this.content = education.getContent();
        this.hit = education.getHit();
        this.filePath = education.getFilePath();
//        this.mettingRoomId = education.getMettingRoom().getId();
    }

}