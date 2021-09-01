package ua.com.alevel;

import ua.com.alevel.io.IOFileCrudService;
import ua.com.alevel.nio.NIOFileCrudService;
import ua.com.alevel.serial.UserSerialisationService;

public class IONIOMain {

    public static void main(String[] args) {
//        FileCrudService service = new IOFileCrudService();
//        service.createFile(FileType.FILE_TXT.getPath());
//        service.createHiddenFile(FileType.FILE_HIDDEN_TXT.getPath());
//        service.createDir(FileType.FILE_DIR.getPath());
//        service.createDirs(FileType.FILE_DIRS.getPath());
//        service.readDir(FileType.FILE_DIR.getPath());
//        service.deleteFile(FileType.FILE_DIRS.getPath() + "/file3.txt");
//        service.deleteDir(FileType.FILE_DIR.getPath());
//        service.readFile(FileType.FILE_HIDDEN_TXT.getPath());
//        FileCrudService service = new NIOFileCrudService();
//        service.createFile(FileType.FILE_TXT.getPath());
//        service.deleteFile(FileType.FILE_TXT.getPath());
//        service.createDir(FileType.FILE_DIR.getPath());
//        service.createDirs(FileType.FILE_DIRS.getPath());
//        service.readDir(FileType.FILE_DIR.getPath());
//        service.deleteDir(FileType.FILE_DIR.getPath());
//        service.createDir(FileType.FILE_TEMP_DIR.getPath());
//        service.moveDir(FileType.FILE_DIR.getPath(), FileType.FILE_COPY_DIR.getPath());
        UserSerialisationService service = new UserSerialisationService();
        service.serialize();
        service.deserialize();
    }
}
