package leetCodeHard;
 

class TrieNode {
    TrieNode[] childen;
    char ch;
    boolean mark;
    public TrieNode() {
        childen = new TrieNode[26];
    }
}

