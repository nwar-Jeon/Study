package method_3_5;

import java.util.Scanner;

public class Method {
    public static void pro9(){
        foo("안녕",1);
        foo("안녕하세요",1,2);
        foo("잘 있어");
    }

    static void foo(String str){
        System.out.println(str);
    }

    static void foo(String str, int n){
        System.out.println(str + " " + n);
    }

    static void foo(String str, int n, int n2){
        System.out.println(str + " " + n + " " + n2);
    }

    public static void pro10(){
        System.out.println("양의 정수를 입력하세요");
        int num = new Scanner(System.in).nextInt();
        if(isPrime(num)){
            System.out.println(num + "은(는) 소수입니다.");
        } else {
            System.out.println(num + "은(는) 소수가 아닙니다.");
        }
    }
    static boolean isPrime(int n){
        int[] arr = new int[n+1];
        for(int i=2; i<=n/2; i++){
            for(int j=2; j*i<=n; j++){
                arr[i*j]++;
            }
        }
        return arr[n]==0;
    }
}
