package sample.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Session")
@NamedQuery(
        name="Session.findAllSessions",
        query="SELECT s FROM Session s "
)
//@SQLInsert( sql="INSERT INTO _Session(sessionId, sessionName, room, userId, editionId) VALUES(?,?,?,?,?)")
//@SQLUpdate( sql="UPDATE _Session SET sessionName = ?, room = ?, userId = ?, editionId = ? WHERE sessionId = ?")
//@SQLDelete( sql="DELETE _Session WHERE sessionId = ?")
public class Session {

    public static final String SESSIONS_ALL = "Session.findAllSessions";



    @Id
    @GeneratedValue
    private Integer sessionId;

    @Column(name="sessionName")
    private String name;
    @Column(name="sessionRoom")
    private String room;


    @Column(name="userId")
    private int user;


    @Column(name="editionid")
    private int edition;

    public Session(String name, String room, Integer user, Integer edition) {
        this.name = name;
        this.room = room;
        this.user = user;
        this.edition = edition;
    }

    public Session() {
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

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getEditionId(){
        return this.edition;
    }

    @Override
    public String toString() {
        return "\t-" + name + "\n" +
                "This will take place in room number" + room + "\n" +
                "Session is hold by: ";

    }
}
