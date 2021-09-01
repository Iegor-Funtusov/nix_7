package ua.com.alevel.io;

import org.apache.commons.io.FileUtils;
import ua.com.alevel.FileCrudService;

import java.io.File;
import java.io.IOException;

public class IOFileCrudService implements FileCrudService {

    @Override
    public void createFile(String pathToFile) {
        File file = new File(pathToFile);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
    }

    @Override
    public void createHiddenFile(String pathToFile) {
        File file = new File(pathToFile);
        try {
            file.createNewFile();
            setHiddenAttrib(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFile(String pathToFile) {
        File file = new File(pathToFile);
        boolean delete = file.delete();
        System.out.println("delete = " + delete);
    }

    @Override
    public void readFile(String pathToFile) {
        File file = new File(pathToFile);
        boolean hidden = file.isHidden();
        System.out.println("hidden = " + hidden);
    }

    @Override
    public void updateFile(String pathToFile) {

    }

    @Override
    public void createDir(String pathToDir) {
        File file = new File(pathToDir);
        file.mkdir();
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
    }

    @Override
    public void createDirs(String pathToDir) {
        File file = new File(pathToDir);
        file.mkdirs();
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
    }

    @Override
    public void readDir(String pathToDir) {
        File file = new File(pathToDir);
        readDir(file);
    }

    void readDir(File file) {
        if (file.isDirectory()) {
            System.out.println("file dir = " + file.getAbsolutePath());
            for (File listFile : file.listFiles()) {
                readDir(listFile);
            }
        } else {
            System.out.println("file file = " + file.getAbsolutePath());
        }
    }

    @Override
    public void deleteDir(String pathToDir) {
        File file = new File(pathToDir);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDir(String pathToDir) {

    }

    @Override
    public void moveDir(String fromDir, String toDir) {

    }

    private static void setHiddenAttrib(File file) {
        try {
            Process p = Runtime.getRuntime().exec("attrib +H " + file.getPath());
            p.waitFor();
            if (file.isHidden()) {
                System.out.println(file.getName() + " hidden attribute is set to true");
            } else {
                System.out.println(file.getName() + " hidden attribute not set to true");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
