
import java.util.*;

public class CodingChallenges {
    public static void main(String[] args) {

//        System.out.println(tree.getHead());
        int x =8;
        HashSet<String> ok = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>();
        deque.add("a1");
        deque.add("a2");
//        boolean a = 0;
//        deque.in
//        binary(x);
//        prime(x);
//        System.out.println(isPrime(x));
        int[] a = {1,5,6,7,1,2};
        int[] b = {5,65,16,37,41,2};
//        findAbsoluteDiff(6,a,b);
//        System.out.println(deque);
        int[][] A = {{1,4,2,4},
                     {1,5,3,5},
                     {1,6,4,8}};
        int n = A[0].length;
        int m = A.length;
//        crossAddition(n,m,A);
        moverArr(A);
    }
    public static void moverArr(int[][] a){
        for(int i=0;i<a.length;i++){
            int row =i;
            int column =1;
            for(int j=0;j<a[i].length;j++){
                if(row==0){
//                    if(a[row][])
                }
                System.out.print(a[row][j]);

            }
            System.out.println();

        }

    }
    public static void binary(int n){
//        int counter =1;
//        for(int i=counter;i<x;i++){
//
//        }
        String a="";
        String b = "";
        while(n>=1){
            a+=(n%2);
            n=(int) Math.floor(n/2);
            System.out.println(a);

        }
        for (int i = a.length()-1; i >-1; i--) {
            b+=a.charAt(i);
        }

//        System.out.println(Integer.valueOf(b));
    }
    public static void prime(int n){
        List<Integer> p = new ArrayList<>();
        List<Integer> f = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i =1; i<=n; i++){
            int last = f.size()-1;
            if((i>1)&&((i!=2 && i%2==0)|(i!=3 && i%3==0)|(i!=5 && i%5==0)|(i!=7 && i%7==0))){
                if((f.get(last)+f.get(last-1))==i){
                    f.add(i);
                    set.add(i);
                }
            }else{
                if(i>1){
                    p.add(i);
                    set.add(i);
                    if((f.get(last)+f.get(last-1))==i){
                        f.add(i);
                        set.add(i);
                    }
                }else{
                    f.add(0);
                    set.add(0);
                    f.add(i);
                    set.add(i);
                    if(n>2){
                        f.add(2);
                        set.add(2);
                    }
                }
            }
        }
        System.out.println("real output: "+set.size());
    }
    public static boolean isPrime(int n){
        if(n==2){return true;}
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void findAbsoluteDiff(int N, int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int absoluteDiff1 = Math.abs(A[0]-B[N-1]);
        int absoluteDiff2 = Math.abs(B[0]-A[N-1]);
        if(absoluteDiff1>absoluteDiff2){
            System.out.println(absoluteDiff1);
        }else {
            System.out.println(absoluteDiff2);
        }


    }
    public static void crossAddition(int N, int M, int[][]A){
//        System.out.println(N);
        boolean valid = true;
        for(int i=0;i<M;i++){
            if(i==0 && A[i].length>0){
                System.out.print(A[0][0]+" ");
            }else if(A[i].length>0){
                for(int j=0;j<A[i].length;j++){
                    int row = i;
                    int column =j;
                    int sum = 0;
                    while(valid){
                        if((column<A[i].length)&&(row>=0)){
                            sum += A[row][column];
                            column++;
                            row--;
                        }else {
                            valid = false;
                        }
                    }
                    valid = true;
                    System.out.print(sum+" ");
                }
            }
        }
    }

}
