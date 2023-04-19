package election.electionStatistics.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {
    private CandidatesManager candidatesManager = new CandidatesManager();

    @PostMapping("/entercandidate")
    public ResponseEntity<String> enterCandidate(@RequestParam String name) {
        if (candidatesManager.addCandidate(name)) {
            return ResponseEntity.ok("Candidate " + name + " added successfully");
        }
        return ResponseEntity.badRequest().body("Candidate " + name + " already exists");
    }

    @PostMapping("/castvote")
    public ResponseEntity<String> castVote(@RequestParam String name) {
        if (candidatesManager.incrementVote(name)) {
            return ResponseEntity.ok("Vote casted for " + name);
        }
        return ResponseEntity.badRequest().body("Invalid candidate name " + name);
    }

    @GetMapping("/countvote")
    public ResponseEntity<String> getVoteCount(@RequestParam String name) {
        int voteCount = candidatesManager.getVoteCount(name);
        if (voteCount != -1) {
            return ResponseEntity.ok(name + " has " + voteCount + " votes");
        }
        return ResponseEntity.badRequest().body("Invalid candidate name " + name);
    }

    @GetMapping("/listvote")
    public ResponseEntity<List<Candidate>> getCandidates() {
        return ResponseEntity.ok(candidatesManager.getCandidates());
    }

    @GetMapping("/getwinner")
    public ResponseEntity<String> getWinner() {
        return ResponseEntity.ok(candidatesManager.getWinner());
    }
}

