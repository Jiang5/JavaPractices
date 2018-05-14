import java.util.Arrays;

public class StringPractice {
	
	private boolean isUnique(String s) {
		if(s.length() > 128) {
			return false;
		}
		boolean[] char_table = new boolean[128];
		Arrays.fill(char_table, false);
		for(int i = 0; i < s.length(); i++) {
			int ASCii = s.charAt(i);
			if(char_table[ASCii] == true) {
				return false;
			}
			else {
				char_table[ASCii] = true;
			}
		}
		return true;
	}
	
	private boolean checkPermutation(String s1, String s2) {

	    if (s1.length() != s2.length())
	      return false;

	    char[] a = s1.toCharArray();
	    char[] b = s2.toCharArray();

	    Arrays.sort(a);
	    Arrays.sort(b);

	    return Arrays.equals(a, b);
	}
	
	private String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			count++;
			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				sb.append(s.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		String result = sb.toString();
		if(result.length() > s.length()) {
			return s;
		}
		return result;
	}
	
	private boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }
    
    


	public static void main(String[] args) {

		StringPractice sp = new StringPractice();
		System.out.println(sp.isUnique("qwe"));
		System.out.println(sp.isUnique("qwee"));
		System.out.println(sp.checkPermutation("qwe", "qwe"));
		System.out.println(sp.checkPermutation("qwe", "qqw"));
		System.out.println(sp.compressString("qweeee"));
		System.out.println(sp.compressString("qwe"));
		System.out.println(sp.isRotation("qwe", "eqw"));
	}

}
