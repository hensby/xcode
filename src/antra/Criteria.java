package antra;

import java.util.Set;

public class Criteria {

    private String folderPath;
    private boolean includeSubfolder;
    private Set<String> extensions;
    private int fileNumber;

    public Criteria(String folderPath, boolean includeSubfolder) {
        this.folderPath = folderPath;
        this.includeSubfolder = includeSubfolder;
    }

    public void setExtensions(Set<String> extensions) {
        this.extensions = extensions;
    }
    public Set<String> getExtensions() {
        return extensions;
    }
    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }
    public String getFolderPath() {
        return folderPath;
    }
    public void setIncludeSubfolder(boolean includeSubfolder) {
        this.includeSubfolder = includeSubfolder;
    }
    public boolean getIncludeSubfolder() {
        return includeSubfolder;
    }

    public int getFileNumber() {
        return fileNumber;
    }
    public void setFileNumber(int fileNumber) {
        this.fileNumber = fileNumber;
    }
}
