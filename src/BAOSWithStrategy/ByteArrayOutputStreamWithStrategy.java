package BAOSWithStrategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteArrayOutputStreamWithStrategy extends OutputStream {
    private static final int DEFAULT_START_SIZE = 16;
    private static final Strategy DEFAULT_STRATEGY = new DoubleStrategy();

    private Strategy strategy;
    private final List<byte[]> bufferList = new ArrayList<>(16);
    private int count = 0;
    private int arrNum = 0;
    private byte[] buf;
    private int arrLength;

    public ByteArrayOutputStreamWithStrategy() {
        this.strategy = DEFAULT_STRATEGY;
        this.bufferList.add(new byte[DEFAULT_START_SIZE]);
        buf = bufferList.get(arrNum);
        arrLength = bufferList.get(arrNum).length;
    }

    public ByteArrayOutputStreamWithStrategy(int startSize, Strategy strategy) {
        this.strategy = strategy;
        this.bufferList.add(new byte[startSize]);
        buf = bufferList.get(arrNum);
        arrLength = bufferList.get(arrNum).length;
    }

    public ByteArrayOutputStreamWithStrategy(int startSize) {
        this.strategy = DEFAULT_STRATEGY;
        this.bufferList.add(new byte[startSize]);
        buf = bufferList.get(arrNum);
        arrLength = bufferList.get(arrNum).length;
    }

    @Override
    public void write(int b) throws IOException {
        ensureCapacity(count + 1);
        buf[count] = (byte) b;
        count += 1;
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) - b.length > 0)) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacityForArr( b, off, len);
    }

    private void ensureCapacity(int current){
        if (current - arrLength > 0){
            nextArr(current);
        }
    }

    private void ensureCapacityForArr(byte[] b, int off, int len){
        int tail = len - arrLength;
        if (len > arrLength){
            System.arraycopy(b, off, buf, 0, arrLength);
            nextArr(arrLength);
            ensureCapacityForArr(b, off + bufferList.get(arrNum - 1).length, tail);
        }else {
            System.arraycopy(b, off, buf, count, len);
            count +=len;
        }

    }

    private void nextArr(int current){
        bufferList.add(new byte[strategy.nextAfter(current)]);
        arrNum+=1;
        buf = bufferList.get(arrNum);
        arrLength = bufferList.get(arrNum).length;
        count = 0;
    }

    public synchronized byte toByteArray()[] {
        int length = -(arrLength - count);
        System.out.println("len " + length);
        int cutZeros = length;
        for (byte[] arr: bufferList) {
            System.out.println(Arrays.toString(arr));
            length += arr.length;
        }

        byte [] allInOneArr = Arrays.copyOf(bufferList.get(0), length);

        int destPos = bufferList.get(0).length;
        for (int i = 1; i <= arrNum; i++){
            if (i == arrNum){
                System.arraycopy(bufferList.get(i), 0, allInOneArr, destPos, bufferList.get(i).length + cutZeros);
            }else {
                System.arraycopy(bufferList.get(i), 0, allInOneArr, destPos, bufferList.get(i).length);
                destPos += bufferList.get(i).length;
            }
        }
        return allInOneArr;
    }
}
