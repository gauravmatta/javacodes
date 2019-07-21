package com.javaimplant.entities;

public class BankAccount {
int balance;
int previousTranscation;
String customerName;
String customerId;
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public int getPreviousTranscation() {
	return previousTranscation;
}
public void setPreviousTranscation(int previousTranscation) {
	this.previousTranscation = previousTranscation;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
}
