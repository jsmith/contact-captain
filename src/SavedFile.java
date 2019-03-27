public class SavedFile {
    private static SavedFile file = null;
    private String path;

    static SavedFile Instance() {
        if (SavedFile.file == null) {
            SavedFile.file = new SavedFile();
        }

        return SavedFile.file;
    }

    private SavedFile() {

    }

    public void open(String path) {

    }

    public void save() {
        //
    }

    public void saveAs() {
        //
    }

    public void open() {
        //
    }
}
