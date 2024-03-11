package spring.model.enam;

public enum Status {
    UNSCHEDULED,	//Default status when you create a task.
    SCHEDULED,	//Changes to Scheduled after you assign the task.
    ON_TRACK,	//Changes to On Track after the task is started.
    OFF_TRACK,	//Changes to Off Track if the associated task is not on track.
    IN_JEOPARDY,	//Changes to In Jeopardy if the task is not completed within the scheduled time.
    COMPLETE,	//Changes to Complete after you mark the task as complete.
    CLOSED	//Changes to Close after you close the associated project or the program.
}
