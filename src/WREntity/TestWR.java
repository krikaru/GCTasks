package WREntity;

import java.io.*;

// Создание IO классов (адаптеров), способных записывать/считывать определенные сущности(Person, Point) в символьный поток.
public class TestWR {
    public static void main(String[] args) {
        Person person = new Person("Dasha", 24);
        Point point = new Point(5,-3);

        try(EntityWriter out = new EntityOutputWriter(new FileWriter(new File("src/WREntity/testWR.txt")))){

            out.writePerson(person);
            out.writePoint(point);

            EntityInputReader in = new EntityInputReader(new FileReader("src/WREntity/testWR.txt"));
            Point pointIn = in.readPoint();
            Person personIn = in.readPerson();

            if ((personIn.getName().equals(person.getName())) && (personIn.getAge() == person.getAge())
            && (pointIn.getX() == point.getX()) && (pointIn.getY() == point.getY())){
                System.out.println("OK");
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
