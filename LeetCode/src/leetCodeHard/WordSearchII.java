package leetCodeHard;
 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
//150605
public class WordSearchII { 
	
	// I think Trie-based solution may be advanced by using a counter in each Trie node 
	// which counts the number of words in its child nodes that haven't been found, 
	// so that when a word or perfix appers many times in the board,
	// repeated search can be avoided.
	
	// other's solution also with Trie
//	public List<String> findWords(char[][] board, String[] words) {
//	    List<String> strList = new LinkedList<String>();
//	    if (board.length == 0 || board[0].length == 0 || words.length == 0) return strList; 
//	    Trie trie = new Trie();
//	    for (String word : words) trie.add(word);
//	    TrieNode root = trie.root;
//	    StringBuffer strbuf = new StringBuffer();
//	    for (int i = 0; i < board.length; i++) {
//	        for (int j = 0; j < board[i].length; j++) {
//	            dfs(board, i, j, root, strbuf, strList);
//	        }
//	    }
//	    return strList;
//	}
//	private void dfs(char[][] board, int i, int j, TrieNode node, StringBuffer strbuf, List<String> strList) {
//	    if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == ' ') return;
//	    TrieNode nextNode = node.next.get(board[i][j]);
//	    if (nextNode == null) return;
//	    strbuf.append(board[i][j]);
//	    board[i][j] = ' ';
//	    if (nextNode.isWord) {
//	        nextNode.isWord = false;
//	        TrieNode tmp = nextNode;
//	        do {    //update counter
//	            tmp.wordCnt--;
//	            tmp = tmp.pre;
//	        } while (tmp != null);
//	        strList.add(strbuf.toString());
//	    }
//	    if (nextNode.wordCnt > 0) {     //avoid repeated search
//	        dfs(board, i + 1, j, nextNode, strbuf, strList);
//	        dfs(board, i - 1, j, nextNode, strbuf, strList);
//	        dfs(board, i, j - 1, nextNode, strbuf, strList);
//	        dfs(board, i, j + 1, nextNode, strbuf, strList);
//	    }
//	    board[i][j] = strbuf.charAt(strbuf.length() - 1);
//	    strbuf.deleteCharAt(strbuf.length() - 1);
//
//	    return;
//	}
//	class TrieNode {
//	    boolean isWord;
//	    int wordCnt;    //counter of words haven't been found in the subtree
//	    TrieNode pre;   //parent of the node
//	    HashMap<Character, TrieNode> next;
//	    public TrieNode() {
//	        pre = null;
//	        isWord = false;
//	        wordCnt = 0;
//	        next = new HashMap<>();
//	    }
//	}
//	class Trie {
//	    TrieNode root;
//	    public Trie() {
//	        root = new TrieNode();
//	    }
//	    public void add(String word) {
//	        TrieNode tmp = root;
//	        char[] arr = word.toCharArray();
//	        for (char c : arr) {
//	            TrieNode next = tmp.next.get(c);
//	            if (next == null) {
//	                next = new TrieNode();
//	                next.pre = tmp;
//	                tmp.next.put(c, next);
//	            }
//	            tmp = next;
//	        }
//	        if (tmp.isWord == false) {
//	            tmp.isWord = true;
//	            do {    //update counter
//	                tmp.wordCnt++;
//	                tmp = tmp.pre;
//	            } while (tmp != null);
//	        }
//	    }
//	}
	
	
	
	
	
	
	class TrieNode {
	    TrieNode[] childen;
	    char ch;
	    boolean mark;
	    public TrieNode() {
	        childen = new TrieNode[26];
	    }
	}
	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			if (word == null || word.length() == 0) {
				return;
			}
			if (search(word)) {
				return;
			} else {
				TrieNode temp = root;
				char first = word.charAt(0);
				for (int i = 0; i < word.length(); i++) {
					first = word.charAt(i);
					if (temp.childen[first - 'a'] == null) {
						temp.childen[first - 'a'] = new TrieNode();
						temp.childen[first - 'a'].ch = first;
					}
					temp = temp.childen[first - 'a'];
				}
				temp.mark = true;
			}
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			if (word.length() == 0 || word == null) {
				return true;
			}
			TrieNode temp = root;
			char first = word.charAt(0);
			for (int i = 0; i < word.length(); i++) {
				first = word.charAt(i);
				if (temp.childen[first - 'a'] == null) {
					return false;
				}
				temp = temp.childen[first - 'a'];
			}
			return temp.mark;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			if (prefix.length() == 0 || prefix == null) {
				return true;
			}
			TrieNode temp = root;
			for (int i = 0; i < prefix.length(); i++) {
				char first = prefix.charAt(i);
				if (temp.childen[first - 'a'] == null) {
					return false;
				}
				temp = temp.childen[first - 'a'];
			}
			return true;
		}
 
	}
 
	Set<String> res = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        } 
        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) 
        	return;
        if (visited[x][y]) 
        	return; 
        str += board[x][y];
        if (!trie.startsWith(str)) 
        	return;

        if (trie.search(str)) {
            res.add(str);
        } 
        visited[x][y] = true;
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }

	
	// TLE
