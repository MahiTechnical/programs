package com.test;

import java.util.Arrays;

public class RankTeams {

    /**
     * Every votes[i] will have same set of characters and same length;
     * So totalRanks = votes[0].length() and allCandidates = votes[0].toCharArray()
     * Our intention is to sort allCandidates by their votes to each rank
     * We build a rank matrix, where row signifies the rank and column signifies the team (A, B, C)
     * Iterate the input to fill ranking[i][j], which is the number of votes for team j to be i-th rank
     * Use this ranking matrix to sort allCandidates
     *
     *
     *
     * 1 <= votes.length <= 1000
     * 1 <= votes[i].length <= 26
     * votes[i].length == votes[j].length for 0 <= i, j < votes.length.
     * votes[i][j] is an English uppercase letter.
     * All characters of votes[i] are unique.
     * All the characters that occur in votes[0] also occur in votes[j] where 1 <= j < votes.length.
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        RankTeams rankTeams = new RankTeams();
        String[] votes = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println(rankTeams.rankTeams(votes));
    }

    public String rankTeams(String[] votes) {
        int totalRanks = votes[0].length();

        //we define an array, every row denote a candidate, every column denotes a position.
        //we add an extra column to identify which candidate the row is
        int[][] ranking = new int[26][totalRanks + 1];

        //we record the number of votes in every position for each candidate by using for-loop

        for (int i = 0; i < 26; i++)
            ranking[i][totalRanks] = i;

        for (String v : votes) {
            for (int i = 0; i < v.length(); i++) {
                ranking[v.charAt(i) - 'A'][i]++;
            }
        }
        Arrays.sort(ranking, (a, b) -> {
            for (int i = 0; i < totalRanks; i++) {
                if (a[i] < b[i]) return 1;
                if (a[i] > b[i]) return -1;
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalRanks; i++) {
            sb.append((char) ('A' + ranking[i][totalRanks]));
        }
        return sb.toString();
    }
}
