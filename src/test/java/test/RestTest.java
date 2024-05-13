package test;

import com.example.rest.entity.Student;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.*;

public class RestTest {

    ReadingJsonFile read = new ReadingJsonFile();

    @Test
    public void testFall() throws Exception {

        Student student = read.getDataFromJson(0);

        RestAssured.baseURI = "http://localhost:8082";
        String endPoint = "/students/1";

        // Steps to have a response body
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(endPoint);
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: \n" + body.asPrettyString());

        RestAssured
                .given()
                .when()
                .get(endPoint)
                .then()
                .statusCode(200)
                .body("studentId", equalTo(student.getStudentId()))
                .body("firstName", equalTo(student.getFirstName()))
                .body("lastName", equalTo(student.getLastName()))
                .body("sex", equalTo(student.getSex()))
                .body("age", equalTo(student.getAge()))
                .body("degree", equalTo(student.getDegree()))
                .body("book.bookId", equalTo(student.getBook().getBookId()))
                .body("book.booksName", hasItems(student.getBook().getBooksName()))
                .body("book.listOfGames[0].gameId", equalTo(student.getBook().getListOfGames().get(0).getGameId()))
                .body("book.listOfGames[0].numberOfHours[0]", equalTo(student.getBook().getListOfGames().get(0).getNumberOfHours()[0]));
    }
}