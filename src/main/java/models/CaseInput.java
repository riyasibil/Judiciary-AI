public class CaseInput {

    int speedRecordedKmh;
    int speedLimitKmh;
    int speedExcessKmh;
    boolean isRepeatOffence;
    String violationType;

    // Constructor for speed-related cases
    public CaseInput(String violationType,
                     int speedRecorded,
                     int speedLimit,
                     boolean repeatOffence) {

        this.violationType    = violationType;
        this.speedRecordedKmh = speedRecorded;
        this.speedLimitKmh    = speedLimit;
        this.speedExcessKmh   = speedRecorded - speedLimit;
        this.isRepeatOffence  = repeatOffence;
    }

    // Constructor for non-speed cases
    public CaseInput(String violationType,
                     boolean repeatOffence) {

        this.violationType    = violationType;
        this.isRepeatOffence  = repeatOffence;
        this.speedRecordedKmh = 0;
        this.speedLimitKmh    = 0;
        this.speedExcessKmh   = 0;
    }
}