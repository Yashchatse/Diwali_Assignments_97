package longest_String_day1;

public class LongestStringLength {
	public int findLongestStringLength(String [] strings) {
		if(strings == null || strings.length ==0) {
			return 0;
		}
		int maxLength = 0;
		
		for(String str : strings ) {
			if(str != null){
				maxLength= Math.max(maxLength, str.length());
			}
			
		}
		return maxLength;
	}

	public static void main(String[] args) {
		 LongestStringLength finder = new LongestStringLength();
	        String[] words = {"hello", "world", "java"};
	        int result = finder.findLongestStringLength(words);
	        System.out.println("Length of  longest String is: " + result);
	}

}
