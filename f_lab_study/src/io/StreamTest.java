package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static java.io.File.separator;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        String             path = separator + "Users" + separator + "d0" + separator + "Desktop" + separator + "man.obj";
        FileOutputStream   fos  = new FileOutputStream(path);
        ObjectOutputStream oos  = new ObjectOutputStream(fos);
        Man                man  = new Man("심성헌", 27);
        oos.writeObject(man);
        oos.close();
        fos.close();

        IntBuffer buffer = IntBuffer.allocate(1024); //해당 버퍼에 담을 수 있는 크기
        buffer.get(); // 데이터 읽기
        buffer.mark(); // 현재 위치
        buffer.reset(); // 다시 이동
        buffer.rewind(); // 처음으로 이동
        buffer.clear(); // 데이터 삭제
    }

    public static class Man implements Serializable {
        private String  name;
        private Integer age;

        public Man(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
