public class HighScoreParser {
    private String winner;

    public HighScoreParser(String input) {

        String[] parts = input.split("\\|");
        String teamsPart = parts[0]; // "Home:Visitor"
        String scoresPart = parts[1]; // "21:9"


        String[] teams = teamsPart.split(":");
        String homeTeam = teams[0];
        String visitorTeam = teams[1];

        String[] scores = scoresPart.split(":");
        int homeScore = Integer.parseInt(scores[0]);
        int visitorScore = Integer.parseInt(scores[1]);

        if (homeScore > visitorScore) {
            this.winner = homeTeam;
        } else if (visitorScore > homeScore) {
            this.winner = visitorTeam;
        } else {
            this.winner = "Tie!";
        }
    }

    public void displayWinner() {

        if (winner.equals("Tie!")) {
            System.out.println("Winner: Tie!");
        } else {
            System.out.println("Winner: " + winner);
        }
    }
}