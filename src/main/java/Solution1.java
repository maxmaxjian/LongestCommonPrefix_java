import java.util.*;

public class Solution1 implements Solution {
    @Override
    public String longestCommonPrefix(String[] strs) {

        TrieNode root = buildTrie(strs);

        Stack<TrieNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TrieNode curr = st.pop();
            if (curr.isWhole() ||
                    (!curr.isWhole() && curr.getChildren().size() > 1 || curr.getChildren().size() == 0)) {
                return curr.str();
            } else {
                st.push(curr.getChildren().get(0));
            }
        }
        return null;
    }

    private TrieNode buildTrie(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        TrieNode root = new TrieNode("", containsEmptyString(strs));
        if (strs.length > 0) {
            for (int i = 0; i < strs.length; i++) {
                TrieNode node = find(root, strs[i]);
                String currStr = node.str();
                for (int j = currStr.length()+1; j <= strs[i].length(); j++) {
                    TrieNode next = new TrieNode(strs[i].substring(0, j), j == strs[i].length());
                    node.add(next);
                    node = next;
                }
            }
        }
        return root;
    }

    private boolean containsEmptyString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return true;
            }
        }
        return false;
    }

    private TrieNode find(TrieNode root, String s) {
        Stack<TrieNode> st = new Stack<>();
        st.push(root);
        TrieNode curr = null;
        while (!st.isEmpty()) {
            curr = st.pop();
            if (curr.getChildren().isEmpty()) {
                return curr;
            } else {
                for (TrieNode node : curr.getChildren()) {
                    if (s.indexOf(node.str()) == 0) {
                        st.push(node);
                    }
                }
            }
        }
        return curr;
    }
}
