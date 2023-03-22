package com.mongodemoproj.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TEST_COLLECTION")
public class Mongotest {

//	@Id //Its important to keep this annotation for fetching the same document and updating the same.Else new document
		//Will be inserted during updation.
	private String id; // Keeping this wil also work --- with out annotation.
	private String aa;
	private String ss;
	private String dd;
	private String ff;
	public String getAa() {
		return aa;
	}
	public void setAa(String aa) {
		this.aa = aa;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getFf() {
		return ff;
	}
	public void setFf(String ff) {
		this.ff = ff;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Mongotest [id=" + id + ", aa=" + aa + ", ss=" + ss + ", dd=" + dd + ", ff=" + ff + "]";
	}
	
	

	
}
