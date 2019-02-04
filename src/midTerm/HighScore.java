package midTerm;

public class HighScore {

	protected String name;
	protected int wins;
	protected int losses;

	public HighScore() {

	}

	public HighScore(String name, int wins, int losses) {
		this.name = name;
		this.wins = wins;
		this.losses = losses;
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

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}
}
