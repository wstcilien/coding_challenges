
import java.util.*;

public class CodingChallenges {
    public static void main(String[] args) {
        /*
            Complete
            this will print the binary form of the given integer
            Exp: 6 -> 110 , 8 ->1000 , 3 -> 11
            This has a time complexity of O(N)
         */
//        binary(3);
         /*
            Complete
            this will print the number prime numbers that are between 0 and the input number
            Exp: 20 -> 11 because [0, 1, 17, 2, 3, 19, 5, 7, 8, 11, 13] prime numbers.
            This has a time complexity of O(N).
         */
//        prime(20);

        int[] a = {1,5,6,7,1,2};
        int[] b = {5,65,16,37,41,2};
        /*
            Complete
            this will print the difference of the two numbers in each array will give you the maximum value
            Exp: {1,5,6,7,1,2};
                 {5,65,16,37,41,2}
                       ||
              This will give you 64 because 65 - 1 = 64 and this the highest difference you can find
            This has a time complexity of O(N).
         */
        findAbsoluteDiff(6,a,b);
        int[][] A = {{1,4,2,4},
                     {1,5,3,5},
                     {1,6,4,8}};
        /*
            Complete
            this will print an array with the cross addition of the give two-dimensional array
            Exp: {1,4,2,4}
                 {1,5,3,5}
                    ||
            Exp: {1,4,2,4}
                   / / /
                 {1,5,3,5}
                    ||
            This will give you {1,5,7,7,5}
            This has a time complexity of O(N)
         */
//        crossAddition(A);
        /*
            IC
            this will print the sum of the path that gives you the high number
            you can only move diagonally to the right or to the right
             /
            1 -   like the direction given
             \
             Exp:{1,4,2,4}
                 {1,5,4,5}
                 {1,6,3,8}
                    ||
            Exp: {1  4 2 4}
                 {1   5 4 5}
                       / \
                 {1 - 6 3 8}
                    ||
            This will give you {1,6,4,8} = 19
            this has a time complexity of O(N)
            Note: this problem will fail if you have a lot of duplicated values and
                  if the arrays in the two-dimensional array are not equal in length
         */
//        moverArr(A);
    }
    public static void binary(int n){
        String a="";
        String b = "";
        while(n>=1){
            a+=(n%2);
            n=(int) Math.floor(n/2);
//            System.out.println(a);

        }
        for (int i = a.length()-1; i >-1; i--) {
            b+=a.charAt(i);
        }

        System.out.println(Integer.valueOf(b));
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
        System.out.println("real output: "+set.size()+" "+set);
    }
    public static void findAbsoluteDiff(int N, int[] A, int[] B){
//        Arrays.sort(A);
//        Arrays.sort(B);
//        int absoluteDiff1 = Math.abs(A[0]-B[N-1]);
//        int absoluteDiff2 = Math.abs(B[0]-A[N-1]);
//        if(absoluteDiff1>absoluteDiff2){
//            System.out.println(absoluteDiff1);
//        }else {
//            System.out.println(absoluteDiff2);
//        }
        // This is an improved version which has a time complexity of O(N)
        int maxA = 0;
        int minA = A[0];
        int maxB,minB;
        maxB =0;
        minB = B[0];
        for (int i:A){
            if(i>maxA){
                maxA = i;
            }
            if(i<minA){
                minA = i;
            }
        }
        for (int i:B){
            if(i>maxB){
                maxB = i;
            }
            if(i<minB){
                minB = i;
            }
        }
        int sum1,sum2;
        sum1 = Math.abs(maxB-minA);
        sum2 = Math.abs(maxA - minB);
        if(sum1>sum2){
            System.out.println(sum1);
        }else{
            System.out.println(sum2);
        }


    }
    public static void crossAddition(int[][]A){
        HashMap<Integer,Integer> map = new HashMap<>();
        int counter = 0;
        for(int i=0;i<A.length;i++){
            for(int j:A[i]){
                if(map.get(counter) ==null){
                    map.put(counter,j);
                    counter++;
                }else{
                    int add = map.get(counter) + j;
                    map.put(counter,add);
                    counter++;
                }
            }
            counter = i+1;
        }

        System.out.println(map);
    }
    public static void moverArr(int[][] a){
//        {1,4,2,4}
//        {1,5,3,5}
//        {1,6,4,8}
        int sum = 0;
        int holder = 0;
        int length = a.length;
        for(int i=0;i<length;i++){
            int row =i;
            int column =0;
            System.out.print(a[row][column]);
            holder += a[row][column];

            for(int j=1;j<a[i].length;j++){ column = j;
                if(row==0){
                    if((a[row][j]>a[row+1][column])&& length>row) {
//                        System.out.print(a[row][column]);
                        holder += a[row][column];
                    }else{
                        row++;
//                        System.out.print(a[row][column]);
                        holder += a[row][column];

                    }
                }else if(row <(length-1)){
                    if((a[row][j]>a[row+1][column])&&(a[row][j]>a[row-1][column])) {
//                        System.out.print(a[row][column]);
                        holder += a[row][column];

                    }else if((a[row-1][j]>a[row][column])&&(a[row-1][j]>a[row+1][column])) {
                        row--;
//                        System.out.print(a[row][column]);
                        holder += a[row][column];

                    }else{
                        row++;
//                        System.out.print(a[row][column]);
                        holder += a[row][column];
                    }
                }else{
                    if(a[row][j]>a[row-1][column]) {
//                        System.out.print(a[row][column]);
                        holder += a[row][column];

                    }else{
                        row--;
//                        System.out.print(a[row][column]);
                        holder += a[row][column];

                    }
                }
                if(holder>sum){
                    sum = holder;
                    holder =0;
                }

            }
//            System.out.println();

        }
        System.out.println("Actual output: "+sum);

    }
}
