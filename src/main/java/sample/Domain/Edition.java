package sample.Domain;

import java.util.Calendar;

public class Edition {

    private Integer sessionId;
    private User author;
    private String name;
    private Conference conference;   // the edition belongs to this conference

    private Calendar beginDate;
    private Calendar endDate;

    private Calendar beginSubmissions;
    private Calendar endSubmissions;

    private Calendar endBidding;
    private Calendar endReview;

    private Calendar created;

    public Edition(Integer sessionId, User author, String name, Conference conference, Calendar beginDate, Calendar endDate, Calendar beginSubmissions,
                   Calendar endSubmissions, Calendar endBidding, Calendar endReview, Calendar created) {
        this.sessionId = sessionId;
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

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
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
                "sessionId=" + sessionId +
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
