package io.hhplus.lecture.domain.lectureEnrollment.repository;

import java.util.List;
import io.hhplus.lecture.domain.lectureEnrollment.entity.LectureEnrollment;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.UserEnrollResponse;

public interface LectureEnrollmentRepository {

    LectureEnrollment save (LectureEnrollment lectureEnrollment);

    List<UserEnrollResponse> findEnrollByUserId (long userId);
} 
