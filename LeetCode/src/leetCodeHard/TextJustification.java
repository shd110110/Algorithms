package leetCodeHard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 * 2015年6月30日
 */
public class TextJustification {
    public List<String> fullJustify2(String[] words, int maxWidth) {
    	List<String> resultList = new ArrayList<>();
    	if (words.length == 0) {
			return resultList;
		} 
        int i = 0;
        while (i < words.length){
        	StringBuilder stringBuilder = new StringBuilder();
        	int trialLength = 0;
        	int actualLength = 0;
        	int end = i;
        	trialLength = trialLength + words[end].length();
    		actualLength = actualLength + words[end].length();
    		end++;
        	while (end < words.length && trialLength+1+words[end].length() <= maxWidth){
        		trialLength = trialLength + 1 + words[end].length();
        		actualLength = actualLength + words[end].length();
        		end++;
        	} 
        	
        	if (end < words.length) {
				end--;
				int spacesToAdd = maxWidth - actualLength;
//				System.out.println(spacesToAdd);
//				System.out.println(end);
//				System.out.println(i);
				int gaps = end - i;
				if (gaps > 0) {
					int number = spacesToAdd/(end - i);
					
					int rest = spacesToAdd%(end - i);
					for (int j = i; j < end; j++) { 
						stringBuilder.append(words[j]);
						if (j < i+rest) {
							for (int j2 = 0; j2 < number+1; j2++) {
								stringBuilder.append(" ");
							}
						}else {
							for (int j2 = 0; j2 < number; j2++) {
								stringBuilder.append(" ");
							}
						}
					}
					stringBuilder.append(words[end]);
				}else {
					stringBuilder.append(words[end]);
					for (int j = stringBuilder.length(); j < maxWidth; j++) {
						stringBuilder.append(" ");
					}
				}
			}else {
				end--; 
				for (int j = i; j < end; j++) {
					stringBuilder.append(words[j]); 			
					stringBuilder.append(" ");
				}
				stringBuilder.append(words[end]);
				for (int j = stringBuilder.length(); j < maxWidth; j++) {
					stringBuilder.append(" ");
				}
			}
        	resultList.add(stringBuilder.toString());
        	i = end+1;
        }
        return resultList;
    }
	
    // Second Round
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res = new ArrayList<>(); 
        if (words.length == 0) {
        	return res;
        }
        if (words[0].length() == 0) {
        	 StringBuilder sb = new StringBuilder();
        	 for (int i = 0; i < maxWidth; i++) {
        		 sb.append(" ");
        	 }
        	 res.add(sb.toString());
        	 return res;
        }
        
        int index = 0;
        int lengthPerLine = 0;
        int actualLenth = 0;
        for (int i = 0; i < words.length; i++) {
//        	System.out.println(words[i]);
        	if (words[i].length() == 0) {
				continue;
			}
            if (lengthPerLine == 0) { 
                lengthPerLine += words[i].length();
                actualLenth += words[i].length();
                index = i;
                if (lengthPerLine == maxWidth) {
                	
                    res.add(words[i]);
                    lengthPerLine = 0;
                	actualLenth = 0;
                    index = i + 1;
                }
            } else {
                if (lengthPerLine + 1 + words[i].length() < maxWidth) { 
                    lengthPerLine += (1 + words[i].length());
                    actualLenth += words[i].length();
                } else if (lengthPerLine + 1 + words[i].length() == maxWidth) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[index]);
                    for (int j = index + 1; j <= i; j++) {
                        sb.append(" ").append(words[j]);
                    } 
                    res.add(sb.toString()); 
                    lengthPerLine = 0;
                    actualLenth = 0; 
                } else {
                    int spacesToAdd = maxWidth - actualLenth;
                    int stringsInALine = i - index;
                   
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[index]);
                    
                    if (stringsInALine == 1) {
                    	for (int j = 0; j < spacesToAdd; j++) {
							sb.append(" ");
						}
                    } else {
                    	int left = spacesToAdd % (stringsInALine - 1);
                        int spaceNum = spacesToAdd / (stringsInALine - 1);
                        for (int j = index + 1; j < i; j++) {
                            if (j - index <= left) {
                                for (int k = 0; k < spaceNum + 1; k++) {
                                    sb.append(" ");
                                }
                            } else {
                                for (int k = 0; k < spaceNum; k++) {
                                    sb.append(" ");
                                }
                            }
                            sb.append(words[j]);
                        }
					} 
                    
                    res.add(sb.toString()); 
                    lengthPerLine = 0;
                    actualLenth = 0;
                    index = i;
                    lengthPerLine = words[i].length();
                    actualLenth = words[i].length();
                }
            }
        }
        if (lengthPerLine != 0) { 
           
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            for (int j = index + 1; j < words.length; j++) {
                sb.append(" "); 
                sb.append(words[j]);
            }
            int toAdd = maxWidth - sb.length();
            for (int j = 0; j < toAdd; j++) {
                sb.append(" ");
            }
            res.add(sb.toString()); 
		} 
        return res;
    }
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification t = new TextJustification();
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] words = {"Listen","to","   ","speak","to","a","few."};
//		String[] words = {" ", " "};
		List<String> result = t.fullJustify(words, 6);
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i) + " " + result.get(i).length());
		}
	}

}
