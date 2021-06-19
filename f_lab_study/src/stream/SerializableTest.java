package stream;

import java.io.*;

import static java.io.File.separator;

public class SerializableTest {
    public static void main(String[] args) {
        SerialDto serialDto = new SerialDto("심성헌", "서울살아요", "010-9467-6216");
        String    path      = separator + "Users" + separator + "d0" + separator + "Desktop" + separator + "serial.obj";

        SerializableTest test = new SerializableTest();
//        test.saveObject(path, serialDto);
        test.readObject(path);

    }

    public void readObject(String path) {
        FileInputStream   fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if (obj instanceof SerialDto) {
                System.out.println("SerialDto.class!!");
                SerialDto serialDto = (SerialDto) obj;
                System.out.println(serialDto.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveObject(String path, SerialDto serialDto) {
        FileOutputStream   fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(serialDto);

            System.out.println("객체 저장 완료!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class SerialDto implements Serializable {
        private String name;
        private String address;
        private String phoneNumber;
        private String sex;
        private transient String aa;

        public SerialDto(String name, String address, String phoneNumber) {
            super();
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "이름 : " + name + " / 주소 : " + address + " / 전화번호 : " + phoneNumber + " / 성별 : " + sex;
        }
    }
}
