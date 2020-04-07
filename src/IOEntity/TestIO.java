package IOEntity;

import java.io.*;
import java.util.Arrays;

// Создание IO классов (адаптеров), способных записывать/считывать определенные сущности(Person, Point) в байтовый поток.
public class TestIO {
    public static void main(String[] args) {
        Person person = new Person("Dasha", 24);
        Point point = new Point(5,-3);

        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        EntityOutput out = new EntityOutputStream(buff);

        try {
            out.writePerson(person);
            out.writePoint(point);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] rawBytes = buff.toByteArray();
        System.out.println(Arrays.toString(rawBytes));
        EntityInput in = new EntityInputStream(new ByteArrayInputStream(rawBytes));
        try {
            Person personIn = in.readPerson();
            Point pointIn = in.readPoint();

            if (personIn.getName().equals("Dasha") && (personIn.getAge() == 24) && (pointIn.getX() == point.getX()) && (pointIn.getY() == point.getY())){
                System.out.println("OK");
            }else {
                throw new AssertionError();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
