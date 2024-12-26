package io.hhplus.lecture.infra.lectureSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import io.hhplus.lecture.domain.lectureSchedule.entity.LectureSchedule;
import io.hhplus.lecture.domain.lectureSchedule.repository.LectureScheduleRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.LockModeType;

@Repository
public interface LectureScheduleJpaRepository extends JpaRepository<LectureSchedule, Long>, LectureScheduleRepository {
    
    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT ls FROM LectureSchedule ls WHERE ls.lectureId = :lectureId")
    LectureSchedule findByLectureIdWithLock(@Param("lectureId") Long lectureId);

}
