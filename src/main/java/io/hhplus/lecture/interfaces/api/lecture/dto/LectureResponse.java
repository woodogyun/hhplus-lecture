package io.hhplus.lecture.interfaces.api.lecture.dto;

import java.time.LocalDateTime;

public record LectureResponse(
    Long lectureId,
    String lectureName,
    Long userId,
    Long scheduleId,
    LocalDateTime startDate,
    LocalDateTime endDate,
    int maxCount,
    int currentCount
) {

}