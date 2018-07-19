package com.data.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTest {
    public static void main(String[] args) throws IOException
    {
        String zipname = "D:\\Documents\\Downloads\\Downloads.zip";
        showContents(zipname);
        System.out.println("---");
        showContents2(zipname);
        writeZip();
    }

    public static void showContents(String zipname) throws IOException
    {
        File file = new File("D:\\Documents\\Downloads\\Downloads.zip");

        // Here, we use the classic zip API
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(file)))
        {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null)
            {
                System.out.println(entry.getName());

                Scanner in = new Scanner(zin);
                while (in.hasNextLine())
                    System.out.println("   " + in.nextLine());
                // DO NOT CLOSE in
                zin.closeEntry();
            }
        }
    }

    public static void showContents2(String zipname) throws IOException
    {
        // Here, we make a Java SE 7 file system
        FileSystem fs = FileSystems.newFileSystem(Paths.get(zipname), null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>()
        {
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException
            {
                System.out.println(path);
                for (String line : Files.readAllLines(path, Charset.forName("UTF-8")))
                    System.out.println("   " + line);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static  void writeZip() throws IOException {
        ZipOutputStream zipOut = null;
        zipOut = new ZipOutputStream(new FileOutputStream("zip1.zip"));
        int i=0;
        while (i<3){
            ZipEntry entry = new ZipEntry(i+".txt");
            zipOut.putNextEntry(entry);
            zipOut.write(99);
            i++;
        }
        zipOut.close();
    }
}
