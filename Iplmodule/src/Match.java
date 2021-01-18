public class Match {
    private Integer id;
    private String season;
    private String city;
    private String date;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String result;
    private String dlApplied;
    private String winner;
    private String winByRuns;
    private String winByWickets;
    private String playerOfMatch;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;

    public Match(Integer id, String season, String winner,String playerOfMatch){

        this.id=id;
        this.season=season;
        this.winner=winner;
        this.playerOfMatch=playerOfMatch;
    }

    public Integer getId() {
        return id;
    }

    public String getSeason() {
        return season;
    }

    public String getWinner() {
        return winner;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }
}
