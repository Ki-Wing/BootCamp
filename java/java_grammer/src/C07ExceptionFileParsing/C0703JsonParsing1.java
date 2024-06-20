package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class C0703JsonParsing1 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path filePath = Paths.get("src/C07ExceptionFileParsing/test_data1.json");
        String jsonString = Files.readString(filePath);
//        System.out.println(jsonString);

//        readTree : 트리구조의 JsonNode로 변환
//        트리구조 장점 : 유연함
        JsonNode data1 = objectMapper.readTree(jsonString);
        Map<String, String> studentMap = new HashMap<>();
        studentMap.put("id", data1.get("id").asText());
        studentMap.put("name", data1.get("name").asText());
        studentMap.put("classNumber", data1.get("classNumber").asText());
        studentMap.put("city", data1.get("city").asText());
        System.out.println(studentMap);


//        readValue : 객체로 바로 변환
        Map<String, String> studenMap2 = objectMapper.readValue(jsonString, Map.class);  //Map이라는 class를 쓰겠따.
        System.out.println(studenMap2);


//        Student 객체 생성 및 toString 오버라이딩
        Student student3 =  objectMapper.readValue(jsonString, Student.class);
        System.out.println(student3);
    }
}


// objectmapper는 getter또는 setter 메서드명을 통해 필드값을 유추한다
// 실제 값의 setting은 reflection이라는 기술을 통해 변수값에 할당한다
class Student{
    private int id;
    private String name;
    private String classNumber;
    private String city;

    public String toString(){
        return "이름은 " + this.name + "입니다. 저는 " + this.classNumber + "반입니다.";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getCity() {
        return city;
    }




}