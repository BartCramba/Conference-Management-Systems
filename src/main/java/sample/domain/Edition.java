package sample.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="Edition")
//@SQLInsert( sql="INSERT INTO Edition(editionId, author, editionName, conferenceId, beginDate, endDate, beginSubmissions, endSubmissions, endBidding, endReview, created) VALUES(?,?,?,?,?,?,?,?,?,?,?)")
//@SQLUpdate( sql="UPDATE Edition SET author = ?, editionName = ?, conferenceId = ?, beginDate = ?, endDate = ?, beginSubmissions = ?, endSubmissions = ?, endBidding = ?, endReview = ?, created = ? WHERE editionId = ?")
//@SQLDelete( sql="DELETE Edition WHERE editionId = ?")
public class Edition {
    public static final String EDITION = "EDITION.findByUsername";
    public static final String EMAIL = "email";
    @Id
    @GeneratedValue
    private Integer editionId;

    //@ManyToOne
    @Column(name="userId")
    private int author;

    @Column(name="editionName")
    private String name;

//    @ManyToOne
//    @JoinColumn(name="conferenceId")
//    private Conference conference;   // the edition belongs to this conference
    @Column(name="beginDate")
   // @Temporal(TemporalType.DATE)
    private LocalDate beginDate;
    @Column(name="endDate")
    //@Temporal(TemporalType.DATE)
    private LocalDate endDate;
    @Column(name="beginSubmissions")
   // @Temporal(TemporalType.DATE)
    private LocalDate beginSubmissions;
    @Column(name="endSubmissions")
    //@Temporal(TemporalType.DATE)
    private LocalDate endSubmissions;
    @Column(name="endBidding")
   // @Temporal(TemporalType.DATE)
    private LocalDate endBidding;
    @Column(name="endReview")
    //@Temporal(TemporalType.DATE)
    private LocalDate endReview;
//    @Column(name="editionName")
//    @Temporal(TemporalType.DATE)
//    private Calendar created;

    public Edition() {
    }

    public Edition(Integer editionId, Integer author, String name, Conference conference,LocalDate beginDate, LocalDate endDate, LocalDate beginSubmissions,
                   LocalDate endSubmissions, LocalDate endBidding, LocalDate endReview, LocalDate created) {
        this.editionId = editionId;
        this.author = author;
        this.name = name;
        //this.conference = conference;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.beginSubmissions = beginSubmissions;
        this.endSubmissions = endSubmissions;
        this.endBidding = endBidding;
        this.endReview = endReview;
        //this.created = created;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Conference getConference() {
//        return conference;
//    }
//
//    public void setConference(Conference conference) {
//        this.conference = conference;
//    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getBeginSubmissions() {
        return beginSubmissions;
    }

    public void setBeginSubmissions(LocalDate beginSubmissions) {
        this.beginSubmissions = beginSubmissions;
    }

    public LocalDate getEndSubmissions() {
        return endSubmissions;
    }

    public void setEndSubmissions(LocalDate endSubmissions) {
        this.endSubmissions = endSubmissions;
    }

    public LocalDate getEndBidding() {
        return endBidding;
    }

    public void setEndBidding(LocalDate endBidding) {
        this.endBidding = endBidding;
    }

    public LocalDate getEndReview() {
        return endReview;
    }

    public void setEndReview(LocalDate endReview) {
        this.endReview = endReview;
    }
//
//    public Calendar getCreated() {
//        return created;
//    }
//
//    public void setCreated(Calendar created) {
//        this.created = created;
//    }

    @Override
    public String toString() {
        return "Edition{" +
                "editionId=" + editionId +

                ", name='" + name + '\'' +

                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", beginSubmissions=" + beginSubmissions +
                ", endSubmissions=" + endSubmissions +
                ", endBidding=" + endBidding +
                ", endReview=" + endReview +

                '}';
    }
}
