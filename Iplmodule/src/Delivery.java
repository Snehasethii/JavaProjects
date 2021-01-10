public class Delivery {
    private Integer match_id;
    private String inning;
    private String batting_team;
    private String bowling_team;
    private Integer over;
    private Integer ball;
    private String batsman;
    private String non_striker;
    private String bowler;
    private String is_super_over;
    private String wide_runs;
    private String bye_runs;
    private String noball_runs;
    private String penalty_runs;
    private String batsman_runs;
    private Integer extra_runs;
    private Integer total_runs;
    private String player_dismissed;
    private String dismissal_kind;
    private String fielder;


    public Delivery(int match_id,String batting_team,int ball,String bowler,int extra_runs,int total_runs){

        this.match_id = match_id;
        this.batting_team = batting_team;
        this.ball = ball;
        this.bowler = bowler;
        this.extra_runs = extra_runs;
        this.total_runs = total_runs;
    }

    public Integer getMatch_id() {
        return match_id;
    }

    public String getBatting_team() {
        return batting_team;
    }

    public Integer getBall() {
        return ball;
    }

    public String getBowler() {
        return bowler;
    }

    public Integer getExtra_runs() {
        return extra_runs;
    }

    public Integer getTotal_runs() {
        return total_runs;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
    }

    public void setBatting_team(String batting_team) {
        this.batting_team = batting_team;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public void setExtra_runs(Integer extra_runs) {
        this.extra_runs = extra_runs;
    }

    public void setTotal_runs(Integer total_runs) {
        this.total_runs = total_runs;
    }
}

