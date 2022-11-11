public class RabinKarp {
    private static final int ASCII_NUM = 128;
    private static final int PRIME_NUM = 13;

    public Result searchRK(String pattern, String text) throws IllegalArgumentException {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Pattern can not be null or empty.");
        }
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Text can not be null or empty.");
        }
        if (text.length() < pattern.length()) {
            throw new IllegalArgumentException("Text can not be shorter than pattern.");
        }

        int m = pattern.length();
        int n = text.length();
        long p = 0, t = 0;
        int h = 1;

        Result result = new Result();

        for (int i = 0; i < m - 1; i++) {
            h = (h * ASCII_NUM) % PRIME_NUM;
        }

        p = getHashValue(pattern.toCharArray(), m);
        t = getHashValue(text.toCharArray(), m);

        int i, j;
        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                if (j == m) {
                    result.found = true;
                    result.occurrences += 1;
                    result.indices.add(i);
                }
            }

            if (i < n - m) {
                t = (ASCII_NUM * (t - text.charAt(i) * h) + text.charAt(i + m)) % PRIME_NUM;
                if (t < 0) {
                    t = (t + PRIME_NUM);
                }
            }
        }

        return result;
    }

    // Returns a hash value for the char-Array (according to the Lecture)
    private long getHashValue(char[] a, int m) {
        long p = 0;
        for (int i = 0; i < m; i++) {
            p = (ASCII_NUM * p + a[i]) % PRIME_NUM;
        }
        return p;
    }
}
