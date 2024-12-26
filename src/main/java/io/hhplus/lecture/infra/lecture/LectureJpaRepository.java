package io.hhplus.lecture.infra.lecture;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import io.hhplus.lecture.domain.lecture.entity.Lecture;
import io.hhplus.lecture.domain.lecture.repository.LectureRepository;
import io.hhplus.lecture.interfaces.api.lecture.dto.LectureResponse;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long>, LectureRepository{
    
    @Override
    @Query("SELECT new io.hhplus.lecture.interfaces.api.lecture.dto.LectureResponse(l.id, l.name, l.userId, ls.id, ls.startDate, ls.endDate, ls.maxCount, ls.currentCount) " +
            "FROM Lecture l JOIN LectureSchedule ls ON l.id = ls.lectureId " +
            "WHERE ls.startDate > :startDateTime AND ls.currentCount < 30")
    List<LectureResponse> findByAvailableList(@Param("startDateTime") LocalDateTime startDateTime);

}
