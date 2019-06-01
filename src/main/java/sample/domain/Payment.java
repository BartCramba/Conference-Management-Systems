package sample.domain;

import javax.persistence.*;

/**
 * Fix payment form
 */

@Entity
@Table(name="Payment")
//@SQLInsert( sql="INSERT INTO Payment(paymentId, userId, editionId, cardNumber) VALUES(?,?,?,?)")
//@SQLUpdate( sql="UPDATE Payment SET userId = ?, editionId = ?, cardNumber = ? WHERE paymentId = ?")
//@SQLDelete( sql="DELETE Payment WHERE paymentId = ?")
@NamedQuery(
        name="Payment.findByUsername",
        query="SELECT u FROM Payment u WHERE u.email = :email"
)
public class Payment {
    public static final String PAYMENT = "Payment.findByUsername";
    public static final String EMAIL = "email";

    @Id
    @GeneratedValue
    private Integer paymentId;

    //@ManyToOne
    @JoinColumn(name="email")
    private String email;

    //@ManyToOne
    //@JoinColumn(name="editionId")
    //private Edition edition;


    @Column(name="cardNumber")
    private String cardNumber;


    public Payment() {
    }

    public Payment(User user, String cardNumber) {
        this.email = user.getEmail();
        //this.edition = edition;
        this.cardNumber = cardNumber;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", email=" + email +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public boolean isCardNumberValid() {
        return this.cardNumber != null;
    }
}
