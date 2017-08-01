package ch08oodesign.fs;

abstract class Entry {
    protected String name;
    protected Directory parent;

    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;

    public Entry(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        created = System.currentTimeMillis();
    }

    public abstract int size();

    public boolean delete() {
        if (parent == null) {
            return false;
        }

        return parent.deleteEntry(this);
    }

    public String getFullPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }
}
