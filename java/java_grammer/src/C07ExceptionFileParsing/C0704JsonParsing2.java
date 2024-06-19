package C07ExceptionFileParsing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class C0704JsonParsing2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path filePath = Paths.get("src/C07ExceptionFileParsing/test_data2.json");
        String jsonString = Files.readString(filePath);

        JsonNode jsonList = objectMapper.readTree(jsonString);
        List<Students> studentsList = new ArrayList<>();

        for (JsonNode j : jsonList) {
            Students tempStudent = objectMapper.readValue(j.toString(), Students.class);
        }

    }
}


class Students{
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
