package io.hhplus.lecture.interfaces.api.lectureEnrollment.dto;

public record UserEnrollResponse(
    Long lectureId,
    String lectureName,
    Long userId
) {
    
}