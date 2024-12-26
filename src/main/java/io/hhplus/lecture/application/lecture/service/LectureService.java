package io.hhplus.lecture.application.lecture.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import io.hhplus.lecture.domain.lecture.repository.LectureRepository;
import io.hhplus.lecture.interfaces.api.lecture.dto.LectureResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public List<LectureResponse> availableList(LocalDateTime startDateTime) {
        return lectureRepository.findByAvailableList(startDateTime);
    }
    
}
