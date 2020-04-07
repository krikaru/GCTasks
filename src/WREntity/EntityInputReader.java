package WREntity;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityInputReader implements EntityReader {
    private Reader in;
    private String rawData;

    public EntityInputReader(Reader in) {
        this.in = in;
        readInArr();
    }

    @Override
    public Person readPerson() throws IOException {
        return parsePerson(rawData);
    }

    @Override
    public Point readPoint() throws IOException {
        return parsePoint(new String(rawData));
    }

    private Person parsePerson(String rawData){
        Pattern patternName = Pattern.compile("<name>(\\S+)</name>");
        Matcher matcherName = patternName.matcher(rawData);
        String name = "";
        if (matcherName.find()){
            name = matcherName.group(1);
        }

        Pattern patternAge = Pattern.compile("<age>(\\S+)</age>");
        Matcher matcherAge = patternAge.matcher(rawData);
        int age = -1;
        if (matcherAge.find()){
            age = Integer.parseInt(matcherAge.group(1));
        }
        return new Person(name, age);
    }

    private Point parsePoint(String rawData){
        Pattern pattern = Pattern.compile("'([-]?[0-9]+)'");
        Matcher matcher = pattern.matcher(rawData);

        int[] point = new int[2];
        int i = 0;
        while (matcher.find()){
            point[i++] = Integer.parseInt(matcher.group(1));
        }
        return new Point(point[0], point[1]);
    }

    private void readInArr(){
        char[] buff = new char[20];
        try {
            while (in.read(buff)!= -1){
                rawData += new String(buff);
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
