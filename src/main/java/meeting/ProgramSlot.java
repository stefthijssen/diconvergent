package meeting;

import java.time.LocalDateTime;

public class ProgramSlot {
    private LocalDateTime start;
    private LocalDateTime end;
    private String title;
    private String room;

    public ProgramSlot(LocalDateTime start, LocalDateTime end, String title, String room)
    {
        this.start = start;
        this.end = end;
        this.title = title;
        this.room = room;
    }
}