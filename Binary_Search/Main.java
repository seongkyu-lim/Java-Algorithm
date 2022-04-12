package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException{

        input();
        int answer = binary_search(arr, 0, arr.length-1, 2);
        System.out.println(answer);
    }

    private static int binary_search(int[] A, int left, int right, int target) {

        while(left<=right){
            int mid = (left+right)/2;
            
            if(A[mid]<target) right = mid-1;
            if(A[mid]>target) left = mid+1;
            else return mid;
        }

        return -1;


    }

    private static void input() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }
    
}
