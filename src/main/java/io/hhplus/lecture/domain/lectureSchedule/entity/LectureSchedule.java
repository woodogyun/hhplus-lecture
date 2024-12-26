package io.hhplus.lecture.domain.lectureSchedule.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lecture_schedule")
public class LectureSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lecture_id", nullable = false)
    private Long lectureId;

    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "max_count", nullable = false)
    private int maxCount;

    @Column(name = "current_count", nullable = false)
    private int currentCount;

    public void increaseCurrentCount() {
        this.currentCount++;
    }

}
