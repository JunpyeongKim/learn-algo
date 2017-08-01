package ch08oodesign.fs;


import java.util.ArrayList;

public class Directory extends Entry {
    private ArrayList<Entry> entries;
    // private ArrayList<Entry> files;
    // private ArrayList<Entry> directories;

    public Directory(String name, Directory parent) {
        super(name, parent);
        entries = new ArrayList<Entry>();
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void addEntry(Entry e) {
        entries.add(e);
    }

    public boolean deleteEntry(Entry e) {
        return entries.remove(e);
    }

    public int size() {
        int size = 0;
        for (Entry e : entries) {
            size += e.size();
        }

        return size;
    }

    public int numberOfFiles() {
        int count = 0;

        for (Entry e : entries) {
            if (e instanceof File) {
                count++;
            } else if (e instanceof Directory) {
                count++;
                count += ((Directory)e).numberOfFiles();
            }
        }

        return count;
    }
}
