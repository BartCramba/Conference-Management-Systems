package sample.domain;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="Conference")
//@SQLInsert( sql="INSERT INTO Conference(conferenceId, author, conferenceName, created) VALUES(?,?,?,?)")
//@SQLUpdate( sql="UPDATE Conference SET author = ?, conferenceName = ?, created = ? WHERE conferenceId = ?")
//@SQLDelete( sql="DELETE Conference WHERE conferenceId = ?")
public class Conference {

    @Id
    @GeneratedValue
    private Integer conferenceId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User author;
    @Column(name="conferenceName")
    private String name;
    @Temporal(TemporalType.DATE)
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
