package BAOSWithStrategy;

import java.io.*;
import java.util.Arrays;

// ByteArrayOutputStreamWithStrategy аналог ByteArrayOutputStream, отличается алгоритмом: запись происходит в массив(буфер).
//  Новый буфер создается только при ПОЛНОМ заполнении старого буфера и помещается в ArrayList. Все буфера хранятся
// в ArrayList. Метод toByteArray все буферы из ArrayList объединяет в один массив, отбрасывая незначащие нули.
public class TestNewBAOS {
    public static void main(String[] args) {
        ByteArrayOutputStreamWithStrategy out = new ByteArrayOutputStreamWithStrategy(4, new DoubleStrategy());
        byte[] someByte = new byte[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        try {
            out.write(someByte);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(out.toByteArray()));


    }
}
