package io.hhplus.lecture.interfaces.api.lecture;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hhplus.lecture.application.lecture.service.LectureService;
import io.hhplus.lecture.interfaces.api.lecture.dto.LectureResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    /**
     * 특강 신청 가능 목록을 조회 합니다.
     */
    @GetMapping("/{startTime}")
    public ResponseEntity<List<LectureResponse>> availableList (
            @PathVariable(name = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate) 
    {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        return ResponseEntity.ok().body(lectureService.availableList(startDateTime));
    }
}
