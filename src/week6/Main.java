package week6;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void loadObject() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./MyObject1");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        int number = dataInputStream.readInt();
        String name = dataInputStream.readUTF();

        Person diger = new Person(name, number);
        System.out.println(diger.getName());
        System.out.println(diger.getName());
    }

    public static void saveObject() {
        Person diger = new Person("Diger", 18018008);
        Person song = new Person("Song", 16018008);

        try {
            DataOutputStream dataOutputStream1 = new DataOutputStream(new FileOutputStream("./MyObject1"));
            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream("./MyObject2"));

            dataOutputStream1.writeUTF(diger.getName());
            dataOutputStream1.writeInt(diger.getNumber());

            dataOutputStream2.writeUTF(song.getName());
            dataOutputStream2.writeInt(song.getNumber());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serialization() throws IOException {
        Person diger = new Person("Diger", 18018008);
        Person song = new Person("Song", 16018008);

        FileOutputStream fileOutputStream = new FileOutputStream("./MySerialObject");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(diger);
        objectOutputStream.writeObject(song);
    }

    public static void serializationAdvanced() throws IOException {

        List<Person> objectList = new ArrayList<>();
        objectList.add(new Person("Diger", 18018008));
        objectList.add(new Person("Song", 16018008));

        FileOutputStream fileOutputStream = new FileOutputStream("./MySerialAdvancedObject");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(objectList);
    }

    public static void deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./MySerialObject");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Person diger = (Person) objectInputStream.readObject();
        System.out.println(diger);

        Person song = (Person) objectInputStream.readObject();
        System.out.println(song);
    }

    public static void deserializationAdvanced() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("./MySerialAdvancedObject"));

        ArrayList<Person> savedList = (ArrayList<Person>) objectInputStream.readObject();

        int iterSize = savedList.size();

        for (int i = 0; i < iterSize; i++) {
            System.out.println(savedList.get(i));
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializationAdvanced();
        deserializationAdvanced();
    }
}
