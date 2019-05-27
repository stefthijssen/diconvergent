package meeting;

import meeting.exceptions.MeetingEndBeforeStartException;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class MeetingTest {

    @Test
    public void testThatValidMeetingsCanBeInstantiated() throws MeetingEndBeforeStartException {
        ProgramSlot[] programSlots = new ProgramSlot[2];

        ProgramSlot programSlot1 = new ProgramSlot(
                LocalDateTime.of(2017, Month.DECEMBER, 15, 19, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 20, 0, 0),
            "Divergence",
            "Main room"
        );
        programSlots[0] = programSlot1;

        ProgramSlot programSlot2 = new ProgramSlot(
                LocalDateTime.of(2017, Month.DECEMBER, 15, 20, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 21, 0, 0),
                "Convergence",
                "Main room"
        );
        programSlots[1] = programSlot2;

        Meeting meeting = new Meeting(
            UUID.randomUUID(),
            "(Di|con)vergent mob refactoring",
            "This is a silly workshop, don't come",
                LocalDateTime.of(2017, Month.DECEMBER, 15, 19, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 21, 0, 0),
            new Programme(programSlots)
        );

        assertThat(meeting).isInstanceOf(Meeting.class);
    }

    @Test(expected = MeetingEndBeforeStartException.class)
    public void testThatMeetingThrowsErrorWhenStartAfterEnd() throws MeetingEndBeforeStartException {
        new Meeting(null,
                null,
                null,
                LocalDateTime.of(2017, Month.DECEMBER, 15, 22, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 21, 0, 0),
                null);
    }
}
