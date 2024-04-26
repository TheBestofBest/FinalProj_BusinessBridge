package com.app.businessBridge.domain.confirm.entity;


import com.app.businessBridge.domain.confirmFormType.entity.ConfirmFormType;
import com.app.businessBridge.domain.confirmStatus.entity.ConfirmStatus;
import com.app.businessBridge.global.Jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Confirm extends BaseEntity {
    // 결재 제목
    @Column(length = 255)
    private String subject;
    // 결재 간략설명
    @Column(columnDefinition = "TEXT")
    private String description;
    // 결재 상세내용
    @Column(columnDefinition = "TEXT")
    private String content;
    // 결재 양식 타입(휴가승인서, 보고서 등)
    @ManyToOne
    private ConfirmFormType formType;
    // 결재 처리 상태(진행중, 승인, 반려 등)
    @ManyToOne
    private ConfirmStatus confirmStatus;

    // ! Member 엔티티 추가 시 주석 해제 하기
//    // 결재 요청자
//    @ManyToOne
//    private Member confirmRequestMember;
//    // 결재 승인자
//    @OneToMany
//    private List<Member> confirmMembers;
}