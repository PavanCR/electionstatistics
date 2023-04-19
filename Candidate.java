package election.electionStatistics.controller;

public class Candidate {
    private String name;
    private int voteCount;

    public Candidate(String name, int voteCount) {
        this.name = name;
        this.voteCount = voteCount;
    }

    public String getName() {
        return name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void incrementVoteCount() {
        this.voteCount++;
    }
}

