
public class EmpSalaryAdjust {
	public static void main(String[] args) {
		double[] sal = { 25000, 20000, 35000, 12000, 29000 };

		for (int i = 0; i < sal.length; i++) {
			double curSal = sal[i], origSal = curSal;

			if (curSal >= 30000) curSal += curSal * 0.10; // 10% increase
			if (curSal == 20000) curSal += 2000;         // Fixed bonus for 20k
			if (curSal < 15000) 
				System.out.println("Emp " + (i + 1) + ": Improve work for a better salary.");

			double hra = curSal * 0.10, ta = curSal * 0.05, da = curSal * 0.08;

			System.out.printf("Emp %d - Orig Salary: %.2f, Updated: %.2f\n", i + 1, origSal, curSal);
			System.out.printf("HRA: %.2f, TA: %.2f, DA: %.2f\n", hra, ta, da);
			System.out.printf("Total incl. Allowances: %.2f\n\n", (curSal + hra + ta + da));
		}
	}
}
