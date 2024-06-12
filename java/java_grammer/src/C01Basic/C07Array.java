package C01Basic;

import java.lang.*;
import java.util.*;
import java.io.*;

public class C07Array {
    public static void main(String[] args) {

//        표현식1 : 리터럴방식
//        in[] intArr1 = {1, 2, 3, 4, 5};

//        표현식2
//        int[] intArr2 = new int[5];
//        intArr2[0] = 1;
//        intArr2[1] = 2;
//        intArr2[2] = 3;
//        intArr2[3] = 4;
//        System.out.println(intArr2[4]); //0으로 초기화
//        for(int i=0; i<intArr2.length; i++){
//            System.out.println(intArr2[i]);
//        }
//        for(int i : intArr2){
//            System.out.println(i);
//        }
//
//        // 표현식3
//        int[] int_arr3 = new int[]{1,2,3,4};
//
//        // 표현식 4 : 불가 -> 배열의 길이는 사전에 지정되어야함
//        // int[] int_arr4 = new int[]; 길이 지정 필수
//

//        int[] int_arr4 = new int[]{85,65,90};
//        int sum = 0;
//        for(int i = 0; i<int_arr4.length; i++){
//            sum += int_arr4[i];
//        }
//        System.out.println(sum/int_arr4.length);
//

//        String[] stArr2 = new String[5];
//        배열에 값 한꺼번에 세팅
//        Arrays.fill(stArr2, "");
//        System.out.println(stArr2[3]);


//        최대값, 최소값
//        int[] arr = { 10, 20, 30, 12, 8, 17};
//        int max = arr[0]; //int max = Integer.MIN_VALUE로도 가능
//        int min = arr[0]; //int max = Integer.MAX_VALUE로도 가능
//        for(int a : arr){
//            if(max<arr[i]){
//                max=arr[i];
//            }if (min>arr[i]) {
//                min=arr[i];
//            }
//        }
//        System.out.println(max);
//        System.out.println(min);
//

//        배열 자리바꾸기
//        int[] arr1 = {10,20};
//        int tmp = arr1[0];
//        arr1[0] = arr1[1];
//        arr1[1] = tmp;
//        System.out.println(Arrays.toString(arr1));
//

//        배열 뒤집기
//        for (int i = 0; i<arr3.length; i++ ){
//            re2[arr3.length-1-i] = arr3[i];
//        }
//        System.out.println(Arrays.toString(re2));
//        System.out.println();
//        System.out.println(Arrays.toString(arr3));
//

//        숫자 뒤집기
//        int num=1234;
//       문자열과 관련된 풀이로 풀기
//        String stNum = Integer.toString(num);
//        StringBuilder sb = new StringBuilder();
//        int count = stNum.length()-1;
//        for(int i=0; i<stNum.length(); i++){
//            sb.append(stNum.charAt(count-i));
//        }
//        System.out.println(sb);
//
//        // 에러
////        String[] arr_st =  new String[5];
////        arr_st[0] = "java";
////        arr_st[1] = "c++";
////        arr_st[2] = "python";
////        for (int i = 0; i < arr_st.length; i++) {
////            System.out.println(arr_st[i].length());
////
////        }
//
//        // 정렬 sort 사용
//        int[] Arr = {5,1,2,7,3,1,2};
//        Arrays.sort(Arr);
//        System.out.println(Arrays.toString(Arr));
//

////        정렬
//        int[] arr = {5,1,2,7,3,1,2};
//        Arrays.sort(arr); //오름차순 정렬이 기본.
//        System.out.println(Arrays.toString(arr));

////        문자정렬
////        아스키코드 기준으로 => 대문자가 소문자보다 아스키코드가 낮다.
//        String [] fruits = {"banana", "apple", "cherry", "Apple"};
//        Arrays.sort(fruits);
//        System.out.println(Arrays.toString(fruits));
//
////        문자열의 index순서로 비교
//        String [] fruits2 = {"apple1", "apple11", "apple2"}; //2보다 11이 먼저 나옴(앞자리부터 비교하기 때문)
//        Arrays.sort(fruits2);

//        내림차순
//        String [] st_arr = {"hello", "hi", "bye", "goodmorning"};
//        Arrays.sort(st_arr, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(st_arr));
//
//        기본형타입은 Comparator로 처리 불가
//        int[] intArr = {5,1,2,7,3,1,2};
//        Arrays.sort(intArr);


//         Stream Api, lambda를 활용한 내림차순 정렬;
//        int[] Arr2 = {5,1,2,7,3,1,2};
//        int[] new_Arr2 = Arrays.stream(Arr2)    // Stream 객체 생성
//                .boxed() // Integer 형 변환한 Stream 객체 생성
//                .sorted(Comparator.reverseOrder())  // 내림차순 정렬
//                .mapToInt(a->a) // Integer -> int 형변환
//                .toArray();



//        [프로그래머스 k번째 수]
//방법1)
//        int[] array = {1, 5, 2, 6, 3, 7, 4};
//        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
//        int[] answer = new int[commands.length];
//        for(int i = 0; i<commands.length;i++){
//            int start = commands[i][0] -1;
//            int end = commands[i][1];
//            int value= commands[i][2]-1;
//            int[] temp = new int[end-start];
//            int cnt =0;
//            for(int j=start;j<end;j++){
//                temp[cnt] = array[j];
//                cnt++;
//            }
//            Array.sort[temp];
//            answer[i] = temp[value];
//        }


//방법2)
//
//        class Solution {
//            public int[] solution(int[] array, int[][] commands) {
//                int[] answer = new int[commands.length];
//
//                for (int i = 0; i < commands.length; i++) {
//                    int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
//
//                    Arrays.sort(temp);
//                    answer[i] = temp[commands[i][2] - 1];
//                }
//                return answer;
//            }
//        }


    }
}