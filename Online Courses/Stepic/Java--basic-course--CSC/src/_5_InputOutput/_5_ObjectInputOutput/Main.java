package _5_InputOutput._5_ObjectInputOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]);
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());

        for (int i = 0; i < animalM2.length; i++) {
            System.out.printf("%d. %s \n", i+1, animalM2[i].getName());
        }
    }

    public static Animal[] deserializeAnimalArray (byte[] data){

        try {
            int size;

            ByteArrayInputStream bai = new ByteArrayInputStream(data);

            ObjectInputStream ois = new ObjectInputStream(bai);

            size = ois.readInt();

            Animal[] animals = new Animal[size];

            for (int i = 0; i < size; i++) {
                try {
                    animals[i] = (Animal) ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            ois.close();
            bai.close();
            return animals;
        }
        catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }
}
