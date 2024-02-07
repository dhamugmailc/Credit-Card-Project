package validation.icicibank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="card_register")
public class User_Entity {
@Id
//@Column(name="id")
//private String id;
//@Column(name="username")
//private String username;
//@Column(name="password")
//private String password;
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(name="cardnumber")
private String cardnumber;
@Column(name="mobilenumber")
private String mobilenumber;

public User_Entity() {
	
}

public User_Entity(int id, String cardnumber, String mobilenumber) {
	
	this.id = id;
	this.cardnumber = cardnumber;
	this.mobilenumber = mobilenumber;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCardnumber() {
	return cardnumber;
}

public void setCardnumber(String cardnumber) {
	this.cardnumber = cardnumber;
}

public String getMobilenumber() {
	return mobilenumber;
}

public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}



}
