package com.company;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:\\1.txt");
        System.out.println(file.canWrite());
        file.renameTo(new File("D:\\100.txt"));
        System.out.println(System.getProperty("user.dir"));//打印项目的绝对路径
        File file1 = new File("D:\\steam");
        printFile(file1,0);
    }
    static void printFile(File file,int level){
        for (int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());

        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f: files){
                printFile(f,level+1);
            }
        }
    }
}
