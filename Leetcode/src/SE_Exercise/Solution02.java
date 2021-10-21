package SE_Exercise;

class Solution02 {
    public int reverse(int x) {
        long re = 0;
        while (x!=0){
            re = re*10+(x%10);
            re/=10;
        }
        if (re>=Integer.MAX_VALUE||re<=Integer.MIN_VALUE){
            return 0;
        }
        return (int)re;
    }
}
