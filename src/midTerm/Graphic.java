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
			
			switch (cumulativeMisses) {
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
			case 20:
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
			case 40:
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
			case 60:
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
			case 80:
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
			case 90:
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
			case 100:
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
