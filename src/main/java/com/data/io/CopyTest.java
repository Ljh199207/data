package com.data.io;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;

/**
 * @Auther: ljh
 * @Date: 2018/9/21 09:23
 * @Description:
 */
public class CopyTest {

    public static void main(String[] args) throws  Exception{

        if (args.length != 2) {
            System.out.println("错误的命令，格式为 CopeTest : 源文件路径，目标文件路径");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("路径错误！请确认源文件路径是否正确");
            System.exit(1);
        }
        File file1 = new File(args[1]);
        if (file1.exists()) {
            System.out.println("路径错误！请确认目标文件路径是否正确");
            System.exit(1);
        }
        Long start = System.currentTimeMillis();
        InputStream inputStream= new FileInputStream(file);
        OutputStream outputStream  = new FileOutputStream(file1);
        copy(inputStream,outputStream);
        inputStream.close();
        outputStream.close();
        Long end = System.currentTimeMillis();
        System.out.println("start: "+start+",end"+end);

    }

    public  static  void copy (InputStream in , OutputStream out) throws IOException {
        int tmep =0;//保存每次读取的字节量
        byte data [] = new byte[2048];
         while ((tmep=in.read(data))!=-1){
           // out.write(tmep);
             out.write(data,0,tmep);
        }
    }

}
