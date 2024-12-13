package com.container_manager.entities;

import java.util.Date;

import com.container_manager.enums.TransactionType;

public class Transaction {

  private String id;
  private Date date;
  private double amount;
  private TransactionType type;

  public static class TransactionBuilder {
    private Transaction transaction;

    public TransactionBuilder() {
      transaction = new Transaction();
    }

    public TransactionBuilder id(String id) {
      transaction.id = id;
      return this;
    }

    public TransactionBuilder date(Date date) {
      transaction.date = date;
      return this;
    }

    public TransactionBuilder amount(double amount) {
      transaction.amount = amount;
      return this;
    }

    public TransactionBuilder type(TransactionType type) {
      transaction.type = type;
      return this;
    }

    public Transaction build() {
      return transaction;
    }
  }

  public String getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public double getAmount() {
    return amount;
  }

  public TransactionType getType() {
    return type;
  }
}