package nbcamp.thirdpersonaltask.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Data
@Entity
@Table(name = "test_schedule")
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String taskTitle;

    @NotBlank
    private String task;
    private String saveDate;
    private String updateDate;

    public Schedule(String name, String taskTitle, String task) {
        this.name = name;
        this.taskTitle = taskTitle;
        this.task = task;
    }

    @PrePersist
    public void prePersist() {
        String currentDateTime = getCurrentDateTime();
        this.saveDate = currentDateTime;
        this.updateDate = currentDateTime;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDate = getCurrentDateTime();
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
