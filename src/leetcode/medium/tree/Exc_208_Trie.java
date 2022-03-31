package leetcode.medium.tree;

class Trie {
    private boolean isEnd;
    private Trie[] next;

    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    public void insert(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            int ind = c - 'a';
            if (curr.next[ind] == null) {
                curr.next[ind] = new Trie();
            }
            curr = curr.next[ind];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        char[] tokens = word.toCharArray();
        Trie curr = this;
        for (char c : tokens) {
            int ind = c - 'a';
            curr = curr.next[ind];
            if (curr == null) {
                return false;
            }
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] tokens = prefix.toCharArray();
        Trie curr = this;
        for (char c : tokens) {
            int ind = c - 'a';
            curr = curr.next[ind];
            if (curr == null) {
                return false;
            }
        }
        return true;
    }
}

public class Exc_208_Trie {
    public static void main(String[] args) {
        /**
         * ["Trie","insert","insert","insert","insert","insert","insert",
         * "search","search", "search","search","search","search","search","search","search",
         * "startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
         * [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],
         * ["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],
         * ["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
         */
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ad"));
        System.out.println(trie.search("applepie"));
        System.out.println(trie.search("rest"));
        System.out.println(trie.search("jan"));
        System.out.println(trie.search("rent"));
        System.out.println(trie.search("beer"));
        System.out.println(trie.search("jam"));
        System.out.println(trie.startsWith("apps"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("ad"));
        System.out.println(trie.startsWith("applepie"));
        System.out.println(trie.startsWith("rest"));
        System.out.println(trie.startsWith("jan"));
        System.out.println(trie.startsWith("rent"));
        System.out.println(trie.startsWith("beer"));
        System.out.println(trie.startsWith("jam"));
    }
}
