package midTerm;

public class Graphic {

	public static void printGraphic(int misses) {
		
		switch (misses) {
		case 0:
			System.out.println("   ____");
			System.out.println("  |    |");
			System.out.println("  |    ");
			System.out.println("  |   ");
			System.out.println("  |     ");
			System.out.println("  |    ");
			System.out.println(" _|_");
			System.out.println("|   |______");
			System.out.println("|          |");
			System.out.println("|__________|");
		break;
		case 1:
			System.out.println("   ____");
			System.out.println("  |    |");
			System.out.println("  |    o");
			System.out.println("  |   ");
			System.out.println("  |     ");
			System.out.println("  |    ");
			System.out.println(" _|_");
			System.out.println("|   |______");
			System.out.println("|          |");
			System.out.println("|__________|");
		break;
		case 2:
			System.out.println("   ____");
			System.out.println("  |    |");
			System.out.println("  |    o");
			System.out.println("  |   /");
			System.out.println("  |     ");
			System.out.println("  |    ");
			System.out.println(" _|_");
			System.out.println("|   |______");
			System.out.println("|          |");
			System.out.println("|__________|");
		break;
		case 3:
			System.out.println("   ____");
			System.out.println("  |    |");
			System.out.println("  |    o");
			System.out.println("  |   / \\");
			System.out.println("  |     ");
			System.out.println("  |    ");
			System.out.println(" _|_");
			System.out.println("|   |______");
			System.out.println("|          |");
			System.out.println("|__________|");
		break;
		case 4:
			System.out.println("   ____");
			System.out.println("  |    |");
			System.out.println("  |    o");
			System.out.println("  |   /|\\");
			System.out.println("  |    |");
			System.out.println("  |    ");
			System.out.println(" _|_");
			System.out.println("|   |______");
			System.out.println("|          |");
			System.out.println("|__________|");
		break;
		case 5:
			System.out.println("   ____");
			System.out.println("  |    |");
			System.out.println("  |    o");
			System.out.println("  |   /|\\");
			System.out.println("  |    |");
			System.out.println("  |   /");
			System.out.println(" _|_");
			System.out.println("|   |______");
			System.out.println("|          |");
			System.out.println("|__________|");
		break;
		case 6:
			System.out.println("   ____");
			System.out.println("  |    |");
			System.out.println("  |    o");
			System.out.println("  |   /|\\");
			System.out.println("  |    |");
			System.out.println("  |   / \\");
			System.out.println(" _|_");
			System.out.println("|   |______");
			System.out.println("|          |");
			System.out.println("|__________|");
		break;
		}
	}
		public static void printGraphic2(int cumulativeMisses) {
			// scale "misses" from 0 - 100 to 0 - 6
			int adjustedMisses = (int)(cumulativeMisses/16.66);
			printGraphic(adjustedMisses);
			
//			switch ((int)(cumulativeMisses/16.66)) {
//			case 0:
//				System.out.println("   ____");
//				System.out.println("  |    |");
//				System.out.println("  |    ");
//				System.out.println("  |   ");
//				System.out.println("  |     ");
//				System.out.println("  |    ");
//				System.out.println(" _|_");
//				System.out.println("|   |______");
//				System.out.println("|          |");
//				System.out.println("|__________|");
//			break;
//			case 1:
//				System.out.println("   ____");
//				System.out.println("  |    |");
//				System.out.println("  |    o");
//				System.out.println("  |   ");
//				System.out.println("  |     ");
//				System.out.println("  |    ");
//				System.out.println(" _|_");
//				System.out.println("|   |______");
//				System.out.println("|          |");
//				System.out.println("|__________|");
//			break;
//			case 2:
//				System.out.println("   ____");
//				System.out.println("  |    |");
//				System.out.println("  |    o");
//				System.out.println("  |   /");
//				System.out.println("  |     ");
//				System.out.println("  |    ");
//				System.out.println(" _|_");
//				System.out.println("|   |______");
//				System.out.println("|          |");
//				System.out.println("|__________|");
//			break;
//			case 3:
//				System.out.println("   ____");
//				System.out.println("  |    |");
//				System.out.println("  |    o");
//				System.out.println("  |   / \\");
//				System.out.println("  |     ");
//				System.out.println("  |    ");
//				System.out.println(" _|_");
//				System.out.println("|   |______");
//				System.out.println("|          |");
//				System.out.println("|__________|");
//			break;
//			case 4:
//				System.out.println("   ____");
//				System.out.println("  |    |");
//				System.out.println("  |    o");
//				System.out.println("  |   /|\\");
//				System.out.println("  |    |");
//				System.out.println("  |    ");
//				System.out.println(" _|_");
//				System.out.println("|   |______");
//				System.out.println("|          |");
//				System.out.println("|__________|");
//			break;
//			case 5:
//				System.out.println("   ____");
//				System.out.println("  |    |");
//				System.out.println("  |    o");
//				System.out.println("  |   /|\\");
//				System.out.println("  |    |");
//				System.out.println("  |   /");
//				System.out.println(" _|_");
//				System.out.println("|   |______");
//				System.out.println("|          |");
//				System.out.println("|__________|");
//			break;
//			case 6:
//				System.out.println("   ____");
//				System.out.println("  |    |");
//				System.out.println("  |    o");
//				System.out.println("  |   /|\\");
//				System.out.println("  |    |");
//				System.out.println("  |   / \\");
//				System.out.println(" _|_");
//				System.out.println("|   |______");
//				System.out.println("|          |");
//				System.out.println("|__________|");
//			break;
//			}
			
		}
			
		 
	

	public static void printCelebrationGraphic() {
		
		System.out.println("  ____");
		System.out.println("  |          \\  O  /");
		System.out.println("  |           \\ | / ");
		System.out.println(" _|_            |    ");
		System.out.println("|   |______     |    ");
		System.out.println("|          |   / \\");
		System.out.println("|__________|  /   \\");
		
	}
	
}
