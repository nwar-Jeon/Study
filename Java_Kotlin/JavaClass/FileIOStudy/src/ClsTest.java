
import java.io.*;

public class ClsTest {
    public static void main(String[] atgs){
        String fileRoot = "D:/Github/Android/Study/Java_Kotlin/JavaClass/FileIOStudy/files/file.txt";
        String fileRoot2 = "D:/Github/Android/Study/Java_Kotlin/JavaClass/FileIOStudy/files/file2.txt";
        try{
            imageTest2();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    static void imageTest1() throws Exception{
        String fileRoot = "D:/Github/Android/Study/Java_Kotlin/JavaClass/FileIOStudy/temp/AsyncSubject.png";
        String copyFileRoot = "D:/Github/Android/Study/Java_Kotlin/JavaClass/FileIOStudy/files/AsyncSubject.png";
        File file1 = new File(fileRoot);
        File file2 = new File(copyFileRoot);
        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(file2);
        int read;
        while((read = is.read())!=-1){
            os.write(read);
        }
        is.close();
        os.close();
    }
    static void imageTest2() throws Exception{
        String fileRoot = "D:/Github/Android/Study/Java_Kotlin/JavaClass/FileIOStudy/temp/AsyncSubject.png";
        String copyFileRoot = "D:/Github/Android/Study/Java_Kotlin/JavaClass/FileIOStudy/files/AsyncSubject2.png";
        File file1 = new File(fileRoot);
        File file2 = new File(copyFileRoot);
        Reader reader = new BufferedReader(new FileReader(file1));
        Writer writer = new BufferedWriter(new FileWriter(file2));

        int read;
        char[] buffer = new char[1000000];
        read = reader.read(buffer);
        System.out.println(read);
        char[] buffer2 = new char[read];
        for(int i=0; i<read; i++){
            buffer2[i] = buffer[i];
        }
        writer.write(buffer2);

        reader.close();
        writer.close();
    }

    static void doTest1(String fileRoot) throws Exception{
        OutputStream os = new FileOutputStream(fileRoot);
        byte[] data = "hello world".getBytes();
        for(int i=0; i<data.length; i++){
            os.write(data[i]);
        }
        os.flush();
        os.close();
        InputStream is = new FileInputStream(fileRoot);
        int readByte;
        while(true){
            readByte = is.read();
            if(readByte==-1) break;
            System.out.println((char)readByte);
        }
        is.close();
    }

    static void doTest2(String fileRoot) throws IOException {
        OutputStream os = new FileOutputStream(fileRoot);
        byte[] data = "abcdefg hijk l m nop".getBytes();
        os.write(data);
        //os.flush();
        os.close();
        InputStream is = new FileInputStream(fileRoot);
        int readByteNo;
        byte[] readBytes = new byte[3];
        String str = "";
        while(true){
            readByteNo = is.read(readBytes);
            if(readByteNo==-1) break;
            str += new String(readBytes,0,readByteNo);
        }
        System.out.println(str);
        is.close();
    }

    static void doTest3(String fileRoot)throws IOException {
        OutputStream os = new FileOutputStream(fileRoot);
        byte[] data = "ABC".getBytes();
        os.write(data, 1, 2);
        //os.flush();
        os.close();
        InputStream is = new FileInputStream(fileRoot);
        byte[] readBytes = new byte[8];
        int readByteNo = is.read(readBytes,2,3);
        for(int i=0; i<readBytes.length; i++){
            System.out.print(readBytes[i] + " ");
        }
        is.close();

    }
}
