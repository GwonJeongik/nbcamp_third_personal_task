package nbcamp.thirdpersonaltask.repository.jpa.comment;

import lombok.extern.slf4j.Slf4j;
import nbcamp.thirdpersonaltask.domain.Comment;
import nbcamp.thirdpersonaltask.domain.Schedule;
import nbcamp.thirdpersonaltask.repository.jpa.schedule.ScheduleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@Commit
@SpringBootTest
class CommentJpaRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    private Schedule schedule;

    @BeforeEach
    void init() {
        Schedule saveSchedule = new Schedule("이름", "할 일", "밥먹기");
        schedule = scheduleRepository.save(saveSchedule);

        log.info("테스트 시작 전 스케쥴 등록 schedule={}", schedule);
    }

    @Test
    void save() {
        //given
        Comment comment = new Comment("잘 먹었습니다!", "맹구", schedule);

        //when
        Comment saveComment = commentRepository.save(comment);

        //then
        Comment findComment = commentRepository.findById(comment.getId()).get();

        assertThat(saveComment).isEqualTo(findComment);
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }
}