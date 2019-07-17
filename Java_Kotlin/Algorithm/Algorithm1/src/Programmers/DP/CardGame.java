package Programmers.DP;

public class CardGame {
    public static int run(int[] left, int[] right){
        int leftMax = 0;
        int answer = 0;
        for(int i=0; i<left.length; i++){
            if(leftMax<left[i]) leftMax = left[i];
        }
        for(int i=0; i<right.length; i++){
            if(leftMax>right[i]) answer += right[i];
        }
        return answer;
    }
}
