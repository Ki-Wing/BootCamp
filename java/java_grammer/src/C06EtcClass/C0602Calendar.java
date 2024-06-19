package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C0602Calendar {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // 특정한 값은 get 함수의 input 값으로 주어 원하는 날짜 정보를 출력할 수 있음
        System.out.println(cal.getTime());

        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)+1);  //0부터 시작해서 문제가 있다..
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));

        System.out.println(cal.get(Calendar.HOUR));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        System.out.println(cal.get(Calendar.MILLISECOND));

//        java.time 패키지 : Local~ class
//        날짜(LocalDate)-dadte, 시간(LocalTime), 날짜와 시간(LocalDateTime)-datetime
        LocalDate localdate = LocalDate.now();
        System.out.println(localdate.getYear());
        System.out.println(localdate.getMonth());
        System.out.println(localdate.getDayOfWeek());

        LocalTime localtime = LocalTime.now();
        System.out.println(localtime);
        System.out.println(localtime.getHour());
        System.out.println(localtime.getMinute());
        System.out.println(localtime.getSecond());

//        임의의로 특정시간을 만들어 내고 싶을때 : of메서드 사용
        LocalDate birthDay = LocalDate.of(2002, 2, 22);
        System.out.println(birthDay.getMonth());

        LocalTime birthTime = LocalTime.of(20,20,20);

        LocalDateTime birthDayTime = LocalDateTime.of(2002,2,22,20,20); //초는 빼도 ㄱㅊ
//        매개변수로 크로노필드 enum타입 사용해 프로그램 유연성 향상 가능
        System.out.println(birthDayTime.get(ChronoField.YEAR));
        System.out.println(birthDayTime.get(ChronoField.MONTH_OF_YEAR));
        // 0: 오전, 1: 오후
        System.out.println(birthDayTime.get(ChronoField.AMPM_OF_DAY));

        // 현재시간은 오전/오후 입니다.
        LocalTime newTime = LocalTime.now();
        System.out.println("현재 시간은 " + (newTime.get(ChronoField.AMPM_OF_DAY) == 1 ? " 오후 " : "오전")+ " 입니다.");

        myWatch(LocalDateTime.now(), ChronoField.YEAR);

    }

    static void myWatch(LocalDateTime localDateTime, ChronoField c){
        if(c==ChronoField.YEAR){
            System.out.println("연도는 " + localDateTime.get(c) + "입니다.");
        }else if (c == ChronoField.MONTH_OF_YEAR){
            System.out.println("월은 : " + localDateTime.get(c) + "입니다.");
        }else if ( c== ChronoField.AMPM_OF_DAY){
            if(localDateTime.get(c) ==0){
                System.out.println("오전입니다");
            }else{
                System.out.println("오후입니다");
            }
        }
    }

}
