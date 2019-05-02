package sample.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.*;

@Entity
@Table(name="_Session")
//@SQLInsert( sql="INSERT INTO _Session(sessionId, sessionName, room, userId, editionId) VALUES(?,?,?,?,?)")
//@SQLUpdate( sql="UPDATE _Session SET sessionName = ?, room = ?, userId = ?, editionId = ? WHERE sessionId = ?")
//@SQLDelete( sql="DELETE _Session WHERE sessionId = ?")
public class Session {

    @Id @GeneratedValue
    private Integer sessionId;

    @Column(name="sessionName")
    private String name;
    private String room;

    @ManyToOne
    @JoinColumn(name="userId")
    @Column(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="editionId")
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

    public int getEditionId(){
        return this.edition.getEditionId();
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
