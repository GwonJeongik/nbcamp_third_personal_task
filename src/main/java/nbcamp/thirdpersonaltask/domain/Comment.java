package nbcamp.thirdpersonaltask.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 레벨 2 추가사항
 */
@Data
@Entity
@Table(name = "test_comment")
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String content;

    @NotBlank
    private String author;
    private String createDate;
    private String updateDate;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(String content, String author, Schedule schedule) {
        this.content = content;
        this.author = author;
        this.schedule = schedule;
    }

    @PrePersist
    public void prePersist() {
        String currentDateTime = getCurrentDateTime();
        this.createDate = currentDateTime;
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
