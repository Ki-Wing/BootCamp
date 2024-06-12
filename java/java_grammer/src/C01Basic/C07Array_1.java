package C01Basic;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class C07Array_1 {
    public static void main(String[] args) {
        // 정렬 알고리즘
        // 1) 선택정렬
//        int[] arr = {17, 30, 19, 25, 12};
//        for (int i=0; i < arr.length-1; i++) {    // 첫바퀴 전부 검사
//            for (int j = i+1; j < arr.length; j++) {    // i보다 작은값 자리 change
//                if (arr[i] > arr[j]) {
//                    int tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//

// 숫자 조합의 합 : 모두 각기 다른 숫자의 배열이 있을때
// 만들어질 수 있는 2개의 조합의 합을 출력

//                int[] intArr = {10,20,30,40,50,60};
//                for(int i=0;i< intArr.length-1;i++){
//                    for(int j=i+1;j< intArr.length;j++){
//                        System.out.println(intArr[i] + " + " + intArr[j] + " = " + (intArr[i]+intArr[j]));
//                    }
//        }


//배열의 복사 : copyOf(원본 배열 , length)
//            copyOfRange(원본 배열, start, end)
//        int[] arr = {10, 20, 30, 40, 50};
//        int[] newArr1 = Arrays.copyOf(arr, 10);    //복사 배상의 start 0
//        System.out.println(Arrays.toString(newArr1));
//
//        int[] newArr2 = Arrays.copyOfRange(arr, 1, 3);    //복사 배상의 start 0
//        System.out.println(Arrays.toString(newArr2));


//배열의 중복제거
//        int[] tmp = {10, 10, 5, 7, 40, 40, 10, 10};
//        int[] result = new int[tmp.length];
//        int j = 0;
//        for (int i = 0; i < tmp.length - 1; i++) {
//            if (tmp[i] != tmp[i + 1]) {
//                result[j++] = tmp[i];
//            }
//        }
//        int[] re = Arrays.copyOf(result, j);
//
//        System.out.println(Arrays.toString(tmp));
//        System.out.println(Arrays.toString(re));


//        프로그래머스 두개 뽑아서 더하기


//        배열의 검색
//        int[] arr1 = {5,3,1,8,7};
//        int index = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            if( arr1[i] == 8){
//                index = i;
//            }
//        }


//        이진검색(Binary Search)
//        int[] arr = {1,3,6,8,9,11,15};   // 사전에 오름차순 정렬이 되어 있어야 이진검색 가능
//        System.out.println(Arrays.binarySearch(arr,8));


//        배열간 비교
//        int[] arr1 = {10,20,30};
//        int[] arr2 = {10,20,30};
//        System.out.println(Arrays.equals(arr1, arr2));


////        2차원 배열 선언과 할당
//        int[][] arr = new int[2][3];
//        arr[0][1] = 0;

//        리터럴 방식으로 할당 / 출력
//        int[][] arr1 = {{1,2,3},{4,5,6}};
//        System.out.println(Arrays.toString(arr1));   //메모리 안에 메모리가 들어간 구조이기 때문에 메모리 주소가 나옴
//        System.out.println(Arrays.deepToString(arr1));    //새부 데이터 출력


//        2차원 가변배열 선언 후 할당
//        int[][] arr = new int[2][];
//        arr[0] = new int[3];
//        arr[0] = new int[4];
//

//        가변배열 리터럴 방식
//        int[][] arr1 = {{10,20},{10,20,30}};


//[3],[4] 사이즈 배열 선언 후 1~12
//        int[][] arr = new int[3][4];
//        int cnt=1;
//        for(int i=0; i<arr.length; i++){      //arr의 길이 3 나옴
//            for(int j=0; j<arr[i].length; j++){
//                arr[i][j] = cnt++;
//            }
//        }
//        System.out.println(Arrays.deepToString(arr));


//실습) 행의 길이(5) => {{x},{x,x}, {x,x,x}, ...} 각 배열마다
        int numRows = 50;
        int[][] arr = new int[numRows][];

        int cnt = 1;

        for (int i = 0; i < numRows; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = cnt++;
            }
        }
        System.out.println(Arrays.deepToString(arr));



    }
}



