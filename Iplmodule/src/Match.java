public class Match {
    private Integer id;
    private String season;
    private String city;
    private String date;
    private String team1;
    private String team2;
    private String toss_winner;
    private String toss_decision;
    private String result;
    private String dl_applied;
    private String winner;
    private String win_by_runs;
    private String win_by_wickets;
    private String player_of_match;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;


    public Match(Integer id, String season, String winner,String player_of_match){

        this.id=id;
        this.season=season;
        this.winner=winner;
        this.player_of_match=player_of_match;
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

    public String getPlayer_of_match() {
        return player_of_match;
    }

    public void setPlayer_of_match(String player_of_match) {
        this.player_of_match = player_of_match;
    }
}
