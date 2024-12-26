package io.hhplus.lecture.domain.lecture.repository;

import java.time.LocalDateTime;
import java.util.List;
import io.hhplus.lecture.interfaces.api.lecture.dto.LectureResponse;

public interface LectureRepository {
    
    List<LectureResponse> findByAvailableList(LocalDateTime startDateTime);

}
