package nbcamp.thirdpersonaltask.service;

import nbcamp.thirdpersonaltask.domain.Schedule;
import nbcamp.thirdpersonaltask.repository.jpa.schedule.FindScheduleCondition;
import nbcamp.thirdpersonaltask.repository.jpa.schedule.UpdateScheduleDto;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    Schedule save(Schedule schedule);

    void update(Long id, UpdateScheduleDto updateParam);

    Optional<Schedule> findById(Long id);

    List<Schedule> findAll(FindScheduleCondition condition);

}
