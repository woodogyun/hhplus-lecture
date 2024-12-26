package io.hhplus.lecture.application.lectureEnrollment.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.hhplus.lecture.domain.lectureEnrollment.entity.LectureEnrollment;
import io.hhplus.lecture.domain.lectureEnrollment.repository.LectureEnrollmentRepository;
import io.hhplus.lecture.domain.lectureSchedule.entity.LectureSchedule;
import io.hhplus.lecture.domain.lectureSchedule.repository.LectureScheduleRepository;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.LectureEnrollmentResponse;
import io.hhplus.lecture.interfaces.api.lectureEnrollment.dto.UserEnrollResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureEnrollmentService {

    private final LectureScheduleRepository scheduleRepository;
    private final LectureEnrollmentRepository enrollmentRepository;

    @Transactional
    public LectureEnrollmentResponse addEnrollment(Long userId, Long lectureId) {
        // 1. 강의 스케줄 조회
        LectureSchedule lectureSchedule = scheduleRepository.findByLectureIdWithLock(lectureId);
        log.info("lectureId: {}", lectureId);

        // 2. max_count가 30 이상인지 확인
        if (lectureSchedule.getCurrentCount() >= 30) {
            throw new IllegalStateException("강의 최대 인원 수를 초과했습니다.");
        }

        // 3. 현재 수강생 수 더하기
        lectureSchedule.increaseCurrentCount();

        LectureEnrollment lectureEnrollment  = LectureEnrollment.builder()
                            .lectureId(lectureId)
                            .userId(userId)
                            .build();

        // 4. 유저가 신청 강의 저장
        enrollmentRepository.save(lectureEnrollment);

        // TODO - user.id, lecture.id  -> user.name 과 lecture.name 으로 변경 필요
        return new LectureEnrollmentResponse(userId, lectureId);
    }

    public List<UserEnrollResponse> getEnrollByUserId(Long userId) {
        return enrollmentRepository.findEnrollByUserId(userId);
    }
}
