package io.hhplus.lecture.infra.lectureEnrollment;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import io.hhplus.lecture.domain.lectureEnrollment.entity.LectureEnrollment;
import io.hhplus.lecture.domain.lectureEnrollment.repository.LectureEnrollmentRepository;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.UserEnrollResponse;

public interface LectureEnrollmentJpaRepository extends JpaRepository<LectureEnrollment, Long>, LectureEnrollmentRepository {
    
    @Override
    @Query("SELECT new io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.UserEnrollResponse(l.id, l.name, lm.userId) " +
            "FROM LectureEnrollment lm JOIN Lecture l ON lm.lectureId = l.id " +
            "WHERE lm.userId = :userId")
    List<UserEnrollResponse> findEnrollByUserId (@Param("userId") long userId);
}
