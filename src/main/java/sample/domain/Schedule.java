package sample.domain;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="Schedule")
//@SQLInsert( sql="INSERT INTO Schedule(scheduleId, proposalId, sessionId, beginDate, endDate) VALUES(?,?,?,?,?)")
//@SQLUpdate( sql="UPDATE Schedule SET proposalId = ?, sessionId = ?, beginDate = ?, endDate = ? WHERE scheduleId = ?")
//@SQLDelete( sql="DELETE Schedule WHERE scheduleId = ?")
public class Schedule {

    @Id
    @GeneratedValue
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name="proposalId")
    private Proposal proposal;

    @ManyToOne
    @JoinColumn(name="sessionId")
    private Session session;

    @Temporal(TemporalType.DATE)
    private Calendar beginDate;
    @Temporal(TemporalType.DATE)
    private Calendar endDate;

    public Schedule() {
    }

    public Schedule(Proposal proposal, Session session, Calendar beginDate, Calendar endDate) {
        this.proposal = proposal;
        this.session = session;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
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

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", proposal=" + proposal +
                ", session=" + session +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
