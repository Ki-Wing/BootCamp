package C01Basic;

import java.util.*;

public class C06String {
    public static void main(String[] args) {

//        String 변수 생성 방법
//        String st1 = new String("hi");   -- 객체생성 방식
//        String st2 = "hi";   --리터럴 방식(추천)


//참조자료형: 기본 자료형을 제외한 모든 자료형
//WrapperClass : 가본형 타입을 Wrapping한 클래스
//int와 Integer간의 형변환
//            int a = 10;
//            Integer b = new Integer(20);
////            오토언박싱 : Integer -> int 형변환
//            int c = b;
////            오토박싱
//            Integer d = a;

//string과 int의 형변환
//        int a = 10;
////            int -> String
//        String st1 =  Integer.toString(a);
//        String st2 = String.valueOf(a);
//
////        String -> int
//        int b = Integer.parseInt(st1);

//        참조자료형에 원시자료형을 담을때는 wrapper class를 써야함
//        List<Integer> list1 = new ArrayList<>();
////        알아서 오토박싱 되는거임
//        list1.add(10);



////        String 변수 생성방법
//        String st1 = new String( "hello");
////        리터럴방식 : 권장하는 방식
////        문자열 pool 통해 성능향상
//        String st2 = "hello";
//        String st3 = new String("hello");
//        String st4 = "hello";
//        System.out.println(st1==st3); //false
//        System.out.println(st2==st4); //ture

//        String문자열 비교는 equals(그냥 외워.)
//        System.out.println(st1.equals(st3));
//        System.out.println(st2.equals(st4));
//        System.out.println(st3.equals(st4));
//
//        System.out.println("hello".equalsIgnoreCase("hellO")); //true
//
////        문자열 길이 : length(); (띄어쓰기까지 포함)
//        String st1 = "hello java java";
//        System.out.println(st1.length());
//
////        indexOf : 특정 문자열의 위치 반환, 가장 먼저 나오는 문자열의 위치
//        int index1 = st1.indexOf("java");
//        System.out.println(index1);
////        마지막 문자열의 index위치
//        System.out.println(st1.lastIndexOf("java"));
//
////        contains : 특정 문자열이 있는지 여부를 boolean으로 리턴
//        System.out.println(st1.contains("hello"));
//        System.out.println(st1.contains("world"));

//        chartAt : 특정 index의 문자(char)값을 리턴
//        String  st = "abcdefabcdef";
//        char ch1 = st.charAt(1);
//        System.out.println(ch1);
////        위의 문자열에 a의 개수가 몇개인지 count / for문과 charAt, langth() 사용
//        int count = 0;
//        for(int i=0; i<st.length(); i++){
//            if(st.charAt(i)=='a'){
//                count++;
//            }
//        }
//        System.out.println(count);

////        toCharArray() : String문자열을 char배열로 리턴
//        System.out.println(Arrays.toString(st.toCharArray()));
////        toCharArray를 활용해서 a가 몇개인지 count, 향상된 for문 사용
//        char[] arr = st.toCharArray();
//        int count1 = 0;
//        for(char i : arr){
//            if(i=='a'){
//                count1++;
//            }
//        }
//        System.out.println(count1);

////        문자열 더하기 : +=
//        String st1 = "hello";
//        st1 += "world";

////        프로그래머스 - 특정 문자 제거하기
//
//        String my_string="abcdef";
//        String letter="f";
//        String answer= "";
////        자동형변환
//        for(int i=0; i<my_string.length(); i++){
//            if(my_string.charAt(i)!=letter.charAt(0)){
//                answer += my_string.charAt(i);
//            }
//        }
//        System.out.println(answer);

////          substring사용
//        for(int i=0; i<my_string.length(); i++){
//            if(!my_string.substring(i,i+1).equals(letter)){
//                answer += my_string.substring(i,i+1);
//            }
//        }
//        System.out.println(answer);

////        substring(a,b) : a이상 b미만의 index의 문자를 잘라 리턴
//        String st1 = "hello world";
//        System.out.println(st1.substring(0,5));
//        System.out.println(st1.substring(6,st1.length()));

////        프로그래머스 - 가운데 글자 가져오기
//        String s = "abcde";
//        String answer = "";
//        answer = s.substring((s.length()-1)/2, s.length()/2 + 1);
//        System.out.println(answer);


////        trim, strip : 문자열 양쪽 끝의 공백 제거 / trim(초기모델), strip(후기모델)
//        String trimSt1 = "   hello world      ";
////        String trimSt2 = trimSt1.trim();
//        String trimSt2 = trimSt1.strip();
//        System.out.println(trimSt1);
//        System.out.println(trimSt2);

////        toUpperCase : 대문자로 변환, toLowerCase : 소문자로 변환
//        String s1 = "Hello";
//        String s2 = s1.toUpperCase();
//        String s3 = s1.toLowerCase();
//        System.out.println(s3);

////        char -> String 형변환
//        char ch1 = 'a';
//        String st1 = Character.toString(ch1);
//        System.out.println(st1);

////        repalce(a,b) : a문자열을 b문자열로 대체
//        String st1 = "hello world";
//        String st2 = st1.replace("world", "java");
//        System.out.println(st2);

//        replaceAll(a,b) : replace와 동일한데, 정규표현식을 쓸 수 있음.
//        String st1 = "01abc123한글123"; //숫자, 알파벳, 한글 등이 섞여 있을때
//        String answer = "";
////        for문 활용해서 알파벳(소문자) 제거 answer return
//        for(int i=0; i<st1.length(); i++){
//            if(st1.charAt(i) < 'a' || st1.charAt(i) > 'z'){
//                answer += st1.charAt(i);
//            }
//        }
//        System.out.println(answer);

//        replaceAll과 정규표현식 활용
//        String st1 = "01abc123ABC한글123";
////        [a-z]+ : 1개 이상의 소문자 알파벳 표현하는 정규표현식
////        [A-Za-z]+ : 대소문자 포함
////        [가-힣]+ : 한글
////        [0-9]+ : 숫자
//        String answer = st1.replaceAll("[A-Za-z]+", "");
//        System.out.println(answer);

//        String의 matches와 Pattern.matches()
//        String test = "helloA";
//        System.out.println(test.matches("[A-Za-z]+"));
//
//        boolean b1 = Pattern.matches("[0-9]+", "12345");
//        System.out.println(b1);

////        ^:정규표현식의 시작, $: 정규표현식의 끝, *:빈값포함
//        boolean b2 = Pattern.matches("[A-Za-z]*$", "");
//        System.out.println(b2);

//        프로그래머스 - 문자열 다루기
//        String s = "1234";
//        boolean answer = Pattern.matches("[1-9]+", s);
//        System.out.println(answer);
//        boolean answer = false;
//        if((s.length()==4 || s.length()==6)&&s.matches("[0-9]+")){
//            answer = true;
//        }

////        전화번호 패턴 검증
//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            String number = sc.nextLine();
//            if (Pattern.matches("\\d{3}-\\d{4}-\\d{4}", number)) {
//                System.out.println("올바르게 입력하셨습니다.");
//            } else {
//                System.out.println("틀린 형식의 전화번호입니다.");
//            }
//        }

////        이메일 검증 : 소문자알파벳+숫자@소문자알파벳.com
//        String email = "abc123@naver.com";
//        boolean b3 = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
//        System.out.println(b3);

//        split : 특정문자를 기준으로 문자열을 자르는것. 문자열 배열을 return
//        String a = "a:b:c:d";
//        String[] a_arr = a.split(":");
//        System.out.println(Arrays.toString(a_arr));
//        String b = "a b c  d";
////        \s : 공백
//        String[] b_arr = b.split("\\s+");
//        System.out.println(Arrays.toString(b_arr));

////        isEmpty와 null(자료타입)
//        String st1 = null;
//        String st2 = ""; //isEmpty값
////        equal관계가 아님
//        System.out.println(st1==st2);
////        문제발생x
//        System.out.println(st2.isEmpty()); //true
////        문제발생o : NullPointer Exception예외 발생
//        System.out.println(st1.isEmpty()); //false

////        join : String[]을 하나의 String 만드는 메서드
//        String[] arr = {"java", "python", "C++", "javascript"};
//        String st = String.join("", arr);
//        System.out.println(st);

////        StringBuffer
//        StringBuilder sb1 = new StringBuilder("hello");
////        append : 문자열 가장 뒤에 다른 문자열을 더하는것.
//        sb1.append(" java");
//        sb1.append(" world");
//        String answer = sb1.toString();
//        sb1.insert(5, " python");
//        sb1.delete(17, sb1.length());
//
//        System.out.println(sb1);


////        StringBuilder
////        String += 보다 StringBuffer 보다 StringBuilder가 빠르다.

////        StringBuilder는 스레드 safe X
//        StringBuilder sb2 = new StringBuilder();
//        sb2.append("hello");
//        sb2.append("\n"); //줄바꿈
//        sb2.append("world");
//
//        System.out.println(sb2);

////        StringBuilder를 사용해서
//        String my_string = "hello";
//        int n = 3; //hhheeellllllooo;
//        StringBuilder sb3 = new StringBuilder();
//        for(int i=0; i<my_string.length(); i++){
//            char temp = my_string.charAt(i);
//            for(int j=0; j<n; j++){
//                sb3.append(temp);
//            }
//        }
//        System.out.println(sb3);

////        프로그래머스 - 문자열 밀기
//        String A = "hello";
//        String B = "ohell";
//        StringBuilder sb = new StringBuilder();
//        int answer = 0;
//        while (!sb.equals(B)){
//            sb.insert(0, A.substring(A.length()-1, A.length()));
//            sb.delete(A.length(), A.length()+1);
//            answer++;
//            if(answer>A.length()){
//                answer = -1;
//                break;
//            }
//            }


    }
}
