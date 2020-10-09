package serializer.deserializer.test;

import serializer.deserializer.UserDeserializer;
import serializer.JsonUserSerializer;
import serializer.CsvUserSerializer;
import serializer.UserSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import serializer.XmlUserSerializer;
import serializer.deserializer.CsvUserDeserializer;
import serializer.deserializer.JsonUserDeserializer;
import serializer.deserializer.XmlUserDeserializer;
import serializer.deserializer.test.user.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SerializerDeserializerTest {
    private List<User> newUsers() {
        ArrayList<User> userCollection = new ArrayList<User>();
        userCollection.add(new User(1, "Ivan", "ivan@gmail.com"));
        userCollection.add(new User(2, "Sergei", "sergei@gmail.com"));
        userCollection.add(new User(3, "Semeyon", "semeyon@gmail.com"));
        userCollection.add(new User(4, "Andrey", "andrey4@gmail.com"));
        userCollection.add(new User(5, "Peter", "peter@gmail.com"));
        userCollection.add(new User(6, "Yuri", "yuri@gmail.com"));
        userCollection.add(new User(7, "Anton", "anton@gmail.com"));
        userCollection.add(new User(8, "Anatoly", "anatoly@gmail.com"));
        userCollection.add(new User(9, "Denis", "denis@gmail.com"));
        userCollection.add(new User(10, "Boris", "boris@gmail.com"));
        return userCollection;
    }

    @Test
    public void JsonUserTest() {
        Collection<User> userCollection = newUsers();
        File jsonFile = new File("users.json");
        UserSerializer serializer = new JsonUserSerializer();
        serializer.serialize(userCollection, jsonFile.getName());
        Assertions.assertTrue((jsonFile).exists());
        Assertions.assertTrue((jsonFile).length() > 0);
        UserDeserializer deserializer = new JsonUserDeserializer();
        Collection<User> deserializeUsers = deserializer.deserialize(jsonFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }

    @Test
    public void XmlUserTest() {
        Collection<User> userCollection = newUsers();
        File xmlFile = new File("users.xml");
        UserSerializer serializer = new XmlUserSerializer();
        serializer.serialize(userCollection, xmlFile.getName());
        Assertions.assertTrue((xmlFile).exists());
        Assertions.assertTrue((xmlFile).length() > 0);
        UserDeserializer deserializer = new XmlUserDeserializer();
        Collection<User> deserializeUsers = deserializer.deserialize(xmlFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }

    @Test
    public void CsvUserTest() {
        Collection<User> userCollection = newUsers();
        File csvFile = new File("users.csv");
        UserSerializer serializer = new CsvUserSerializer();
        serializer.serialize(userCollection, csvFile.getName());
        Assertions.assertTrue((csvFile).exists());
        Assertions.assertTrue((csvFile).length() > 0);
        UserDeserializer deserializer = new CsvUserDeserializer();
        Collection<User> deserializeUsers = deserializer.deserialize(csvFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }

    @Test
    void usersCsvExistsTest() throws IOException {
        Assertions.assertTrue(new File("users.csv").exists());
    }

    @Test
    void usersXmlExistsTest() throws IOException {
        Assertions.assertTrue(new File("users.xml").exists());
    }

    @Test
    void usersJsonExistsTest() throws IOException {
        Assertions.assertTrue(new File("users.json").exists());
    }
}