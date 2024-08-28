package nbcamp.thirdpersonaltask.repository.jpa.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCommentDto {

    @NotBlank
    private String content;

    @NotBlank
    private String author;
}
