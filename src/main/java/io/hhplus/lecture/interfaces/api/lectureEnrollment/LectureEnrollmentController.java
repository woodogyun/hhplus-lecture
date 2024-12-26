package io.hhplus.lecture.interfaces.api.lectureEnrollment;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.hhplus.lecture.application.lectureEnrollment.service.LectureEnrollmentService;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.LectureEnrollmentRequest;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.LectureEnrollmentResponse;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.UserEnrollResponse;
import lombok.RequiredArgsConstructor;


@RestController()
@RequestMapping("/lecture-enroll") 
@RequiredArgsConstructor
public class LectureEnrollmentController {

    private final LectureEnrollmentService lectureEnrollmentService;

    
    /**
     * 유저가 특강 완료된 특강 목록을 조회 합니다.
     */
    @GetMapping("user/{userId}")
    public ResponseEntity<List<UserEnrollResponse>> getEnrollByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok().body(lectureEnrollmentService.getEnrollByUserId(userId));
    }

    /**
     * 사용자가 특강에 예약을 합니다.
     */
    @PostMapping()
    public ResponseEntity<LectureEnrollmentResponse> addEnrollment(LectureEnrollmentRequest dto) {
        return ResponseEntity.ok().body(lectureEnrollmentService.addEnrollment(dto.userId(), dto.lectureId()));
    }

}
