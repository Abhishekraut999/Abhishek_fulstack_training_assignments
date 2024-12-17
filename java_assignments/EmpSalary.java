import java.util.Scanner;

public class EmpSalary {

    static final double PERK_PCT = 0.10, TAX_RATE = 0.15;

    private String name, dept;
    private double bSal, hra, ta, da, perks;

    public EmpSalary(String name, String dept, double bSal) {
        this.name = name;
        this.dept = dept;
        this.bSal = bSal;
        this.hra = calcHRA();
        this.ta = calcTA();
        this.da = calcDA();
        this.perks = calcPerks();
    }

    public double calcHRA() { return 0.20 * bSal; }
    public double calcTA() { return 0.15 * bSal; }
    public double calcDA() { return 0.10 * bSal; }
    public double calcPerks() { return bSal * PERK_PCT; }

    public double calcGross() { return bSal + hra + ta + da + perks; }

    public static double calcTax(double gross) { return gross * TAX_RATE; }

    public double calcNet() { return calcGross() - calcTax(calcGross()); }

    public void showDetails() {
        System.out.println("\n-- Salary Details --");
        System.out.println("Name: " + name + ", Dept: " + dept);
        System.out.printf("Basic: %.2f, HRA: %.2f, TA: %.2f, DA: %.2f, Perks: %.2f\n", bSal, hra, ta, da, perks);
        System.out.printf("Gross: %.2f, Tax: %.2f, Net: %.2f\n", calcGross(), calcTax(calcGross()), calcNet());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee Details:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String dept = sc.nextLine();

        System.out.print("Basic Salary: ");
        double bSal = sc.nextDouble();

        EmpSalary emp = new EmpSalary(name, dept, bSal);

        System.out.println("\nEmployee Salary Info:");
        emp.showDetails();

        sc.close();
    }
}
