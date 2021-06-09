package restassured_bdd.regresAPI;

import java.util.Scanner;

public class Virus {

	public static void main(String arg[]) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String virus = scanner.next().toLowerCase().trim();
		int numberOfPeople = scanner.nextInt();
		if (numberOfPeople < 11) {
			String[] BComposition = new String[numberOfPeople];
			for (int i = 0; i < numberOfPeople; i++) {
				BComposition[i] = scanner.next().toLowerCase().trim();
			}
			virusTest(virus, BComposition);
		}
		scanner.close();
	}

	public static void virusTest(String virus, String[] bComposition) {

		int b = bComposition.length;
		for (int l = 0; l < b; l++) {
			int checkComp = 0;
			int k = 0;
			String bComp = bComposition[l];
			if (virus.length() >= bComp.length()) {
				for (int i = 0; i < bComp.length(); i++) {
					for (int j = k; j < virus.length(); j++) {
						if (bComp.charAt(i) == virus.charAt(j)) {
							checkComp = checkComp + 1;
							break;
						}
						k = j;

					}
				}
				if (checkComp == bComp.length()) {
					System.out.println("POSITIVE");
				} else {
					System.out.println("NEGATIVE");
				}
			}
		}
	}

}
