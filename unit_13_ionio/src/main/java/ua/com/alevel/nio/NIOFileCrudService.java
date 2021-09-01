package ua.com.alevel.nio;

import ua.com.alevel.FileCrudService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIOFileCrudService implements FileCrudService {

    @Override
    public void createFile(String pathToFile) {
        Path path = Paths.get(pathToFile);
        try {
            boolean exists = Files.exists(path);
            if (!exists) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createHiddenFile(String pathToFile) {

    }

    @Override
    public void deleteFile(String pathToFile) {
        Path path = Paths.get(pathToFile);
        try {
//            Files.delete(path);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(String pathToFile) {

    }

    @Override
    public void updateFile(String pathToFile) {

    }

    @Override
    public void createDir(String pathToDir) {
        Path path = Paths.get(pathToDir);
        boolean exists = Files.exists(path);
        if (!exists) {
            try {
                if (path.toFile().getName().startsWith("temp")) {
                    Files.createTempDirectory(pathToDir);
                } else {
                    Files.createDirectory(path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createDirs(String pathToDir) {
        Path path = Paths.get(pathToDir);
        boolean exists = Files.exists(path);
        if (!exists) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void readDir(String pathToDir) {
        Path path = Paths.get(pathToDir);
        Set<String> filesPath = new HashSet<>();
        try {
            Stream<Path> pathStream = Files.walk(path);
            filesPath = pathStream
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .filter(file -> !file.getName().startsWith("f"))
                    .map(File::getAbsolutePath)
                    .collect(Collectors.toSet());
            for (String s : filesPath) {
                System.out.println("s = " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDir(String pathToDir) {
        Path path = Paths.get(pathToDir);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDir(String pathToDir) {

    }

    @Override
    public void moveDir(String fromDir, String toDir) {
        Path pathFrom = Paths.get(fromDir);
        Path pathTo = Paths.get(toDir);
        try {
            Files.move(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
