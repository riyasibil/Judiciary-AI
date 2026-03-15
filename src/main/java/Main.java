import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("   NYAY AI — Legal System     ");
        System.out.println("==============================");
        System.out.println();
        System.out.println("Select case type:");
        System.out.println("1 — Speeding");
        System.out.println("2 — No Helmet");
        System.out.print("Enter number: ");

        String choice = scanner.nextLine();
        CaseInput caseInput;

        if (choice.equals("1")) {

            System.out.print("Speed recorded (km/h): ");
            int speedRecorded = Integer.parseInt(
                scanner.nextLine());

            System.out.print("Speed limit in zone (km/h): ");
            int speedLimit = Integer.parseInt(
                scanner.nextLine());

            System.out.print("Repeat offence? (yes/no): ");
            boolean isRepeat = scanner.nextLine()
                                      .equals("yes");

            caseInput = new CaseInput(
                "SPEEDING",
                speedRecorded,
                speedLimit,
                isRepeat
            );

        } else if (choice.equals("2")) {

            System.out.print("Repeat offence? (yes/no): ");
            boolean isRepeat = scanner.nextLine()
                                      .equals("yes");

            caseInput = new CaseInput("NO_HELMET", isRepeat);

        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        RuleEngine engine   = new RuleEngine();
        VerdictResult verdict = engine.evaluate(caseInput);

        System.out.println();
        System.out.println("==============================");
        System.out.println(verdict.buildOutput());
        System.out.println("==============================");

        scanner.close();
    }
}