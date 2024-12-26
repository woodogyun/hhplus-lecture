package io.hhplus.lecture.infra.lectureEnrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import io.hhplus.lecture.domain.lectureEnrollment.entity.LectureEnrollment;
import io.hhplus.lecture.domain.lectureEnrollment.repository.LectureEnrollmentRepository;

public interface LectureEnrollmentJpaRepository extends JpaRepository<LectureEnrollment, Long>, LectureEnrollmentRepository {
    
}
