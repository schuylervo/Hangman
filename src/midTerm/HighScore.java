package midTerm;

public class HighScore {

	protected String name;
	protected int wins;
	protected int losses;
	protected int spelledWordCount;
	
	public HighScore() {

	}

	public HighScore(String name, int wins, int losses) {
		this.name = name;
		this.wins = wins;
		this.losses = losses;
	}

	public HighScore(String name, int spelledWordCount) {
		this.name = name;
		this.spelledWordCount = spelledWordCount;

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}
	
	public int getSpelledWordCount() {
		return spelledWordCount;
	}

	@Override
	public String toString() {
		return "name: " + name + " wins = " + wins + " losses = " + losses +" spelled word count: " + spelledWordCount;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
	public void setSpelledWordCount(int spelledWordCount) {
		this.spelledWordCount = spelledWordCount;
	}
	
	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}
}
