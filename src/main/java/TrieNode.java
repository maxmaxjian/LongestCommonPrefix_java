import java.util.ArrayList;
import java.util.List;

class TrieNode {
    private final String str;
    private final boolean isWhole;
    private final List<TrieNode> children = new ArrayList<>();

    public TrieNode(String s) {
        this(s, false);
    }

    public TrieNode(String s, boolean isWhole) {
        str = s;
        this.isWhole = isWhole;
    }

    public void add(TrieNode node) {
        children.add(node);
    }

    public String str() {
        return str;
    }

    public List<TrieNode> getChildren() {
        return children;
    }

    public boolean isWhole() {
        return isWhole;
    }
}