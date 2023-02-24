package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.files;

public class Directory extends File {

    private int nextFileIdx;
    private final File[] files;

    private String permissions;

    public Directory(String name) {
        super(name);

        files = new File[9999];
        nextFileIdx = 0;
        permissions = "+w+r+x";
    }

    @Override
    public void getPermissions() {
        System.out.println("Folder " + getName() + ", permissions: " + permissions);

        for (int i = 0; i < nextFileIdx; i++) {
            files[i].getPermissions();
        }

        System.out.println("---");
    }

    @Override
    public void setPermissions(String permissions) {
        this.permissions = permissions;

        for (int i = 0; i < nextFileIdx; i++) {
            files[i].setPermissions(permissions);
        }
    }

    public void addFile(File file) {
        files[nextFileIdx++] = file;
    }

    public File[] getFiles() {
        return files;
    }

    public boolean removeFile(File file) {
        int i;
        boolean wasDeleted = false;

        for (i = 0; i < nextFileIdx; i++) {
            if(file == files[i]) {
                files[i] = null;
                wasDeleted = true;
                break;
            }
        }

        if(wasDeleted) {
            for (int j = i + 1; j < nextFileIdx; j++) {
                files[j - 1] = files[j];
                files[j] = null;
            }

            --nextFileIdx;
        }

        return true;
    }

    public void ls() {
        for (int i = 0; i < nextFileIdx; i++) {
            System.out.println(files[i].getName());
        }
    }

    public static void main(String[] args) {
        Directory directory1 = new Directory("directory 1");
        directory1.addFile(new BinaryFile("file 1"));
        File file2 = new BinaryFile("file 2");
        directory1.addFile(file2);
        directory1.addFile(new BinaryFile("file 3"));
        directory1.addFile(new BinaryFile("file 4"));

        directory1.removeFile(file2);
        directory1.ls();
        System.out.println();

        File file5 = new BinaryFile("file 5");
        directory1.addFile(file5);
        File file6 = new BinaryFile("file 6");
        directory1.addFile(file6);
        directory1.ls();
        System.out.println();

        directory1.removeFile(file5);
        directory1.ls();
        System.out.println();

        directory1.removeFile(file6);
        directory1.ls();
    }
}
