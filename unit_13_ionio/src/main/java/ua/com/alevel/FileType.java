package ua.com.alevel;

public enum FileType {

    FILE_TXT("file.txt"),
    FILE_HIDDEN_TXT(".test.txt"),
    FILE_DIR("test"),
    FILE_COPY_DIR("copy"),
    FILE_TEMP_DIR("temp_temp_test"),
    OUT_TYPE("user.txt"),
    FILE_DIRS("test/test1/test2");

    private String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
