package ua.com.alevel;

public interface FileCrudService {

    void createFile(String pathToFile);
    void createHiddenFile(String pathToFile);
    void deleteFile(String pathToFile);
    void readFile(String pathToFile);
    void updateFile(String pathToFile);
    void createDir(String pathToDir);
    void createDirs(String pathToDir);
    void readDir(String pathToDir);
    void deleteDir(String pathToDir);
    void updateDir(String pathToDir);
    void moveDir(String fromDir, String toDir);
}
