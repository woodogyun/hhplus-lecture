package io.hhplus.lecture.domain.lectureSchedule.repository;

import org.springframework.stereotype.Repository;
import io.hhplus.lecture.domain.lectureSchedule.entity.LectureSchedule;

@Repository
public interface LectureScheduleRepository {
    
    LectureSchedule findByLectureIdWithLock(Long lectureId);

}
