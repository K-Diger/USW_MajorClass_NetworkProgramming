package week4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Endian {

    public static void main(String[] args) {
        // Endian 확인
        System.out.println("Default Endian = " + ByteOrder.nativeOrder().toString());
        
        int data = 0x01020304;
        
        // 4Byte Buffer 할당
        ByteBuffer bufferToLittleEndian = ByteBuffer.allocate(4);
        ByteBuffer bufferToBigEndian = ByteBuffer.allocate(4);

        // 버퍼 엔디안 설정
        bufferToLittleEndian.order(ByteOrder.LITTLE_ENDIAN);
        bufferToBigEndian.order(ByteOrder.BIG_ENDIAN);

        // 버퍼에 데이터 삽입
        bufferToLittleEndian.putInt(data);
        bufferToBigEndian.putInt(data);

        byte[] resultLittleEndian = bufferToLittleEndian.array();
        byte[] resultBigEndian = bufferToBigEndian.array();

        // 2차원 배열 String 화
        // Arrays.deepToString()
        System.out.println("LITTLE ENDIAN RESULT = " + Arrays.toString(resultLittleEndian));
        System.out.println("BIG ENDIAN RESULT = " + Arrays.toString(resultBigEndian));
    }
}
