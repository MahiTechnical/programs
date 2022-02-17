package com.bank;

public class ArrangeCoins {

    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();

        System.out.println(arrangeCoins.completeRows(8));
    }
///Time Complexity: O(sqrt(n)), Space Complexity: O(sqrt(n)) -> stack space
    private int completeRows(int coinsCount) {
                return calCompleteRows(coinsCount, 1);

    }

    public int calCompleteRows(int n, int row) {
        if(n < row) return row-1;
        return calCompleteRows(n-row, row+1);
    }
}
/****
 *
 *
 *
 *
 * Complexity Analysis
 *
 * Time complexity : \mathcal{O}(\log N)O(logN).
 *
 * Space complexity : \mathcal{O}(1)O(1).
 */