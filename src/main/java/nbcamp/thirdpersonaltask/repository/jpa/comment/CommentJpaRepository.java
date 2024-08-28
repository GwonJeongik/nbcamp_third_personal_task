package nbcamp.thirdpersonaltask.repository.jpa.comment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nbcamp.thirdpersonaltask.domain.Comment;
import nbcamp.thirdpersonaltask.domain.Schedule;
import nbcamp.thirdpersonaltask.repository.jpa.schedule.ScheduleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CommentJpaRepository implements CommentRepository {

    private final EntityManager em;
    private final ScheduleJpaRepository scheduleRepository;

    @Override
    public Comment save(Comment comment) {
        Schedule schedule = scheduleRepository.findById(comment.getSchedule().getId()).get();

        comment.setSchedule(schedule);
        em.persist(comment);
        return comment;
    }

    @Override
    public void update(Long id, UpdateCommentDto updateParam) {
        Comment comment = em.find(Comment.class, id);

        comment.setContent(updateParam.getContent());
        comment.setAuthor(updateParam.getAuthor());
    }

    @Override
    public Optional<Comment> findById(Long id) {
        Comment comment = em.find(Comment.class, id);
        return Optional.ofNullable(comment);
    }

    @Override
    public List<Comment> findAll() {
        String jpql = "select c from Comment c";

        TypedQuery<Comment> query = em.createQuery(jpql, Comment.class);
        return query.getResultList();
    }

    @Override
    public void delete(Long id) {
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
    }
}
