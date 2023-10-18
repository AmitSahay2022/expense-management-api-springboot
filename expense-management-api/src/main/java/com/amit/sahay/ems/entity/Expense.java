package com.amit.sahay.ems.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "Expenses")
@Data
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long expenseId;
	@Column(nullable = false)
	private String name;

	private String description;
	@Column(nullable = false)
	private BigDecimal amount;
	private String category;
	private Date date;
	@CreationTimestamp
	@Column(name = "created-at", updatable = false)
	private Timestamp createdAt;
	@UpdateTimestamp
	@Column(name = "updated-at")
	private Timestamp updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "user-id", nullable = false)	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
}
