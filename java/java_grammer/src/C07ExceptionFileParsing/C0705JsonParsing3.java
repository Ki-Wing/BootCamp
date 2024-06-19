package C07ExceptionFileParsing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.URI;
import java.util.*;
import java.net.http.*;

public class C0705JsonParsing3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //https://jsonplaceholder.typicode.com/posts
        //http 클라이언트가 java에 내장된 https클라이언트 사용
        //Spring에서는 RestTemplate를 통해 HTTP요청
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String posts = response.body();
//        System.out.println("JSON: \n" + posts);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonList = objectMapper.readTree(posts);

        List<Post> postList = new ArrayList<>();
        for (JsonNode j : jsonList) {
            Post tempStudent = objectMapper.readValue(j.toString(), Post.class);
        }

//        lists<post> 객체를 json으로 직렬화
        String postJson = objectMapper.writeValueAsString(postList);

    }

}

class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post() {
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}