package test;

import com.example.rest.entity.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class ReadingJsonFile {
    private static final Type REVIEW_TYPE = new TypeToken<List<Student>>() {
    }.getType();

    public Student getDataFromJson(int param) throws Exception {

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("students.json"));
        List<Student> data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
        return data.get(param);
    }
}