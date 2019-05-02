package sample.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.*;

@Entity
@Table(name="Topic")
//@SQLInsert( sql="INSERT INTO Topic(topicId, name) VALUES(?,?)")
//@SQLUpdate( sql="UPDATE Topic SET name = ? WHERE topicId = ?")
//@SQLDelete( sql="DELETE Topic WHERE topicId = ?")
public class Topic {

    @Id @GeneratedValue
    private int topicId;
    @Column(name="topicName")
    private String name;

    public Topic(String name) {
        this.name = name;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", name='" + name + '\'' +
                '}';
    }
}
