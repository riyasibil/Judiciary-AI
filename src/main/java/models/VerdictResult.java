public class VerdictResult {

    String status;
    String legalSection;
    String actName;
    int fineMinimum;
    int fineMaximum;
    int fineRecommended;
    boolean requiresEscalation;
    String escalationReason;
    String reasoning;

    // Constructor for normal resolved cases
    public VerdictResult(String section,
                         String act,
                         int fineMin,
                         int fineMax) {

        this.status             = "VALID";
        this.legalSection       = section;
        this.actName            = act;
        this.fineMinimum        = fineMin;
        this.fineMaximum        = fineMax;
        this.fineRecommended    = (fineMin + fineMax) / 2;
        this.requiresEscalation = false;
    }

    // Constructor for invalid or escalated cases
    public VerdictResult(String status, String reason) {
        this.status             = status;
        this.requiresEscalation = status.equals("ESCALATE");
        this.escalationReason   = reason;
        this.fineRecommended    = 0;
    }

    public String buildOutput() {

        if (this.status.equals("INVALID")) {
            return "INVALID CASE\n"
                 + "Reason: " + this.escalationReason + "\n"
                 + "Please fix this before filing.";
        }

        if (this.requiresEscalation) {
            return "ESCALATED TO HUMAN OFFICER\n"
                 + "Reason: " + this.escalationReason;
        }

        return "RECOMMENDATION\n"
             + "Under " + this.legalSection
             + " of the " + this.actName + "\n"
             + "Fine range:   Rs." + this.fineMinimum
             + " to Rs." + this.fineMaximum + "\n"
             + "Recommended:  Rs." + this.fineRecommended + "\n"
             + "Reasoning:    " + this.reasoning;
    }
}
