package sample.Domain;

public class Session {

    private Integer sessionId;
    private String name;
    private String room;
    private User user;
    private Edition edition;   // belonging to

    public Session(String name, String room, User user, Edition edition) {
        this.name = name;
        this.room = room;
        this.user = user;
        this.edition = edition;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", user=" + user +
                ", edition=" + edition +
                '}';
    }
}
