package ua.com.alevel.serial;

import ua.com.alevel.FileType;

import java.io.*;
import java.util.UUID;

public class UserSerialisationService {

    private User user;

    public UserSerialisationService() {
        user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setFirstName("first");
        user.setLastName("last");
    }

    public void serialize() {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(FileType.OUT_TYPE.getPath()))) {
            stream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize() {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(FileType.OUT_TYPE.getPath()))) {
            User user = (User) stream.readObject();
            System.out.println("user = " + user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
