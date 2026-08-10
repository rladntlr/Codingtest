class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){

             if (!tokens[i].equals("+") && 
                !tokens[i].equals("-") && 
                !tokens[i].equals("*") && 
                !tokens[i].equals("/")) {
                q.push(Integer.parseInt(tokens[i]));
            } else {
                int a = q.pop();
                int b = q.pop();

                if (tokens[i].equals("+")) {
                    q.push(b + a);
                } 
                else if (tokens[i].equals("-")) {
                    q.push(b - a);
                }
                else if (tokens[i].equals("*")) {
                    q.push(b * a);
                }
                else if (tokens[i].equals("/")) {
                    q.push(b / a);
                }
            }
        }
        return q.pop();
    }
}