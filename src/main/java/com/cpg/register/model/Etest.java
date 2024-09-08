package com.cpg.register.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="test1")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_Id")
	private long tID;
	@Column(name="test_Name")
	private String tName;
	@Column(name="test_Value")
	private String tValue;
	
	public Long gettID() {
		return tID;
	}
	public void settID(int i) {
		this.tID = i;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettValue() {
		return tValue;
	}
	public void settValue(String tValue) {
		this.tValue = tValue;
	}
	@Override
	public String toString() {
		return "Etest [tID=" + tID + ", tName=" + tName + ", tValue=" + tValue + "]";
	}
	

}
