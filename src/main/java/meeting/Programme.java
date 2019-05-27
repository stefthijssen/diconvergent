package meeting;

public class Programme {

    private ProgramSlot[] programSlots;

    public Programme(ProgramSlot[] slots)
    {
        this.programSlots = slots;
    }

    public boolean programSlotsOverlap() {
        for (int i = 0; i < programSlots.length; i++) {
            for (int j = 0; j < programSlots.length; j++) {
                if (i != j) {
                    if (programSlots[j].getEnd().isAfter(programSlots[i].getStart())
                            && programSlots[j].getStart().isBefore(programSlots[i].getEnd())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
