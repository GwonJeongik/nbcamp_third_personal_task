package nbcamp.thirdpersonaltask.repository.jpa.schedule;

import lombok.extern.slf4j.Slf4j;
import nbcamp.thirdpersonaltask.domain.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Transactional
@SpringBootTest
class ScheduleJpaRepositoryTest {

    @Autowired
    ScheduleJpaRepository repository;

    @Test
    void save() {
        //given
        Schedule schedule = new Schedule("이름", "1234", "밥먹기");

        //when
        Schedule saveSchedule = repository.save(schedule);

        //then
        Schedule findSchedule = repository.findById(saveSchedule.getId()).get();

        assertThat(saveSchedule).isEqualTo(findSchedule);
    }

    @Test
    void update() {
        //given
        Schedule schedule = new Schedule("이름", "할일 1", "밥먹기");
        UpdateScheduleDto updateParam = new UpdateScheduleDto("이름 변경", "할일 2", "똥싸기");

        repository.save(schedule);

        //when
        repository.update(schedule.getId(), updateParam);

        //then
        Schedule findSchedule = repository.findById(schedule.getId()).get();

        assertThat(findSchedule.getName()).isEqualTo(schedule.getName());
        assertThat(findSchedule.getTaskTitle()).isEqualTo(schedule.getTaskTitle());
        assertThat(findSchedule.getTask()).isEqualTo(schedule.getTask());
    }

    @Test
    void findAll() {
        /*//given
        FindScheduleCondition condition = new FindScheduleCondition("이름3", "할 일", "일하기");
        String name = condition.getName();
        String taskTitle = condition.getTaskTitle();
        String task = condition.getTask();
        String

        Schedule schedule1 = new Schedule("이름1", "할 일1", "목욕하기1");
        Schedule schedule2 = new Schedule("이름2", "할 일2", "목욕하기2");

        repository.save(schedule1);
        repository.save(schedule2);

        //when
        List<Schedule> findAll1 = repository.findAll(condition);

        //then*/
    }

    @Test
    void delete() {
        //given

        //when

        //then
    }
}