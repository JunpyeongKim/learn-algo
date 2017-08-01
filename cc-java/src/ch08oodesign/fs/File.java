package ch08oodesign.fs;


public class File extends Entry {
    private int size;
    private String content;

    public File(String name, Directory parent, int size) {
        super(name, parent);
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String c) {
        content = c;
    }
}
