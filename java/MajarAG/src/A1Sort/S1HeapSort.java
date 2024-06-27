
package A1Sort;
import java.util.*;

public class S1HeapSort {
    public static void main(String args[]) {
        int arr[] = {7, 6, 2, 0, 3, 5, 1, 3};
        dfs(arr);
        System.out.println(Arrays.toString(arr));


        int arr2[] = {7, 6, 2, 0, 3, 5, 1, 3};
        Queue<Integer> pq = new PriorityQueue<>();
        for ( int a : arr2){
            pq.add(a); // 힙 구조 정렬됨(add : 상향식 heapify, poll : 하향식 heapify)
        }
        System.out.println(pq);
    }

    static void dfs(int arr[]) {
        int n = arr.length;
        // 최초힙 구성
        for (int i = n/2-1; i>= 0; i--) {
            heapify(arr, n-1, i);
        }

        for (int i = n-1; i>0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }


    static void heapify(int arr[], int n, int start) {
        int left = start*2 + 1;
        int right = start*2 + 2;

        // 강사님 코드
//         if(left >= arr.length) return;
//         if(right >= arr.length) {
//             int tmp = arr[start];
//             arr[start] = arr[left];
//             arr[left] = tmp;
//             heapify(arr, n, left);
//        }else{
//             int index = 0;
//             if(arr[start] > arr[left] || arr[start] > arr[right]){
//                 if(arr[left] > arr[right]){
//                     index = right;
//                 }else{
//                     index = left;
//                 }
//                 int tmp = arr[start];
//                 arr[start] = arr[index];
//                 arr[index] = tmp;
//                 heapify(arr, n, index);
//
//             }
//         }
        int index = start;

        if (left<n && arr[left] > arr[start])
            index=left;

        if (right<n && arr[right] > arr[index])
            index=right;

        if (index != start) {
            int tmp = arr[start];
            arr[start] = arr[index];
            arr[index] = tmp;
            heapify(arr, n, index);
        }
    }
}
