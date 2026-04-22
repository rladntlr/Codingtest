class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for (String word : babbling) {
            int i = 0;

            while (i < word.length()) {
                if (word.startsWith("aya", i)) {
                    i += 3;
                } else if (word.startsWith("ye", i)) {
                    i += 2;
                } else if (word.startsWith("woo", i)) {
                    i += 3;
                } else if (word.startsWith("ma", i)) {
                    i += 2;
                } else {
                    break;
                }
            }

            if (i == word.length()) {
                answer++;
            }
        }

        return answer;
    }
}