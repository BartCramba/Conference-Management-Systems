package sample.Domain;

import java.util.Calendar;

/**
 * Choosing reviewers and see comments
 */
public class ProposalStatus {

    private int proposalStatusId;
    private proposalStatus status;
    private String comment;
    private User user;
    private Proposal proposal;

    private Calendar modified;
    private Calendar created;

    public int getProposalStatusId() {
        return proposalStatusId;
    }

    public void setProposalStatusId(int proposalStatusId) {
        this.proposalStatusId = proposalStatusId;
    }

    public proposalStatus getStatus() {
        return status;
    }

    public void setStatus(proposalStatus status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Calendar getModified() {
        return modified;
    }

    public void setModified(Calendar modified) {
        this.modified = modified;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ProposalStatus{" +
                "proposalStatusId=" + proposalStatusId +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                ", proposal=" + proposal +
                ", modified=" + modified +
                ", created=" + created +
                '}';
    }

    public static enum proposalStatus {

        analyzes("ANALYZES_PROPOSAL"),
        maybeAnalyzes("MAYBE_ANALYZES_PROPOSAL"),
        rejectAnalyzes("REJECT_ANALYZES_PROPOSAL"),
        strongAccept("STRONG_ACCEPT"),
        accept("ACCEPT"),
        weekAccept("WEEK_ACCEPT"),
        borderlinePaper("BORDERLINE_PAPER"),
        weekReject("WEEK_REJECT"),
        reject("REJECT"),
        strongReject("STRONG_REJECT"),
        toReview("TO_REVIEW");

        /**
         * Numele statusului.
         */
        private String nume;

        /**
         * Creeaza un nou status cu un nume.
         * @param nume
         */
        proposalStatus(String nume) {
            this.nume = nume;
        }

        @Override
        public String toString() {
            return this.nume;
        }
    }
}
