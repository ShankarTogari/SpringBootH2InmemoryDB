package org.sfw.boot.h2db.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Lombok ANNOTAIONS ARE NOT WORKING
@Entity
@Table(name = "Customer_Details")
@Setter
@Getter
@ToString
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

}
