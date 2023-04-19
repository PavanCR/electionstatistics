package election.electionStatistics.controller;

import java.util.ArrayList;
import java.util.List;

public class CandidatesManager {
    private List<Candidate> candidates = new ArrayList<>();

    public boolean addCandidate(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        for (Candidate candidate : candidates) {
            if (candidate.getName().equals(name)) {
                return false;
            }
        }
        candidates.add(new Candidate(name, 0));
        return true;
    }

    public boolean incrementVote(String name) {
        for (Candidate candidate : candidates) {
            if (candidate.getName().equals(name)) {
                candidate.incrementVoteCount();
                return true;
            }
        }
        return false;
    }

    public int getVoteCount(String name) {
        for (Candidate candidate : candidates) {
            if (candidate.getName().equals(name)) {
                return candidate.getVoteCount();
            }
        }
        return -1;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public String getWinner() {
        int maxVotes = 0;
        String winner = "";
        for (Candidate candidate : candidates) {
            if (candidate.getVoteCount() > maxVotes) {
                maxVotes = candidate.getVoteCount();
                winner = candidate.getName();
            }
        }
        return winner;
    }
}

