package meeting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class ProgrammeTest {
    private Programme programme;
    private ProgramSlot[] programSlots;
    private ProgramSlot programSlot1;
    private ProgramSlot programSlot2;

    @Before
    public void setup() {
        programSlots = new ProgramSlot[2];
    }

    @Test
    public void testThatProgrammeReturnsFalseWithCorrectDates() {
        programSlot1 = new ProgramSlot(
                LocalDateTime.of(2017, Month.DECEMBER, 15, 20, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 21, 0, 0),
                null,
                null);
        programSlot2 = new ProgramSlot(
                LocalDateTime.of(2017, Month.DECEMBER, 15, 21, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 22, 0, 0),
                null,
                null);

        programSlots[0] = programSlot1;
        programSlots[1] = programSlot2;

        programme = new Programme(programSlots);

        boolean result = programme.programSlotsOverlap();

        Assert.assertFalse(result);
    }

    @Test
    public void testThatProgrammeReturnsTrueWithDateOverlapBeforeOrAfter() {
        programSlot1 = new ProgramSlot(
                LocalDateTime.of(2017, Month.DECEMBER, 15, 10, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 12, 0, 0),
                null,
                null);
        programSlot2 = new ProgramSlot(
                LocalDateTime.of(2017, Month.DECEMBER, 15, 11, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 13, 0, 0),
                null,
                null);

        programSlots[0] = programSlot1;
        programSlots[1] = programSlot2;

        programme = new Programme(programSlots);

        boolean result = programme.programSlotsOverlap();

        Assert.assertTrue(result);
    }

    @Test
    public void testThatProgrammeReturnsTrueWithDateOverlapEncompassingOrInside() {
        programSlot1 = new ProgramSlot(
                LocalDateTime.of(2017, Month.DECEMBER, 15, 10, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 15, 0, 0),
                null,
                null);
        programSlot2 = new ProgramSlot(
                LocalDateTime.of(2017, Month.DECEMBER, 15, 11, 0, 0),
                LocalDateTime.of(2017, Month.DECEMBER, 15, 14, 0, 0),
                null,
                null);

        programSlots[0] = programSlot1;
        programSlots[1] = programSlot2;

        programme = new Programme(programSlots);

        boolean result = programme.programSlotsOverlap();

        Assert.assertTrue(result);
    }
}
