package nbcamp.thirdpersonaltask.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nbcamp.thirdpersonaltask.domain.Schedule;
import nbcamp.thirdpersonaltask.repository.jpa.schedule.FindScheduleCondition;
import nbcamp.thirdpersonaltask.repository.jpa.schedule.UpdateScheduleDto;
import nbcamp.thirdpersonaltask.web.controller.ScheduleController;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleController controller;


    @Override
    public Schedule save(Schedule schedule) {
        return null;
    }

    @Override
    public void update(Long id, UpdateScheduleDto updateParam) {

    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Schedule> findAll(FindScheduleCondition condition) {
        return List.of();
    }
}
