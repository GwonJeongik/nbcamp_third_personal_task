package nbcamp.thirdpersonaltask.repository.jpa.comment;

import nbcamp.thirdpersonaltask.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);

    void update(Long id, UpdateCommentDto updateParam);

    Optional<Comment> findById(Long id);

    List<Comment> findAll();

    void delete(Long id);

}
