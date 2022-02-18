package com.test;

import java.util.TreeMap;

/****
 Time Complexity: O(N + Q \log N)O(N+QlogN), where NN is the number of votes, and QQ is the number of queries.

 Space Complexity: O(N)O(N).
***/


public class TopVotedCandidate {

    int[] winners;
    int[] times;
    TreeMap<Integer, Integer> timeToWinner = new TreeMap<>();

    public static void main(String[] args) {
        int[] persons = new int[]{0, 1, 1, 0, 0, 1, 0};
        int[] times = new int[] {0, 5, 10, 15, 20, 25, 30};

        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons,times);
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(14));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));
         }


    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.winners = new int[persons.length];
        int[] votes = new int[persons.length];
        int lead = 0;
        for (int i = 0; i < persons.length; i++) {
            votes[persons[i]]++;
            if (votes[persons[i]] >= votes[lead]) {
                lead = persons[i];
            }
            timeToWinner.put(times[i], lead);
        }
    }

    public int q(int t) {
        return timeToWinner.floorEntry(t).getValue();
    }
}
