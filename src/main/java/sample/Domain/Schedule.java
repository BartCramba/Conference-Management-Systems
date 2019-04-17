package sample.Domain;

import java.util.Calendar;

public class Schedule {

    private Integer scheduleId;
    private Proposal proposal;
    private Session session;

    private Calendar beginDate;
    private Calendar endDate;

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