//	List<String> res = new ArrayList<>();
//	public List<String> findWords(char[][] board, String[] words) {
//		for (int i = 0; i < words.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				boolean find = false;
//				for (int k = 0; k < board[0].length; k++) {
//					if (board[j][k] == words[i].charAt(0) && find(board, words[i], j, k, 0)) {
//						res.add(words[i]);
//						find = true;
//						break;
//					}
//				}
//				if (find) {
//					break;
//				}
//			}
//		}
//		return res;
//    }
//
//	public boolean find(char[][] board, String s, int i , int j, int index) {
//		if (index == s.length()) {
//			return true;
//		}
//		if (s.charAt(index) == board[i][j]) {
//			board[i][j] = '.';
//			boolean res = false;
//			if ( i > 0 ) {
//				res = res || find(board, s, i - 1, j, index + 1);
//			}
//			if ( j > 0 ) {
//				res = res || find(board, s, i , j - 1, index + 1);
//			}
//			if ( i < board.length - 1 ) {
//				res = res || find(board, s, i + 1, j, index + 1);
//			}
//			if ( j < board[0].length - 1) {
//				res = res || find(board, s, i, j + 1, index + 1);
//			}
//			board[i][j] = s.charAt(index);
//			return res;
//		} else {
//			return false;
//		}
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] words = {"aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaf","aaaaaaaaaaaaaaag","aaaaaaaaaaaaaaah","aaaaaaaaaaaaaaai","aaaaaaaaaaaaaaaj","aaaaaaaaaaaaaaak","aaaaaaaaaaaaaaal","aaaaaaaaaaaaaaam","aaaaaaaaaaaaaaan","aaaaaaaaaaaaaaao","aaaaaaaaaaaaaaap","aaaaaaaaaaaaaaaq","aaaaaaaaaaaaaaar","aaaaaaaaaaaaaaas","aaaaaaaaaaaaaaat","aaaaaaaaaaaaaaau","aaaaaaaaaaaaaaav","aaaaaaaaaaaaaaaw","aaaaaaaaaaaaaaax","aaaaaaaaaaaaaaay","aaaaaaaaaaaaaaaz","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaf","aaaaaaaaaaaaaaag","aaaaaaaaaaaaaaah","aaaaaaaaaaaaaaai","aaaaaaaaaaaaaaaj","aaaaaaaaaaaaaaak","aaaaaaaaaaaaaaal","aaaaaaaaaaaaaaam","aaaaaaaaaaaaaaan","aaaaaaaaaaaaaaao","aaaaaaaaaaaaaaap","aaaaaaaaaaaaaaaq","aaaaaaaaaaaaaaar","aaaaaaaaaaaaaaas","aaaaaaaaaaaaaaat","aaaaaaaaaaaaaaau","aaaaaaaaaaaaaaav","aaaaaaaaaaaaaaaw","aaaaaaaaaaaaaaax","aaaaaaaaaaaaaaay","aaaaaaaaaaaaaaaz","aaaaaaaaaaaaaaba","aaaaaaaaaaaaaabb","aaaaaaaaaaaaaabc","aaaaaaaaaaaaaabd","aaaaaaaaaaaaaabe","aaaaaaaaaaaaaabf","aaaaaaaaaaaaaabg","aaaaaaaaaaaaaabh","aaaaaaaaaaaaaabi","aaaaaaaaaaaaaabj","aaaaaaaaaaaaaabk","aaaaaaaaaaaaaabl","aaaaaaaaaaaaaabm","aaaaaaaaaaaaaabn","aaaaaaaaaaaaaabo","aaaaaaaaaaaaaabp","aaaaaaaaaaaaaabq","aaaaaaaaaaaaaabr","aaaaaaaaaaaaaabs","aaaaaaaaaaaaaabt","aaaaaaaaaaaaaabu","aaaaaaaaaaaaaabv","aaaaaaaaaaaaaabw","aaaaaaaaaaaaaabx","aaaaaaaaaaaaaaby","aaaaaaaaaaaaaabz","aaaaaaaaaaaaaaca","aaaaaaaaaaaaaacb","aaaaaaaaaaaaaacc","aaaaaaaaaaaaaacd","aaaaaaaaaaaaaace","aaaaaaaaaaaaaacf","aaaaaaaaaaaaaacg","aaaaaaaaaaaaaach","aaaaaaaaaaaaaaci","aaaaaaaaaaaaaacj","aaaaaaaaaaaaaack","aaaaaaaaaaaaaacl","aaaaaaaaaaaaaacm","aaaaaaaaaaaaaacn","aaaaaaaaaaaaaaco","aaaaaaaaaaaaaacp","aaaaaaaaaaaaaacq","aaaaaaaaaaaaaacr","aaaaaaaaaaaaaacs","aaaaaaaaaaaaaact","aaaaaaaaaaaaaacu","aaaaaaaaaaaaaacv","aaaaaaaaaaaaaacw","aaaaaaaaaaaaaacx","aaaaaaaaaaaaaacy","aaaaaaaaaaaaaacz","aaaaaaaaaaaaaada","aaaaaaaaaaaaaadb","aaaaaaaaaaaaaadc","aaaaaaaaaaaaaadd","aaaaaaaaaaaaaade","aaaaaaaaaaaaaadf","aaaaaaaaaaaaaadg","aaaaaaaaaaaaaadh","aaaaaaaaaaaaaadi","aaaaaaaaaaaaaadj","aaaaaaaaaaaaaadk","aaaaaaaaaaaaaadl","aaaaaaaaaaaaaadm","aaaaaaaaaaaaaadn","aaaaaaaaaaaaaado","aaaaaaaaaaaaaadp","aaaaaaaaaaaaaadq","aaaaaaaaaaaaaadr","aaaaaaaaaaaaaads","aaaaaaaaaaaaaadt","aaaaaaaaaaaaaadu","aaaaaaaaaaaaaadv","aaaaaaaaaaaaaadw","aaaaaaaaaaaaaadx","aaaaaaaaaaaaaady","aaaaaaaaaaaaaadz","aaaaaaaaaaaaaaea","aaaaaaaaaaaaaaeb","aaaaaaaaaaaaaaec","aaaaaaaaaaaaaaed","aaaaaaaaaaaaaaee","aaaaaaaaaaaaaaef","aaaaaaaaaaaaaaeg","aaaaaaaaaaaaaaeh","aaaaaaaaaaaaaaei","aaaaaaaaaaaaaaej","aaaaaaaaaaaaaaek","aaaaaaaaaaaaaael","aaaaaaaaaaaaaaem","aaaaaaaaaaaaaaen","aaaaaaaaaaaaaaeo","aaaaaaaaaaaaaaep","aaaaaaaaaaaaaaeq","aaaaaaaaaaaaaaer","aaaaaaaaaaaaaaes","aaaaaaaaaaaaaaet","aaaaaaaaaaaaaaeu","aaaaaaaaaaaaaaev","aaaaaaaaaaaaaaew","aaaaaaaaaaaaaaex","aaaaaaaaaaaaaaey","aaaaaaaaaaaaaaez","aaaaaaaaaaaaaafa","aaaaaaaaaaaaaafb","aaaaaaaaaaaaaafc","aaaaaaaaaaaaaafd","aaaaaaaaaaaaaafe","aaaaaaaaaaaaaaff","aaaaaaaaaaaaaafg","aaaaaaaaaaaaaafh","aaaaaaaaaaaaaafi","aaaaaaaaaaaaaafj","aaaaaaaaaaaaaafk","aaaaaaaaaaaaaafl","aaaaaaaaaaaaaafm","aaaaaaaaaaaaaafn","aaaaaaaaaaaaaafo","aaaaaaaaaaaaaafp","aaaaaaaaaaaaaafq","aaaaaaaaaaaaaafr","aaaaaaaaaaaaaafs","aaaaaaaaaaaaaaft","aaaaaaaaaaaaaafu","aaaaaaaaaaaaaafv","aaaaaaaaaaaaaafw","aaaaaaaaaaaaaafx","aaaaaaaaaaaaaafy","aaaaaaaaaaaaaafz","aaaaaaaaaaaaaaga","aaaaaaaaaaaaaagb","aaaaaaaaaaaaaagc","aaaaaaaaaaaaaagd","aaaaaaaaaaaaaage","aaaaaaaaaaaaaagf","aaaaaaaaaaaaaagg","aaaaaaaaaaaaaagh","aaaaaaaaaaaaaagi","aaaaaaaaaaaaaagj","aaaaaaaaaaaaaagk","aaaaaaaaaaaaaagl","aaaaaaaaaaaaaagm","aaaaaaaaaaaaaagn","aaaaaaaaaaaaaago","aaaaaaaaaaaaaagp","aaaaaaaaaaaaaagq","aaaaaaaaaaaaaagr","aaaaaaaaaaaaaags","aaaaaaaaaaaaaagt","aaaaaaaaaaaaaagu","aaaaaaaaaaaaaagv","aaaaaaaaaaaaaagw","aaaaaaaaaaaaaagx","aaaaaaaaaaaaaagy","aaaaaaaaaaaaaagz","aaaaaaaaaaaaaaha","aaaaaaaaaaaaaahb","aaaaaaaaaaaaaahc","aaaaaaaaaaaaaahd","aaaaaaaaaaaaaahe","aaaaaaaaaaaaaahf","aaaaaaaaaaaaaahg","aaaaaaaaaaaaaahh","aaaaaaaaaaaaaahi","aaaaaaaaaaaaaahj","aaaaaaaaaaaaaahk","aaaaaaaaaaaaaahl","aaaaaaaaaaaaaahm","aaaaaaaaaaaaaahn","aaaaaaaaaaaaaaho","aaaaaaaaaaaaaahp","aaaaaaaaaaaaaahq","aaaaaaaaaaaaaahr","aaaaaaaaaaaaaahs","aaaaaaaaaaaaaaht","aaaaaaaaaaaaaahu","aaaaaaaaaaaaaahv","aaaaaaaaaaaaaahw","aaaaaaaaaaaaaahx","aaaaaaaaaaaaaahy","aaaaaaaaaaaaaahz","aaaaaaaaaaaaaaia","aaaaaaaaaaaaaaib","aaaaaaaaaaaaaaic","aaaaaaaaaaaaaaid","aaaaaaaaaaaaaaie","aaaaaaaaaaaaaaif","aaaaaaaaaaaaaaig","aaaaaaaaaaaaaaih","aaaaaaaaaaaaaaii","aaaaaaaaaaaaaaij","aaaaaaaaaaaaaaik","aaaaaaaaaaaaaail","aaaaaaaaaaaaaaim","aaaaaaaaaaaaaain","aaaaaaaaaaaaaaio","aaaaaaaaaaaaaaip","aaaaaaaaaaaaaaiq","aaaaaaaaaaaaaair","aaaaaaaaaaaaaais","aaaaaaaaaaaaaait","aaaaaaaaaaaaaaiu","aaaaaaaaaaaaaaiv","aaaaaaaaaaaaaaiw","aaaaaaaaaaaaaaix","aaaaaaaaaaaaaaiy","aaaaaaaaaaaaaaiz","aaaaaaaaaaaaaaja","aaaaaaaaaaaaaajb","aaaaaaaaaaaaaajc","aaaaaaaaaaaaaajd","aaaaaaaaaaaaaaje","aaaaaaaaaaaaaajf","aaaaaaaaaaaaaajg","aaaaaaaaaaaaaajh","aaaaaaaaaaaaaaji","aaaaaaaaaaaaaajj","aaaaaaaaaaaaaajk","aaaaaaaaaaaaaajl","aaaaaaaaaaaaaajm","aaaaaaaaaaaaaajn","aaaaaaaaaaaaaajo","aaaaaaaaaaaaaajp","aaaaaaaaaaaaaajq","aaaaaaaaaaaaaajr","aaaaaaaaaaaaaajs","aaaaaaaaaaaaaajt","aaaaaaaaaaaaaaju","aaaaaaaaaaaaaajv","aaaaaaaaaaaaaajw","aaaaaaaaaaaaaajx","aaaaaaaaaaaaaajy","aaaaaaaaaaaaaajz","aaaaaaaaaaaaaaka","aaaaaaaaaaaaaakb","aaaaaaaaaaaaaakc","aaaaaaaaaaaaaakd","aaaaaaaaaaaaaake","aaaaaaaaaaaaaakf","aaaaaaaaaaaaaakg","aaaaaaaaaaaaaakh","aaaaaaaaaaaaaaki","aaaaaaaaaaaaaakj","aaaaaaaaaaaaaakk","aaaaaaaaaaaaaakl","aaaaaaaaaaaaaakm","aaaaaaaaaaaaaakn","aaaaaaaaaaaaaako","aaaaaaaaaaaaaakp","aaaaaaaaaaaaaakq","aaaaaaaaaaaaaakr","aaaaaaaaaaaaaaks","aaaaaaaaaaaaaakt","aaaaaaaaaaaaaaku","aaaaaaaaaaaaaakv","aaaaaaaaaaaaaakw","aaaaaaaaaaaaaakx","aaaaaaaaaaaaaaky","aaaaaaaaaaaaaakz","aaaaaaaaaaaaaala","aaaaaaaaaaaaaalb","aaaaaaaaaaaaaalc","aaaaaaaaaaaaaald","aaaaaaaaaaaaaale","aaaaaaaaaaaaaalf","aaaaaaaaaaaaaalg","aaaaaaaaaaaaaalh","aaaaaaaaaaaaaali","aaaaaaaaaaaaaalj","aaaaaaaaaaaaaalk","aaaaaaaaaaaaaall","aaaaaaaaaaaaaalm","aaaaaaaaaaaaaaln","aaaaaaaaaaaaaalo","aaaaaaaaaaaaaalp","aaaaaaaaaaaaaalq","aaaaaaaaaaaaaalr","aaaaaaaaaaaaaals","aaaaaaaaaaaaaalt","aaaaaaaaaaaaaalu","aaaaaaaaaaaaaalv","aaaaaaaaaaaaaalw","aaaaaaaaaaaaaalx","aaaaaaaaaaaaaaly","aaaaaaaaaaaaaalz","aaaaaaaaaaaaaama","aaaaaaaaaaaaaamb","aaaaaaaaaaaaaamc","aaaaaaaaaaaaaamd","aaaaaaaaaaaaaame","aaaaaaaaaaaaaamf","aaaaaaaaaaaaaamg","aaaaaaaaaaaaaamh","aaaaaaaaaaaaaami","aaaaaaaaaaaaaamj","aaaaaaaaaaaaaamk","aaaaaaaaaaaaaaml","aaaaaaaaaaaaaamm","aaaaaaaaaaaaaamn","aaaaaaaaaaaaaamo","aaaaaaaaaaaaaamp","aaaaaaaaaaaaaamq","aaaaaaaaaaaaaamr","aaaaaaaaaaaaaams","aaaaaaaaaaaaaamt","aaaaaaaaaaaaaamu","aaaaaaaaaaaaaamv","aaaaaaaaaaaaaamw","aaaaaaaaaaaaaamx","aaaaaaaaaaaaaamy","aaaaaaaaaaaaaamz","aaaaaaaaaaaaaana","aaaaaaaaaaaaaanb","aaaaaaaaaaaaaanc","aaaaaaaaaaaaaand","aaaaaaaaaaaaaane","aaaaaaaaaaaaaanf","aaaaaaaaaaaaaang","aaaaaaaaaaaaaanh","aaaaaaaaaaaaaani","aaaaaaaaaaaaaanj","aaaaaaaaaaaaaank","aaaaaaaaaaaaaanl","aaaaaaaaaaaaaanm","aaaaaaaaaaaaaann","aaaaaaaaaaaaaano","aaaaaaaaaaaaaanp","aaaaaaaaaaaaaanq","aaaaaaaaaaaaaanr","aaaaaaaaaaaaaans","aaaaaaaaaaaaaant","aaaaaaaaaaaaaanu","aaaaaaaaaaaaaanv","aaaaaaaaaaaaaanw","aaaaaaaaaaaaaanx","aaaaaaaaaaaaaany","aaaaaaaaaaaaaanz","aaaaaaaaaaaaaaoa","aaaaaaaaaaaaaaob","aaaaaaaaaaaaaaoc","aaaaaaaaaaaaaaod","aaaaaaaaaaaaaaoe","aaaaaaaaaaaaaaof","aaaaaaaaaaaaaaog","aaaaaaaaaaaaaaoh","aaaaaaaaaaaaaaoi","aaaaaaaaaaaaaaoj","aaaaaaaaaaaaaaok","aaaaaaaaaaaaaaol","aaaaaaaaaaaaaaom","aaaaaaaaaaaaaaon","aaaaaaaaaaaaaaoo","aaaaaaaaaaaaaaop","aaaaaaaaaaaaaaoq","aaaaaaaaaaaaaaor","aaaaaaaaaaaaaaos","aaaaaaaaaaaaaaot","aaaaaaaaaaaaaaou","aaaaaaaaaaaaaaov","aaaaaaaaaaaaaaow","aaaaaaaaaaaaaaox","aaaaaaaaaaaaaaoy","aaaaaaaaaaaaaaoz","aaaaaaaaaaaaaapa","aaaaaaaaaaaaaapb","aaaaaaaaaaaaaapc","aaaaaaaaaaaaaapd","aaaaaaaaaaaaaape","aaaaaaaaaaaaaapf","aaaaaaaaaaaaaapg","aaaaaaaaaaaaaaph","aaaaaaaaaaaaaapi","aaaaaaaaaaaaaapj","aaaaaaaaaaaaaapk","aaaaaaaaaaaaaapl","aaaaaaaaaaaaaapm","aaaaaaaaaaaaaapn","aaaaaaaaaaaaaapo","aaaaaaaaaaaaaapp","aaaaaaaaaaaaaapq","aaaaaaaaaaaaaapr","aaaaaaaaaaaaaaps","aaaaaaaaaaaaaapt","aaaaaaaaaaaaaapu","aaaaaaaaaaaaaapv","aaaaaaaaaaaaaapw","aaaaaaaaaaaaaapx","aaaaaaaaaaaaaapy","aaaaaaaaaaaaaapz","aaaaaaaaaaaaaaqa","aaaaaaaaaaaaaaqb","aaaaaaaaaaaaaaqc","aaaaaaaaaaaaaaqd","aaaaaaaaaaaaaaqe","aaaaaaaaaaaaaaqf","aaaaaaaaaaaaaaqg","aaaaaaaaaaaaaaqh","aaaaaaaaaaaaaaqi","aaaaaaaaaaaaaaqj","aaaaaaaaaaaaaaqk","aaaaaaaaaaaaaaql","aaaaaaaaaaaaaaqm","aaaaaaaaaaaaaaqn","aaaaaaaaaaaaaaqo","aaaaaaaaaaaaaaqp","aaaaaaaaaaaaaaqq","aaaaaaaaaaaaaaqr","aaaaaaaaaaaaaaqs","aaaaaaaaaaaaaaqt","aaaaaaaaaaaaaaqu","aaaaaaaaaaaaaaqv","aaaaaaaaaaaaaaqw","aaaaaaaaaaaaaaqx","aaaaaaaaaaaaaaqy","aaaaaaaaaaaaaaqz","aaaaaaaaaaaaaara","aaaaaaaaaaaaaarb","aaaaaaaaaaaaaarc","aaaaaaaaaaaaaard","aaaaaaaaaaaaaare","aaaaaaaaaaaaaarf","aaaaaaaaaaaaaarg","aaaaaaaaaaaaaarh","aaaaaaaaaaaaaari","aaaaaaaaaaaaaarj","aaaaaaaaaaaaaark","aaaaaaaaaaaaaarl","aaaaaaaaaaaaaarm","aaaaaaaaaaaaaarn","aaaaaaaaaaaaaaro","aaaaaaaaaaaaaarp","aaaaaaaaaaaaaarq","aaaaaaaaaaaaaarr","aaaaaaaaaaaaaars","aaaaaaaaaaaaaart","aaaaaaaaaaaaaaru","aaaaaaaaaaaaaarv","aaaaaaaaaaaaaarw","aaaaaaaaaaaaaarx","aaaaaaaaaaaaaary","aaaaaaaaaaaaaarz","aaaaaaaaaaaaaasa","aaaaaaaaaaaaaasb","aaaaaaaaaaaaaasc","aaaaaaaaaaaaaasd","aaaaaaaaaaaaaase","aaaaaaaaaaaaaasf","aaaaaaaaaaaaaasg","aaaaaaaaaaaaaash","aaaaaaaaaaaaaasi","aaaaaaaaaaaaaasj","aaaaaaaaaaaaaask","aaaaaaaaaaaaaasl","aaaaaaaaaaaaaasm","aaaaaaaaaaaaaasn","aaaaaaaaaaaaaaso","aaaaaaaaaaaaaasp","aaaaaaaaaaaaaasq","aaaaaaaaaaaaaasr","aaaaaaaaaaaaaass","aaaaaaaaaaaaaast","aaaaaaaaaaaaaasu","aaaaaaaaaaaaaasv","aaaaaaaaaaaaaasw","aaaaaaaaaaaaaasx","aaaaaaaaaaaaaasy","aaaaaaaaaaaaaasz","aaaaaaaaaaaaaata","aaaaaaaaaaaaaatb","aaaaaaaaaaaaaatc","aaaaaaaaaaaaaatd","aaaaaaaaaaaaaate","aaaaaaaaaaaaaatf","aaaaaaaaaaaaaatg","aaaaaaaaaaaaaath","aaaaaaaaaaaaaati","aaaaaaaaaaaaaatj","aaaaaaaaaaaaaatk","aaaaaaaaaaaaaatl","aaaaaaaaaaaaaatm","aaaaaaaaaaaaaatn","aaaaaaaaaaaaaato","aaaaaaaaaaaaaatp","aaaaaaaaaaaaaatq","aaaaaaaaaaaaaatr","aaaaaaaaaaaaaats","aaaaaaaaaaaaaatt","aaaaaaaaaaaaaatu","aaaaaaaaaaaaaatv","aaaaaaaaaaaaaatw","aaaaaaaaaaaaaatx","aaaaaaaaaaaaaaty","aaaaaaaaaaaaaatz","aaaaaaaaaaaaaaua","aaaaaaaaaaaaaaub","aaaaaaaaaaaaaauc","aaaaaaaaaaaaaaud","aaaaaaaaaaaaaaue","aaaaaaaaaaaaaauf","aaaaaaaaaaaaaaug","aaaaaaaaaaaaaauh","aaaaaaaaaaaaaaui","aaaaaaaaaaaaaauj","aaaaaaaaaaaaaauk","aaaaaaaaaaaaaaul","aaaaaaaaaaaaaaum","aaaaaaaaaaaaaaun","aaaaaaaaaaaaaauo","aaaaaaaaaaaaaaup","aaaaaaaaaaaaaauq","aaaaaaaaaaaaaaur","aaaaaaaaaaaaaaus","aaaaaaaaaaaaaaut","aaaaaaaaaaaaaauu","aaaaaaaaaaaaaauv","aaaaaaaaaaaaaauw","aaaaaaaaaaaaaaux","aaaaaaaaaaaaaauy","aaaaaaaaaaaaaauz","aaaaaaaaaaaaaava","aaaaaaaaaaaaaavb","aaaaaaaaaaaaaavc","aaaaaaaaaaaaaavd","aaaaaaaaaaaaaave","aaaaaaaaaaaaaavf","aaaaaaaaaaaaaavg","aaaaaaaaaaaaaavh","aaaaaaaaaaaaaavi","aaaaaaaaaaaaaavj","aaaaaaaaaaaaaavk","aaaaaaaaaaaaaavl","aaaaaaaaaaaaaavm","aaaaaaaaaaaaaavn","aaaaaaaaaaaaaavo","aaaaaaaaaaaaaavp","aaaaaaaaaaaaaavq","aaaaaaaaaaaaaavr","aaaaaaaaaaaaaavs","aaaaaaaaaaaaaavt","aaaaaaaaaaaaaavu","aaaaaaaaaaaaaavv","aaaaaaaaaaaaaavw","aaaaaaaaaaaaaavx","aaaaaaaaaaaaaavy","aaaaaaaaaaaaaavz","aaaaaaaaaaaaaawa","aaaaaaaaaaaaaawb","aaaaaaaaaaaaaawc","aaaaaaaaaaaaaawd","aaaaaaaaaaaaaawe","aaaaaaaaaaaaaawf","aaaaaaaaaaaaaawg","aaaaaaaaaaaaaawh","aaaaaaaaaaaaaawi","aaaaaaaaaaaaaawj","aaaaaaaaaaaaaawk","aaaaaaaaaaaaaawl","aaaaaaaaaaaaaawm","aaaaaaaaaaaaaawn","aaaaaaaaaaaaaawo","aaaaaaaaaaaaaawp","aaaaaaaaaaaaaawq","aaaaaaaaaaaaaawr","aaaaaaaaaaaaaaws","aaaaaaaaaaaaaawt","aaaaaaaaaaaaaawu","aaaaaaaaaaaaaawv","aaaaaaaaaaaaaaww","aaaaaaaaaaaaaawx","aaaaaaaaaaaaaawy","aaaaaaaaaaaaaawz","aaaaaaaaaaaaaaxa","aaaaaaaaaaaaaaxb","aaaaaaaaaaaaaaxc","aaaaaaaaaaaaaaxd","aaaaaaaaaaaaaaxe","aaaaaaaaaaaaaaxf","aaaaaaaaaaaaaaxg","aaaaaaaaaaaaaaxh","aaaaaaaaaaaaaaxi","aaaaaaaaaaaaaaxj","aaaaaaaaaaaaaaxk","aaaaaaaaaaaaaaxl","aaaaaaaaaaaaaaxm","aaaaaaaaaaaaaaxn","aaaaaaaaaaaaaaxo","aaaaaaaaaaaaaaxp","aaaaaaaaaaaaaaxq","aaaaaaaaaaaaaaxr","aaaaaaaaaaaaaaxs","aaaaaaaaaaaaaaxt","aaaaaaaaaaaaaaxu","aaaaaaaaaaaaaaxv","aaaaaaaaaaaaaaxw","aaaaaaaaaaaaaaxx","aaaaaaaaaaaaaaxy","aaaaaaaaaaaaaaxz","aaaaaaaaaaaaaaya","aaaaaaaaaaaaaayb","aaaaaaaaaaaaaayc","aaaaaaaaaaaaaayd","aaaaaaaaaaaaaaye","aaaaaaaaaaaaaayf","aaaaaaaaaaaaaayg","aaaaaaaaaaaaaayh","aaaaaaaaaaaaaayi","aaaaaaaaaaaaaayj","aaaaaaaaaaaaaayk","aaaaaaaaaaaaaayl","aaaaaaaaaaaaaaym","aaaaaaaaaaaaaayn","aaaaaaaaaaaaaayo","aaaaaaaaaaaaaayp","aaaaaaaaaaaaaayq","aaaaaaaaaaaaaayr","aaaaaaaaaaaaaays","aaaaaaaaaaaaaayt","aaaaaaaaaaaaaayu","aaaaaaaaaaaaaayv","aaaaaaaaaaaaaayw","aaaaaaaaaaaaaayx","aaaaaaaaaaaaaayy","aaaaaaaaaaaaaayz","aaaaaaaaaaaaaaza","aaaaaaaaaaaaaazb","aaaaaaaaaaaaaazc","aaaaaaaaaaaaaazd","aaaaaaaaaaaaaaze","aaaaaaaaaaaaaazf","aaaaaaaaaaaaaazg","aaaaaaaaaaaaaazh","aaaaaaaaaaaaaazi","aaaaaaaaaaaaaazj","aaaaaaaaaaaaaazk","aaaaaaaaaaaaaazl","aaaaaaaaaaaaaazm","aaaaaaaaaaaaaazn","aaaaaaaaaaaaaazo","aaaaaaaaaaaaaazp","aaaaaaaaaaaaaazq","aaaaaaaaaaaaaazr","aaaaaaaaaaaaaazs","aaaaaaaaaaaaaazt","aaaaaaaaaaaaaazu","aaaaaaaaaaaaaazv","aaaaaaaaaaaaaazw","aaaaaaaaaaaaaazx","aaaaaaaaaaaaaazy","aaaaaaaaaaaaaazz","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaf","aaaaaaaaaaaaaaag","aaaaaaaaaaaaaaah","aaaaaaaaaaaaaaai","aaaaaaaaaaaaaaaj","aaaaaaaaaaaaaaak","aaaaaaaaaaaaaaal","aaaaaaaaaaaaaaam","aaaaaaaaaaaaaaan","aaaaaaaaaaaaaaao","aaaaaaaaaaaaaaap","aaaaaaaaaaaaaaaq","aaaaaaaaaaaaaaar","aaaaaaaaaaaaaaas","aaaaaaaaaaaaaaat","aaaaaaaaaaaaaaau","aaaaaaaaaaaaaaav","aaaaaaaaaaaaaaaw","aaaaaaaaaaaaaaax","aaaaaaaaaaaaaaay","aaaaaaaaaaaaaaaz","aaaaaaaaaaaaaaba","aaaaaaaaaaaaaabb","aaaaaaaaaaaaaabc","aaaaaaaaaaaaaabd","aaaaaaaaaaaaaabe","aaaaaaaaaaaaaabf","aaaaaaaaaaaaaabg","aaaaaaaaaaaaaabh","aaaaaaaaaaaaaabi","aaaaaaaaaaaaaabj","aaaaaaaaaaaaaabk","aaaaaaaaaaaaaabl","aaaaaaaaaaaaaabm","aaaaaaaaaaaaaabn","aaaaaaaaaaaaaabo","aaaaaaaaaaaaaabp","aaaaaaaaaaaaaabq","aaaaaaaaaaaaaabr","aaaaaaaaaaaaaabs","aaaaaaaaaaaaaabt","aaaaaaaaaaaaaabu","aaaaaaaaaaaaaabv","aaaaaaaaaaaaaabw","aaaaaaaaaaaaaabx","aaaaaaaaaaaaaaby","aaaaaaaaaaaaaabz","aaaaaaaaaaaaaaca","aaaaaaaaaaaaaacb","aaaaaaaaaaaaaacc","aaaaaaaaaaaaaacd","aaaaaaaaaaaaaace","aaaaaaaaaaaaaacf","aaaaaaaaaaaaaacg","aaaaaaaaaaaaaach","aaaaaaaaaaaaaaci","aaaaaaaaaaaaaacj","aaaaaaaaaaaaaack","aaaaaaaaaaaaaacl","aaaaaaaaaaaaaacm","aaaaaaaaaaaaaacn","aaaaaaaaaaaaaaco","aaaaaaaaaaaaaacp","aaaaaaaaaaaaaacq","aaaaaaaaaaaaaacr","aaaaaaaaaaaaaacs","aaaaaaaaaaaaaact","aaaaaaaaaaaaaacu","aaaaaaaaaaaaaacv","aaaaaaaaaaaaaacw","aaaaaaaaaaaaaacx","aaaaaaaaaaaaaacy","aaaaaaaaaaaaaacz","aaaaaaaaaaaaaada","aaaaaaaaaaaaaadb","aaaaaaaaaaaaaadc","aaaaaaaaaaaaaadd","aaaaaaaaaaaaaade","aaaaaaaaaaaaaadf","aaaaaaaaaaaaaadg","aaaaaaaaaaaaaadh","aaaaaaaaaaaaaadi","aaaaaaaaaaaaaadj","aaaaaaaaaaaaaadk","aaaaaaaaaaaaaadl","aaaaaaaaaaaaaadm","aaaaaaaaaaaaaadn","aaaaaaaaaaaaaado","aaaaaaaaaaaaaadp","aaaaaaaaaaaaaadq","aaaaaaaaaaaaaadr","aaaaaaaaaaaaaads","aaaaaaaaaaaaaadt","aaaaaaaaaaaaaadu","aaaaaaaaaaaaaadv","aaaaaaaaaaaaaadw","aaaaaaaaaaaaaadx","aaaaaaaaaaaaaady","aaaaaaaaaaaaaadz","aaaaaaaaaaaaaaea","aaaaaaaaaaaaaaeb","aaaaaaaaaaaaaaec","aaaaaaaaaaaaaaed","aaaaaaaaaaaaaaee","aaaaaaaaaaaaaaef","aaaaaaaaaaaaaaeg","aaaaaaaaaaaaaaeh","aaaaaaaaaaaaaaei","aaaaaaaaaaaaaaej","aaaaaaaaaaaaaaek","aaaaaaaaaaaaaael","aaaaaaaaaaaaaaem","aaaaaaaaaaaaaaen","aaaaaaaaaaaaaaeo","aaaaaaaaaaaaaaep","aaaaaaaaaaaaaaeq","aaaaaaaaaaaaaaer","aaaaaaaaaaaaaaes","aaaaaaaaaaaaaaet","aaaaaaaaaaaaaaeu","aaaaaaaaaaaaaaev","aaaaaaaaaaaaaaew","aaaaaaaaaaaaaaex","aaaaaaaaaaaaaaey","aaaaaaaaaaaaaaez","aaaaaaaaaaaaaafa","aaaaaaaaaaaaaafb","aaaaaaaaaaaaaafc","aaaaaaaaaaaaaafd","aaaaaaaaaaaaaafe","aaaaaaaaaaaaaaff","aaaaaaaaaaaaaafg","aaaaaaaaaaaaaafh","aaaaaaaaaaaaaafi","aaaaaaaaaaaaaafj","aaaaaaaaaaaaaafk","aaaaaaaaaaaaaafl","aaaaaaaaaaaaaafm","aaaaaaaaaaaaaafn","aaaaaaaaaaaaaafo","aaaaaaaaaaaaaafp","aaaaaaaaaaaaaafq","aaaaaaaaaaaaaafr","aaaaaaaaaaaaaafs","aaaaaaaaaaaaaaft","aaaaaaaaaaaaaafu","aaaaaaaaaaaaaafv","aaaaaaaaaaaaaafw","aaaaaaaaaaaaaafx","aaaaaaaaaaaaaafy","aaaaaaaaaaaaaafz","aaaaaaaaaaaaaaga","aaaaaaaaaaaaaagb","aaaaaaaaaaaaaagc","aaaaaaaaaaaaaagd","aaaaaaaaaaaaaage","aaaaaaaaaaaaaagf","aaaaaaaaaaaaaagg","aaaaaaaaaaaaaagh","aaaaaaaaaaaaaagi","aaaaaaaaaaaaaagj","aaaaaaaaaaaaaagk","aaaaaaaaaaaaaagl","aaaaaaaaaaaaaagm","aaaaaaaaaaaaaagn","aaaaaaaaaaaaaago","aaaaaaaaaaaaaagp","aaaaaaaaaaaaaagq","aaaaaaaaaaaaaagr","aaaaaaaaaaaaaags","aaaaaaaaaaaaaagt","aaaaaaaaaaaaaagu","aaaaaaaaaaaaaagv","aaaaaaaaaaaaaagw","aaaaaaaaaaaaaagx","aaaaaaaaaaaaaagy","aaaaaaaaaaaaaagz","aaaaaaaaaaaaaaha","aaaaaaaaaaaaaahb","aaaaaaaaaaaaaahc","aaaaaaaaaaaaaahd","aaaaaaaaaaaaaahe","aaaaaaaaaaaaaahf","aaaaaaaaaaaaaahg","aaaaaaaaaaaaaahh","aaaaaaaaaaaaaahi","aaaaaaaaaaaaaahj","aaaaaaaaaaaaaahk","aaaaaaaaaaaaaahl","aaaaaaaaaaaaaahm","aaaaaaaaaaaaaahn","aaaaaaaaaaaaaaho","aaaaaaaaaaaaaahp","aaaaaaaaaaaaaahq","aaaaaaaaaaaaaahr","aaaaaaaaaaaaaahs","aaaaaaaaaaaaaaht","aaaaaaaaaaaaaahu","aaaaaaaaaaaaaahv","aaaaaaaaaaaaaahw","aaaaaaaaaaaaaahx","aaaaaaaaaaaaaahy","aaaaaaaaaaaaaahz","aaaaaaaaaaaaaaia","aaaaaaaaaaaaaaib","aaaaaaaaaaaaaaic","aaaaaaaaaaaaaaid","aaaaaaaaaaaaaaie","aaaaaaaaaaaaaaif","aaaaaaaaaaaaaaig","aaaaaaaaaaaaaaih","aaaaaaaaaaaaaaii","aaaaaaaaaaaaaaij","aaaaaaaaaaaaaaik","aaaaaaaaaaaaaail","aaaaaaaaaaaaaaim","aaaaaaaaaaaaaain","aaaaaaaaaaaaaaio","aaaaaaaaaaaaaaip","aaaaaaaaaaaaaaiq","aaaaaaaaaaaaaair","aaaaaaaaaaaaaais","aaaaaaaaaaaaaait","aaaaaaaaaaaaaaiu","aaaaaaaaaaaaaaiv","aaaaaaaaaaaaaaiw","aaaaaaaaaaaaaaix","aaaaaaaaaaaaaaiy","aaaaaaaaaaaaaaiz","aaaaaaaaaaaaaaja","aaaaaaaaaaaaaajb","aaaaaaaaaaaaaajc","aaaaaaaaaaaaaajd","aaaaaaaaaaaaaaje","aaaaaaaaaaaaaajf","aaaaaaaaaaaaaajg","aaaaaaaaaaaaaajh","aaaaaaaaaaaaaaji","aaaaaaaaaaaaaajj","aaaaaaaaaaaaaajk","aaaaaaaaaaaaaajl","aaaaaaaaaaaaaajm","aaaaaaaaaaaaaajn","aaaaaaaaaaaaaajo","aaaaaaaaaaaaaajp","aaaaaaaaaaaaaajq","aaaaaaaaaaaaaajr","aaaaaaaaaaaaaajs","aaaaaaaaaaaaaajt","aaaaaaaaaaaaaaju","aaaaaaaaaaaaaajv","aaaaaaaaaaaaaajw","aaaaaaaaaaaaaajx","aaaaaaaaaaaaaajy","aaaaaaaaaaaaaajz","aaaaaaaaaaaaaaka","aaaaaaaaaaaaaakb","aaaaaaaaaaaaaakc","aaaaaaaaaaaaaakd","aaaaaaaaaaaaaake","aaaaaaaaaaaaaakf","aaaaaaaaaaaaaakg","aaaaaaaaaaaaaakh","aaaaaaaaaaaaaaki","aaaaaaaaaaaaaakj","aaaaaaaaaaaaaakk","aaaaaaaaaaaaaakl","aaaaaaaaaaaaaakm","aaaaaaaaaaaaaakn","aaaaaaaaaaaaaako","aaaaaaaaaaaaaakp","aaaaaaaaaaaaaakq","aaaaaaaaaaaaaakr","aaaaaaaaaaaaaaks","aaaaaaaaaaaaaakt","aaaaaaaaaaaaaaku","aaaaaaaaaaaaaakv","aaaaaaaaaaaaaakw","aaaaaaaaaaaaaakx","aaaaaaaaaaaaaaky","aaaaaaaaaaaaaakz","aaaaaaaaaaaaaala","aaaaaaaaaaaaaalb","aaaaaaaaaaaaaalc","aaaaaaaaaaaaaald","aaaaaaaaaaaaaale","aaaaaaaaaaaaaalf","aaaaaaaaaaaaaalg","aaaaaaaaaaaaaalh","aaaaaaaaaaaaaali","aaaaaaaaaaaaaalj","aaaaaaaaaaaaaalk","aaaaaaaaaaaaaall"};
//		char[][] test = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'b','c','d','e'},{'f','g','h','i'},{'j','k','l','m'} ,{'n','o','p','q'},{'r','s','t','u'},{'v','w','x','y'},{'z','z','z','z'}};
		
		String[] words = {"oath","pea","eat","rain"};
		char[][] test = {{'o','a','a','n'},
			  {'e','t','a','e'},
			  {'i','h','k','r'},
			  {'i','f','l','v'}};
		WordSearchII t = new WordSearchII();
		List<String>  r = t.findWords(test, words);
		for (int i = 0; i < r.size(); i++) {
			System.out.println(r.get(i));
		}	 
	}
}
