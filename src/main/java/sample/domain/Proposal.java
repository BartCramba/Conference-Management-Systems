package sample.domain;

import javafx.scene.control.DatePicker;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.persistence.*;
import java.time.LocalDate;
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
@NamedQuery(
        name="Proposal.findByUsername",
        query="SELECT u FROM Proposal u WHERE u.user = :user")

@NamedQuery(
        name="Proposal.findBidings",
        query="SELECT u FROM Proposal u")
public class Proposal {
    public static final String PROPOSAL = "Proposal.findByUsername";
    public static final String USER = "user";
    public static final String PROPOSAL_BID = "Proposal.findBidings";
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

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Topics",
    joinColumns=@JoinColumn(name="proposalId"),
    inverseJoinColumns=@JoinColumn(name="topicId"))
    private List<Topic> topics = new ArrayList<Topic>();

    @ElementCollection(targetClass=String.class)
    private List<String> keywords = new ArrayList<MysqlxDatatypes.Scalar.String>();

//    @OneToMany
//    @JoinColumn(name="proposalStatusId")
    //private static List<ProposalStatus> statuses = new ArrayList<ProposalStatus>();

    @Temporal(TemporalType.DATE)
    private LocalDate modified;  // maybe we won't use it
    @Column(name="created")
    private LocalDate created;

    public Proposal() {
    }

    public Proposal(User user, Edition edition, String name, String description, List<Topic> topics, List<String> keywords, Calendar modified, Calendar created) {
        this.user = user;
        this.edition = edition;
        this.name = name;
        this.description = description;
        this.topics = topics;
        this.keywords = keywords;
        //this.statuses = statuses;
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

//    public List<ProposalStatus> getStatuses() {
//        return statuses;
//    }
//
//    public void setStatuses(List<ProposalStatus> statuses) {
//        this.statuses = statuses;
//    }

    public Calendar getModified() {
        return modified;
    }

    public void setModified(Calendar modified) {
        this.modified = modified;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
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
                //", statuses=" + statuses +
                ", modified=" + modified +
                ", created=" + created +
                '}';
    }
}
