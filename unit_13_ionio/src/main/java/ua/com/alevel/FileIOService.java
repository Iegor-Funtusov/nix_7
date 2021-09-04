package ua.com.alevel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import ua.com.alevel.data.Person;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileIOService {

    public void start() {
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void csvTest() {

        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setId(1);
        person.setName("test1");
        person.setBirthDay(new Date());
        list.add(person);
        person = new Person();
        person.setId(2);
        person.setName("test2");
        person.setBirthDay(new Date());
        list.add(person);

        List<String[]> csv = new ArrayList<>();

        String[] header = new String[3];
        header[0] = "id";
        header[1] = "name";
        header[2] = "birthDay";
        csv.add(header);

        for (Person person1 : list) {
            String[] per = new String[3];
            per[0] = String.valueOf(person1.getId());
            per[1] = person1.getName();
            per[2] = String.valueOf(person1.getBirthDay().getTime());
            csv.add(per);
        }

        try(CSVWriter writer = new CSVWriter(new FileWriter("persons.csv"))) {
            writer.writeAll(csv);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(CSVReader reader = new CSVReader(new FileReader("persons.csv"))) {
            try {
                List<String[]> strings = reader.readAll();
                for (String[] string : strings) {
                    for (String s : string) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                }

                list = strings
                        .stream()
                        .skip(1)
                        .map(s -> {
                            Person u = new Person();
                            u.setId(Integer.parseInt(s[0]));
                            u.setName(s[1]);
                            u.setBirthDay(new Date(Long.parseLong(s[2])));
                            return u;
                        })
                        .collect(Collectors.toList());

                System.out.println("persons = " + list);

            } catch (CsvException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseJson() {
        try {
            String json = Files.readString(Paths.get("some.json"));
//            System.out.println("json = " + json);
            JsonElement jsonElement = new Gson().fromJson(json, JsonObject.class);
            if (jsonElement instanceof JsonObject) {
//                System.out.println("JsonObject");
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                for (Map.Entry<String, JsonElement> element : jsonObject.entrySet()) {
                    JsonElement value = element.getValue();

                    if (value.isJsonPrimitive()) {
//                        System.out.println("isJsonPrimitive = " + element.getKey());
                        String s = value.getAsString();
                        if (s.matches("\\d+")) {
                            Long aLong = Long.parseLong(s);
                            System.out.println("aLong = " + aLong);
                        }
                    }
                    if (value.isJsonArray()) {
//                        System.out.println("isJsonArray = " + element.getKey());
                    }
                    if (value.isJsonObject()) {
//                        System.out.println("isJsonObject = " + element.getKey());
                    }
                    System.out.println("value = " + value);
                }
//                System.out.println("jsonObject = " + jsonObject);
//                for (String s : jsonObject.keySet()) {
//                    System.out.println("s = " + s);
//                    String key = jsonObject.get(s).getAsString();
//                    System.out.println("key = " + key);
//
//                }

            }
            if (jsonElement instanceof JsonArray) {
                System.out.println("JsonArray");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jacksonTest(String json) {
        System.out.println("json = " + json);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
//            Person person = objectMapper.readValue(json, Person.class);
//            System.out.println("person = " + person);
            List<Person> list = objectMapper.readValue(json, new TypeReference<>() { });
            System.out.println("list = " + list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void gsonTest() {
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setId(1);
        person.setName("test1");
        person.setBirthDay(new Date());
        list.add(person);
        person = new Person();
        person.setId(2);
        person.setName("test2");
        person.setBirthDay(new Date());
        list.add(person);

        String p = gson.toJson(list);
//        System.out.println("p = " + p);

        String s = "{\"id\":1,\"name\":\"test2\",\"birthDay\": 0}";

        person = gson.fromJson(s, Person.class);
//        System.out.println("person = " + person);

        jacksonTest(p);


//        String s = null;
//        try {
//            s = Files.readString(Paths.get("users.json"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("s = " + s);
//        Person person = gson.fromJson(s, Person.class);
//        System.out.println("person = " + person);

//        List<Person> persons = gson.fromJson(s, new TypeToken<List<Person>>(){ }.getType());
//        System.out.println("persons = " + persons);
//        for (Person person : persons) {
//            System.out.println("person = " + person);
//        }
    }

    private void run() throws IOException {





//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String s = bufferedReader.readLine();
//        Files.writeString(Paths.get("file.txt"), s, StandardOpenOption.APPEND);
//        Files.write(Paths.get("file.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
//        Files.write(Paths.get("file.txt"), "yyyyyyy".getBytes(), StandardOpenOption.APPEND);

//        try(        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt", true))
//        ) {
//            String s = bufferedReader.readLine();
//            bufferedWriter.write("\n");
//            bufferedWriter.write(s);
//        } catch (Exception e) {
//            System.out.println("e = " + e.getMessage());
//        }


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"));
//
//        String s = bufferedReader.readLine();
//        bufferedWriter.write(s);
//        bufferedWriter.flush();


//        BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
//        System.out.println("bufferedReader = " + bufferedReader.readLine());
//        while (bufferedReader.ready()) {
//            System.out.println("bufferedReader = " + bufferedReader.readLine());
//        }
//
//        FileReader reader = new FileReader("test.txt");



//        InputStreamReader isr = new InputStreamReader(System.in);
//        int read = isr.read();
//        char s = (char) read;
//        System.out.println("s = " + s);
//        System.out.println("read = " + read);
//        while (isr.ready()) {
//            read = isr.read();
//            s = (char) read;
//            System.out.println("s = " + s);
//            System.out.println("read = " + read);
//        }


    }
}
