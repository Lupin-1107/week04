package Day2_Collections.VotingSystem;

import java.util.*;

class VotingSystem {
    private HashMap<String, Integer> votes; // Store votes for each candidate
    private LinkedHashMap<String, Integer> votingOrder; // Maintain the order of votes
    private TreeMap<String, Integer> sortedResults; // Display results in sorted order

    public VotingSystem() {
        votes = new HashMap<>();
        votingOrder = new LinkedHashMap<>();
        sortedResults = new TreeMap<>(
                (c1, c2) -> {
                    int voteComparison = votes.get(c2).compareTo(votes.get(c1)); // Sort in descending order
                    return (voteComparison != 0) ? voteComparison : c1.compareTo(c2);
                }
        );
    }

    // Cast a vote
    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        votingOrder.put(candidate, votes.get(candidate));
        sortedResults.clear();
        sortedResults.putAll(votes);
    }

    // Display votes in order of voting
    public void displayVotingOrder() {
        System.out.println("Voting Order:");
        for (Map.Entry<String, Integer> entry : votingOrder.entrySet()) {
            System.out.println(entry.getKey() + " - Votes: " + entry.getValue());
        }
    }

    // Display sorted results
    public void displayResults() {
        System.out.println("Election Results (Sorted by Votes):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " - Votes: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem election = new VotingSystem();

        election.castVote("Alice");
        election.castVote("Charlie");
        election.castVote("Bob");
        election.castVote("Alice");
        election.castVote("Bob");
        election.castVote("Alice");

        election.displayVotingOrder();
        election.displayResults();
    }
}
