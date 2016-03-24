package leetCodeEasy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack; 

public class Solution {
    static HashMap<Character, Integer> bitPatterns = new HashMap<Character, Integer>();
    static HashMap<Integer, Integer> sequences = new HashMap<Integer, Integer>();
    static String[] strPatterns;
    public static List<String> findRepeatedDnaSequences(String s) {

        bitPatterns.put('A', 0); //pattern: 00
        bitPatterns.put('C', 1); //pattern: 01
        bitPatterns.put('G', 2); //pattern: 10
        bitPatterns.put('T', 3); //pattern: 11

        //Save the bitpatterns the other way arround such that we can rebuild the string later.
        strPatterns = new String[bitPatterns.size()];//size = 4
        for(Character character : bitPatterns.keySet()){
            strPatterns[bitPatterns.get(character)] = String.valueOf(character);//["A","C","G","T"]
        }


        //BitMask to hide everything larger than 20 bits
        int bitMask = ((1 << 20)-1) ^ 2; // 00000000000011111111111111111100.
        
        int currentSequence = 0;

        //load first sequence
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //shift the current sequence to the left and clear the right most two bits. This is done by &-ing the bitmask with the current sequence
            currentSequence = bitMask & (currentSequence << 2);
            currentSequence |= bitPatterns.get(c);//add the current character to the sequence
            if(i>=9){
                //Count or add the sequence
                if(sequences.get(currentSequence) != null){
                    Integer count = sequences.get(currentSequence)+1;
                    sequences.put(currentSequence,count);
                }else{
                    sequences.put(currentSequence, 1);
                }
            }
        }
        //Get the sequences that occur more than 1 time
        LinkedList<String> result = new LinkedList<String>();
        for(Integer k : sequences.keySet()){
            Integer v = sequences.get(k);
            if(v>1){
                result.add(convertToString(k));
            }
        }
        return result;
    }

    public static String convertToString(int k){
        StringBuilder sb = new StringBuilder();
        int bitMask = 3;
        for(int i = 0; i<10;i++){
            sb.append(strPatterns[bitMask & k]); //Get the rightmost two bits and convert it to a letter
            k = k >>> 2;
        }
        sb.reverse();
        return sb.toString();
    }
    public static int hammingWeight(int n) {
    	int result = 0;
    	if (n<0) {
			result++;
			n=n+2147483647+1;
		}
        while(n>0){
        	if (n%2==1) {
				result++;
			}
        	n/=2;
        }
        return result;
    }
    public static int reverseBits(int n) {
    	int result = 0;
    	Stack<Integer> temp = new Stack<Integer>();
    	if (n<0) {
			temp.push(1);
			n = n + 2147483647+1;
		}else {
			temp.push(0);
		}
    	for (int i = 30; i >=0; i--) {
			if ((n>>i)%2 == 1) {
				temp.push(1);
			}else {
				temp.push(0);
			}
		}
    	int t = 0;
    	for (int i = 0; i < 32; i++) {
    		t = temp.pop();
			result = result*2+t;
		}
    	return result;
    }
    public static void main(String[] args){
    	List<String> re = findRepeatedDnaSequences("AAAAAAAAAAAAAAAAAAAAAAAA");
    	for (int i = 0; i < re.size(); i++) {
			System.out.println(re.get(i));
		}
    	System.out.println(Integer.MAX_VALUE+3);
    	System.out.println(hammingWeight(-2147483648));
    	int a = Integer.MIN_VALUE*(-1);
    	System.out.println(a);
    	
    	System.out.println(reverseBits(43261596));
    }
}
