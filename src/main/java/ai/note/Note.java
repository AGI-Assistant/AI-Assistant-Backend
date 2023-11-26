package ai.note;

public class Note {

    private String id;
    private String name;
    private String text;
    private String tags;
    private String aisummery;
    private int created;
    private int lastModified;


    public Note() {

    }

public Note(String id, String name, String text, String tags, String aisummery, int created, int lastModified) {
        this.id = id;
        this.name = name;
        this.text = text;
        //TODO: add attachment list

        this.tags = tags;
        this.aisummery = aisummery;
        this.created = created;
        this.lastModified = lastModified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;

    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;

    }

    public String getAisummery() {
        return aisummery;
    }

    public void setAisummery(String aisummery) {
        this.aisummery = aisummery;

    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;

    }

    public int getLastModified() {
        return lastModified;
    }

    public void setLastModified(int lastModified) {
        this.lastModified = lastModified;

    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", tags='" + tags + '\'' +
                ", aisummery='" + aisummery + '\'' +
                ", created=" + created +
                ", lastModified=" + lastModified +
                '}';
    }

}
