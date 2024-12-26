package io.hhplus.lecture.interfaces.api.lectureEnrollment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.hhplus.lecture.application.lectureEnrollment.service.LectureEnrollmentService;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.LectureEnrollmentRequest;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.LectureEnrollmentResponse;
import lombok.RequiredArgsConstructor;


@RestController()
@RequestMapping("/lecture-enroll") 
@RequiredArgsConstructor
public class LectureEnrollmentController {

    private final LectureEnrollmentService lectureEnrollmentService;

    /**
     * 사용자가 특강에 예약을 합니다.
     */
    @PostMapping()
    public ResponseEntity<LectureEnrollmentResponse> addEnrollment(LectureEnrollmentRequest dto) {
        return ResponseEntity.ok().body(lectureEnrollmentService.addEnrollment(dto.userId(), dto.lectureId()));
    }

}
