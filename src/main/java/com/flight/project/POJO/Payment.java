package com.flight.project.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paymentId", unique=true, nullable=false)
	public int paymentId;
	
	
	public String FirstName;
	public String LastName;
	public String BankName;
	public long CreditCard;
	public int ExpirationDate;
	public int ExpirationTime;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public long getCreditCard() {
		return CreditCard;
	}
	public void setCreditCard(long creditCard) {
		CreditCard = creditCard;
	}
	public int getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(int expirationDate) {
		ExpirationDate = expirationDate;
	}
	public int getExpirationTime() {
		return ExpirationTime;
	}
	public void setExpirationTime(int expirationTime) {
		ExpirationTime = expirationTime;
	}
	
	
}
