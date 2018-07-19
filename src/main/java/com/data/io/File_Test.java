package com.data.io;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedList;

public class File_Test {

    //1.创建文件夹

    public static void createFloder(String str1) {
        File myFolderPath = new File(str1);
        if (!myFolderPath.exists())
            myFolderPath.mkdir();
    }

    //
    public static void createNewFile(String str2) throws IOException {
        File myFolderPath = new File(str2);
        if (!myFolderPath.exists())
            myFolderPath.createNewFile();
        FileWriter fileWriter = new FileWriter(myFolderPath);
        PrintWriter myFile = new PrintWriter(fileWriter);
        myFile.println("这是一个测试用的");
        fileWriter.close();
    }

    public static void deleteFile(String str3) {
        File file = new File(str3);
        file.delete();
    }

    //删除一个文件下夹所有的文件夹
    public static void deleteFloder(String str4) {
        File file = new File(str4);
        File[] listFile = file.listFiles();
        for (int i = 0; i < listFile.length; i++) {
            if (listFile[i].isDirectory()) {
                listFile[i].delete();
            }
        }
    }

    //清空文件夹
    public static void delFilefolder(String str5) {
        File file = new File(str5);
        if (file.exists())
            file.delete();
        file.mkdir();
    }

    public static void folderList(String str6) {
        LinkedList<String> folderList = new LinkedList<String>();
        folderList.add(str6);
        ArrayList<File> fileList = new ArrayList<File>();
        while (folderList.size() > 0) {
            File file = new File(folderList.peek());
            folderList.removeLast();
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory())
                    folderList.add(files[i].getPath());
                else
                    fileList.add(files[i]);
            }
        }
        for (File e : fileList) {
            File str = e.getAbsoluteFile();
            System.out.println(str.toString());
        }
    }

    //复制文件
    public static void copyFile(String  source, String  dest) throws IOException {
       //下面只能复制文件夹下的文件，不能复制文件夹里的文件。
      //  Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

        LinkedList<String> folderList = new LinkedList<String>();
        folderList.add(source);
        LinkedList<String> folderList2 = new LinkedList<String>();
        int a  = source.lastIndexOf("/");
        folderList2.add(dest+source.substring(source.lastIndexOf("/")));
        while (folderList.size() > 0) {
            (new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹
            File folders = new File(folderList.peek());
            String[] file = folders.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if(folderList.peek().endsWith(File.separator))
                {
                    temp = new File(folderList.peek() + File.separator + file[i]);
                }
                else
                {
                    temp = new File(folderList.peek() + File.separator + file[i]);
                }
                if(temp.isFile())
                {
                    FileInputStream in = new FileInputStream(temp);
                    FileOutputStream out = new FileOutputStream(folderList2.peek()+File.separator+temp.getName().toString());
                    byte[] b = new byte[5120];
                    int len;
                    while((len = in.read(b)) != -1)
                    {
                        out.write(b,0,len);
                    }
                    out.flush();
                    out.close();
                    in.close();
                }
                if(temp.isDirectory()){
                 for (File e :temp.listFiles())
                 {
                     if(e.isDirectory())
                     {
                         folderList.add(e.getPath());
                         folderList2.add(folderList2.peek()+File.separator+e.getName());
                     }
                 }
                }
            }
            folderList.removeFirst();
            folderList2.removeFirst();
        }

    }

    public static void copyFiles(File sourec, File dest) throws IOException {
        FileUtils.copyFile(sourec, dest);
    }

    public static void moveFile(File source, File dest) throws IOException {
        Files.move(source.toPath(), dest.toPath());
    }

    public static void main(String[] args) throws IOException {
        // createFloder("createFloder/index1");
        //createNewFile("createFloder/index1/index1.txt");
        // createNewFile("createFloder/index1/index2.txt");
        // createNewFile("createFloder/index1/index13txt");

        // deleteFile("createFloder/index1/index1.txt");
        //  deleteFloder("createFloder");
        // delFilefolder("createFloder/index1");
        //folderList("createFloder");
        File file1 = new File("createFloder/index1/index1.txt");
        File file2 = new File("createFloder/index1/index5.txt");
        File file3 = new File("createFloder/index1");
        File file4 = new File("createFloder/index2");
        String soure = "createFloder/index1";
        String dest = "createFloder/index2";
       // copyFiles(file1, file2);
        copyFile(soure,dest);
        //   moveFile(file1,file2);
    }


}
