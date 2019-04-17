package sample.Domain;

import java.util.Calendar;

public class Conference {

    private Integer conferenceId;
    private User author;
    private String name;
    private Calendar created;

    public Conference(User author, String name) {
        this.author = author;
        this.name = name;
    }

    public Conference() {
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "conferenceId=" + conferenceId +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}
