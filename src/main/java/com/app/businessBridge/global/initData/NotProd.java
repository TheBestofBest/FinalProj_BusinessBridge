package com.app.businessBridge.global.initData;

import com.app.businessBridge.domain.chattingRoom.service.ChattingRoomService;
import com.app.businessBridge.domain.department.service.DepartmentService;
import com.app.businessBridge.domain.division.service.DivisionService;
import com.app.businessBridge.domain.grade.service.GradeService;
import com.app.businessBridge.domain.member.Service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.nio.file.*;

@Configuration
@Profile({"dev", "test"})
public class NotProd {
    @Bean
    CommandLineRunner initData(DivisionService divisionService, DepartmentService departmentService, GradeService gradeService, MemberService memberService, ChattingRoomService chattingRoomService) {

        return args -> {

            // 소속 생성
            divisionService.create(1,"총괄본부");
            divisionService.create(10,"기술관리");
            divisionService.create(11,"경영지원본부");
            divisionService.create(12,"R&D본부");

            // 부서 생성
            departmentService.create(0,"총괄");
            departmentService.create(1, "관리");
            departmentService.create(101, "마케팅");
            departmentService.create(102, "영업");

            // 직급 생성
            gradeService.create(0,"대표이사");
            gradeService.create(1, "관리자");
            gradeService.create(1001, "부장");
            gradeService.create(1002, "대리");

            // 회원 생성
            memberService.create(1,0,0,"CEO",10000,"왕대표","1234","CEO@emil.com");
            memberService.create(10,1, 1, "admin", 10001, "김관리", "1234", "admin@email.com");
            memberService.create(11,101, 1001, "user1", 20001, "이마부", "1234", "user1@email.com");
            memberService.create(11,102, 1002, "user2", 30001, "박영대", "1234", "user2@email.com");
            memberService.create(12,102, 1002, "user3", 30002, "홍길동", "1234", "user3@email.com");

            // 정산, 통계 테스트용 회원 생성
            for (int i = 4; i < 104; i++) {
                int randomNum = (int) (Math.random() * 100 + 1);
                int randomAge = (int) (Math.random() * 100 + 1);
                if (i % 2 == 0) {
                    memberService.createRebateTest(101, 1002, "user" + i, 20000 + i, "직원" + i, "1234", "user" + i + "@email.com", randomNum * 1000000L, '남', String.valueOf(randomAge));
                }
                memberService.createRebateTest(102, 1001, "user" + i, 20000 + i, "직원" + i, "1234", "user" + i + "@email.com", randomNum * 1000000L, '여', String.valueOf(randomAge));
            }

            chattingRoomService.create("채팅방1", memberService.findByUsername("admin").getData());
            chattingRoomService.create("채팅방2", memberService.findByUsername("admin").getData());
            chattingRoomService.create("채팅방3", memberService.findByUsername("user1").getData());

            chattingRoomService.invite(1L, memberService.findByUsername("user1").getData());
            chattingRoomService.invite(1L, memberService.findByUsername("user2").getData());
            chattingRoomService.invite(2L, memberService.findByUsername("user1").getData());


            // 이미지 저장하는 외부 경로 폴더 생성 로직 필요 시 추가
            Path directoryMail = Paths.get("C:\\B-bridge\\file_upload\\mail");
            Path directoryArticle = Paths.get("C:\\B-bridge\\file_upload\\article");
            Path directoryEducation = Paths.get("C:\\B-bridge\\file_upload\\education");
//            Path directoryQuestion = Paths.get("C:\\B-bridge\\file_upload\\question");
//            Path directoryMember = Paths.get("C:\\B-bridge\\file_upload\\member");

            try {
                Files.createDirectories(directoryMail);
                Files.createDirectories(directoryArticle);
                Files.createDirectories(directoryEducation);
//                Files.createDirectories(directoryQuestion);
//                Files.createDirectories(directoryMember);
            } catch (FileAlreadyExistsException e) {
                System.out.println("디렉토리가 이미 존재합니다");
            } catch (NoSuchFileException e) {
                System.out.println("디렉토리 경로가 존재하지 않습니다");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}