package nbcamp.thirdpersonaltask.repository.jpa.schedule;

import nbcamp.thirdpersonaltask.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    Schedule save(Schedule schedule);

    void update(Long id, UpdateScheduleDto updateParam);

    Optional<Schedule> findById(Long id);

    List<Schedule> findAll(FindScheduleCondition condition);

    void delete(Long id);
}
