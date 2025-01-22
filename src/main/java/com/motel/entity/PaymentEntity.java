package com.motel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  paymentId;
	private Integer reservation_id;
	private Integer user_id;
	private Float amount;
	private String  payment_date;
	private Integer payment_method ; //ENUM('credit_card', 'paypal', 'bank_transfer')
	private Integer  status;  //ENUM('pending', 'completed', 'failed', 'refunded')
	private String transaction_id;
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(Integer reservation_id) {
		this.reservation_id = reservation_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public Integer getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(Integer payment_method) {
		this.payment_method = payment_method;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	
}
