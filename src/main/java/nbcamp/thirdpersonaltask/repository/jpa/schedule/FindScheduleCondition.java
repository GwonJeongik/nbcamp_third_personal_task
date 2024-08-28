package nbcamp.thirdpersonaltask.repository.jpa.schedule;

import lombok.Data;

@Data
public class FindScheduleCondition {

    private String name;
    private String taskTitle;
    private String task;
    private String updateDate;

    public FindScheduleCondition(String name, String task, String updateDate) {
        this.name = name;
        this.task = task;
        this.updateDate = updateDate;
    }
}
