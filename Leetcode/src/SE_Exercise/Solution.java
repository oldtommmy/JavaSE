package SE_Exercise;

class Solution {
    public int firstUniqChar(String s) {

        int i,j;
        int[] isRepeated = new int[26];
        if (s.length()==1) return 0;
        for (i = 0; i < s.length()-1; i++) {
            int flag = 1;
            if (isRepeated[s.charAt(i)-'a']==1) continue;
            for (j = i+1; j < s.length(); j++) { //"aabb"
                if (s.charAt(j)==s.charAt(i)){
                    isRepeated[s.charAt(j)-'a'] = 1;
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) return i;
        }
        if (isRepeated[s.charAt(i)-'a']!=1) return i;
        return -1;
    }
}