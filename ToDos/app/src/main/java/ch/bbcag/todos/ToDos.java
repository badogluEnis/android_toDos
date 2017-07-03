package ch.bbcag.todos;


public final class ToDos {

    // Hier sind die verschiedenen getter & setter der columns in der Tabelle gemacht um sie im sonstigen Code zu verwenden
    private int id;
    private String title;
    private String description;
    private String date;
    private boolean pushmessage;
    private boolean isopen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPushmessage() {
        return pushmessage;
    }

    public void setPushmessage(boolean pushmessage) {
        this.pushmessage = pushmessage;
    }

    public boolean isopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }


}

