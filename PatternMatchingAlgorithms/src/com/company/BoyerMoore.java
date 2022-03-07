package com.company;

public class BoyerMoore {
    private static final int ASCII_NUM = 128;

    public Result searchBM(String pattern, String text) throws IllegalArgumentException {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Pattern can not be null or empty.");
        }
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Text can not be null or empty.");
        }
        if (text.length() < pattern.length()) {
            throw new IllegalArgumentException("Text can not be shorter than pattern.");
        }

        Result result = new Result();
        int[] last = badCharHeuristic(pattern);

        int i = 0;
        while (i <= text.length() - pattern.length()) {
            int j = pattern.length() - 1;
            while (j >= 0 && text.charAt(i + j) == pattern.charAt(j)) {
                j--;
            }
            if (j == -1) {
                result.found = true;
                result.indices.add(i);
                result.occurrences += 1;
                i++;
            } else {
                int shift = findLast(last, text.charAt(i+j));
                if (shift < j) {
                    i = i + (j - shift);
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    private int[] badCharHeuristic(String pattern) {
        int last[] = new int[ASCII_NUM];
        int length = pattern.length();
        for (int i = 0; i < ASCII_NUM; i++) {
            last[i] = -1;
        }

        for (int i = 0; i < length; i++) {
            last[pattern.charAt(i)] = i;
        }
        return last;
    }

    private int findLast(int[] last, char aChar) {
        return last[aChar];
    }
}
