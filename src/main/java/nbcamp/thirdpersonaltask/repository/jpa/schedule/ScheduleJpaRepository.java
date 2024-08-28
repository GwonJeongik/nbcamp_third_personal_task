package nbcamp.thirdpersonaltask.repository.jpa.schedule;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nbcamp.thirdpersonaltask.domain.Schedule;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ScheduleJpaRepository implements ScheduleRepository {

    private final EntityManager em;

    @Override
    public Schedule save(Schedule schedule) {
        em.persist(schedule);
        return schedule;
    }

    @Override
    public void update(Long id, UpdateScheduleDto updateParam) {
        Schedule schedule = em.find(Schedule.class, id);

        schedule.setName(updateParam.getName());
        schedule.setTaskTitle(updateParam.getTaskTitle());
        schedule.setTask(updateParam.getTask());
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        Schedule schedule = em.find(Schedule.class, id);
        return Optional.ofNullable(schedule);
    }

    @Override
    public List<Schedule> findAll(FindScheduleCondition condition) {
        String jpql = "select s from Schedule s";

        TypedQuery<Schedule> query = dynamicQuery(condition, jpql);

        return query.getResultList();
    }

    @Override
    public void delete(Long id) {
        Schedule schedule = em.find(Schedule.class, id);
        em.remove(schedule);
    }


    /**
     * findAll 조건에 맞는 동적 SQL문
     * @param condition
     * @param jpql
     * @return TypedQuery<Schedule> query
     */
    private TypedQuery<Schedule> dynamicQuery(FindScheduleCondition condition, String jpql) {
        String name = condition.getName();
        String task = condition.getTask();
        String updateDate = condition.getUpdateDate();

        if (StringUtils.hasText(name) || StringUtils.hasText(task) || StringUtils.hasText(updateDate)) {
            jpql += " where";
        }

        boolean andFlag = false;

        if (StringUtils.hasText(name)) {
            jpql += " s.name like concat('%', :name, '%')";
            andFlag = true;
        }

        if (StringUtils.hasText(task)) {

            if (andFlag) {
                jpql += " and";
            }
            jpql += " s.task like concat('%', :task, '%')";
            andFlag = true;
        }

        if (StringUtils.hasText(updateDate)) {

            if (andFlag) {
                jpql += " and";
            }

            jpql += " s.updateDate like concat('%', :updateDate, '%')";
        }

        log.info("jpql={}", jpql);
        TypedQuery<Schedule> query = em.createQuery(jpql, Schedule.class);

        if (StringUtils.hasText(name)) {
            query.setParameter("name", name);
        }

        if (StringUtils.hasText(task)) {
            query.setParameter("task", task);
        }

        if (StringUtils.hasText(updateDate)) {
            query.setParameter("updateDate", updateDate);
        }

        return query;
    }
}
