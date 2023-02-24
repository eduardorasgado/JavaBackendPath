package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.files;

public class FilesDemo {

    public static void main(String[] args) {
        File file1 = new BinaryFile("File1");
        file1.setPermissions("+w+r-x");

        Directory dir1 = new Directory("dir1");
		dir1.addFile(file1);

		File file2 = new BinaryFile("file2");
        file2.setPermissions("-w+r-x");
		File file3 = new BinaryFile("file3");
        file3.setPermissions("-w-r+x");

        Directory dir2 = new Directory("dir2");
		dir2.addFile(file2);
		dir2.addFile(dir1);
        dir2.addFile(file3);
        dir2.getPermissions();
        System.out.println();


        dir1.setPermissions("-w+r-w");
        dir2.getPermissions();
        System.out.println();

        dir2.setPermissions("+w+r+w");
        dir2.getPermissions();
    }
}
