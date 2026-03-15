public class RuleEngine {

    public VerdictResult evaluate(CaseInput caseInput) {

        switch (caseInput.violationType) {

            case "SPEEDING":
                return handleSpeeding(caseInput);

            case "NO_HELMET":
                return handleNoHelmet(caseInput);

            default:
                return new VerdictResult("ESCALATE",
                    "Unknown violation type: "
                    + caseInput.violationType);
        }
    }

    private VerdictResult handleSpeeding(CaseInput input) {

        if (input.speedExcessKmh <= 0) {
            return new VerdictResult("INVALID",
                "Speed recorded is not over the limit.");
        }

        int fineMin;
        int fineMax;

        if (input.isRepeatOffence) {
            fineMin = 2000;
            fineMax = 4000;
        } else {
            fineMin = 1000;
            fineMax = 2000;
        }

        VerdictResult verdict = new VerdictResult(
            "Section 183(1)",
            "Motor Vehicles Act 1988 (amended 2019)",
            fineMin,
            fineMax
        );

        verdict.reasoning = "Vehicle was travelling at "
            + input.speedRecordedKmh + " km/h in a "
            + input.speedLimitKmh + " km/h zone, "
            + input.speedExcessKmh + " km/h over the limit."
            + (input.isRepeatOffence
               ? " Enhanced penalty — repeat offence."
               : "");

        return verdict;
    }

    private VerdictResult handleNoHelmet(CaseInput input) {

        VerdictResult verdict = new VerdictResult(
            "Section 129 read with Section 177",
            "Motor Vehicles Act 1988 (amended 2019)",
            1000,
            1000
        );

        verdict.reasoning =
            "Rider of two-wheeler was not wearing a helmet. "
          + "Fixed penalty of Rs.1000 applies.";

        return verdict;
    }
}
