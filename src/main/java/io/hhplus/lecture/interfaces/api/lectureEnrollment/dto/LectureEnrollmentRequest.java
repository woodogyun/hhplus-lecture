package io.hhplus.lecture.interfaces.api.lectureEnrollment.dto;

public record LectureEnrollmentRequest(
    Long userId,
    Long lectureId
) {
    
}
