package nbcamp.thirdpersonaltask.repository.jpa.schedule;

import lombok.Data;

@Data
public class UpdateScheduleDto {

    private String name;
    private String taskTitle;
    private String task;

    public UpdateScheduleDto(String name, String taskTitle, String task) {
        this.name = name;
        this.taskTitle = taskTitle;
        this.task = task;
    }
}
