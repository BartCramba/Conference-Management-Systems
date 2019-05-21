package sample.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Creates window with the proposals which need review
 */

@Entity
@Table(name="Proposal")
//@SQLInsert( sql="INSERT INTO Proposal(proposalId, userId, editionId, proposalName, proposalDescription, keywords, statuses) VALUES(?,?,?,?,?,?,?)")
//@SQLUpdate( sql="UPDATE Proposal SET userId = ?, editionId = ?, proposalName = ?, proposalDescription = ?, keywords = ?, statuses = ? WHERE proposalId = ?")
//@SQLDelete( sql="DELETE Proposal WHERE proposalId = ?")
public class Proposal {

    @Id
    @GeneratedValue
    private int proposalId;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="editionId")
    private Edition edition;

    @Column(name="proposalName")
    private String name;

    @Column(name="proposalDescription")
    private String description;

    @OneToMany
    @JoinTable(name="Topics",
    joinColumns=@JoinColumn(name="proposalId"),
    inverseJoinColumns=@JoinColumn(name="topicId"))
    private List<Topic> topics = new ArrayList<Topic>();

    @ElementCollection(targetClass=String.class)
    private List<String> keywords = new ArrayList<String>();

    @OneToMany
    @JoinColumn(name="proposalStatusId")
    private List<ProposalStatus> statuses = new ArrayList<ProposalStatus>();

    @Temporal(TemporalType.DATE)
    private Calendar modified;  // maybe we won't use it
    @Temporal(TemporalType.DATE)
    private Calendar created;

    public Proposal() {
    }

    public Proposal(User user, Edition edition, String name, String description, List<Topic> topics, List<String> keywords,
                    List<ProposalStatus> statuses, Calendar modified, Calendar created) {
        this.user = user;
        this.edition = edition;
        this.name = name;
        this.description = description;
        this.topics = topics;
        this.keywords = keywords;
        this.statuses = statuses;
        this.modified = modified;
        this.created = created;
    }

    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<ProposalStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<ProposalStatus> statuses) {
        this.statuses = statuses;
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
        return "Proposal{" +
                "proposalId=" + proposalId +
                ", user=" + user +
                ", edition=" + edition +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", topics=" + topics +
                ", keywords=" + keywords +
                ", statuses=" + statuses +
                ", modified=" + modified +
                ", created=" + created +
                '}';
    }
}
