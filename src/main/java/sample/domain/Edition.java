package sample.domain;


import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="Edition")
//@SQLInsert( sql="INSERT INTO Edition(editionId, author, editionName, conferenceId, beginDate, endDate, beginSubmissions, endSubmissions, endBidding, endReview, created) VALUES(?,?,?,?,?,?,?,?,?,?,?)")
//@SQLUpdate( sql="UPDATE Edition SET author = ?, editionName = ?, conferenceId = ?, beginDate = ?, endDate = ?, beginSubmissions = ?, endSubmissions = ?, endBidding = ?, endReview = ?, created = ? WHERE editionId = ?")
//@SQLDelete( sql="DELETE Edition WHERE editionId = ?")
public class Edition {

    @Id
    @GeneratedValue
    private Integer editionId;

    @ManyToOne
    @JoinColumn(name="userId")
    private User author;

    @Column(name="editionName")
    private String name;

    @ManyToOne
    @JoinColumn(name="conferenceId")
    private Conference conference;   // the edition belongs to this conference

    @Temporal(TemporalType.DATE)
    private Calendar beginDate;
    @Temporal(TemporalType.DATE)
    private Calendar endDate;

    @Temporal(TemporalType.DATE)
    private Calendar beginSubmissions;
    @Temporal(TemporalType.DATE)
    private Calendar endSubmissions;

    @Temporal(TemporalType.DATE)
    private Calendar endBidding;
    @Temporal(TemporalType.DATE)
    private Calendar endReview;

    @Temporal(TemporalType.DATE)
    private Calendar created;

    public Edition(Integer editionId, User author, String name, Conference conference, Calendar beginDate, Calendar endDate, Calendar beginSubmissions,
                   Calendar endSubmissions, Calendar endBidding, Calendar endReview, Calendar created) {
        this.editionId = editionId;
        this.author = author;
        this.name = name;
        this.conference = conference;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.beginSubmissions = beginSubmissions;
        this.endSubmissions = endSubmissions;
        this.endBidding = endBidding;
        this.endReview = endReview;
        this.created = created;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
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

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Calendar getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Calendar beginDate) {
        this.beginDate = beginDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public Calendar getBeginSubmissions() {
        return beginSubmissions;
    }

    public void setBeginSubmissions(Calendar beginSubmissions) {
        this.beginSubmissions = beginSubmissions;
    }

    public Calendar getEndSubmissions() {
        return endSubmissions;
    }

    public void setEndSubmissions(Calendar endSubmissions) {
        this.endSubmissions = endSubmissions;
    }

    public Calendar getEndBidding() {
        return endBidding;
    }

    public void setEndBidding(Calendar endBidding) {
        this.endBidding = endBidding;
    }

    public Calendar getEndReview() {
        return endReview;
    }

    public void setEndReview(Calendar endReview) {
        this.endReview = endReview;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "editionId=" + editionId +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", conference=" + conference +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", beginSubmissions=" + beginSubmissions +
                ", endSubmissions=" + endSubmissions +
                ", endBidding=" + endBidding +
                ", endReview=" + endReview +
                ", created=" + created +
                '}';
    }
}
