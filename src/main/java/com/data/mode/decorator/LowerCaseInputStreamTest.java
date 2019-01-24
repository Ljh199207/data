package com.data.mode.decorator;

import java.io.*;

/**
 * @Auther: ljh
 * @Date: 2019/1/18 15:22
 * @Description:
 */
public class LowerCaseInputStreamTest {

    public static void main(String[] args) throws IOException {

        int c ;

        InputStream inputStream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("createFloder/index1/index1.txt")));

       while ((c=inputStream.read())>=0){
           System.out.println((char)c);
       }

       inputStream.close();
    }
}
