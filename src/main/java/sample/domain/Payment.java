package sample.domain;

import javax.persistence.*;

/**
 * Fix payment form
 */

@Entity
@Table(name="Payment")
//@SQLInsert( sql="INSERT INTO Payment(paymentId, userId, editionId, cardNumber, paymentSum) VALUES(?,?,?,?,?)")
//@SQLUpdate( sql="UPDATE Payment SET userId = ?, editionId = ?, cardNumber = ?, paymentSum = ? WHERE paymentId = ?")
//@SQLDelete( sql="DELETE Payment WHERE paymentId = ?")
public class Payment {

    @Id
    @GeneratedValue
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="editionId")
    private Edition edition;

    private String cardNumber;

    @Column(name="paymentSum")
    private float sum;

    public Payment() {
    }

    public Payment(User user, Edition edition, String cardNumber, float sum) {
        this.user = user;
        this.edition = edition;
        this.cardNumber = cardNumber;
        this.sum = sum;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", user=" + user +
                ", edition=" + edition +
                ", cardNumber='" + cardNumber + '\'' +
                ", sum=" + sum +
                '}';
    }

    public boolean isCardNumberValid() {
        return this.cardNumber != null;
    }
}
