package C02ClassBasic;

public class C0205Constructor {
    public static void main(String[] args) {
        Calendar calendar = new Calendar("2024","06","12");
        System.out.println(calendar.getYear() + "년 " + calendar.getMonth() + "월 " + calendar.getDay() + "일입니다.");
        }
    }

    class Calendar {
        private String year;
        private String month;
        private String day;

        // 생성자는 클래스명과 동일해야하고 초기화하고싶은 변수명 나열
        Calendar(String year, String month, String day){
            this.year = year;
            this.month = month;
            this.day = day;

        }

        // 메서드 오버로딩(가능)
//        같은 class 내 다른 생성자 호출시 this() 사용
        Calendar(String year, String month){
            this(year, month, null);
        }
        Calendar(){

        }






        public String getYear() {
            return year;
        }

        public String getMonth() {
            return month;
        }

        public String getDay() {
            return day;
        }

    }





