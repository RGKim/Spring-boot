package com.eightlegged.ksy.user.entity;

import java.io.Serializable;

import com.eightlegged.ksy.user.util.PasswordUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8074038600357994037L;
	
	//User
	private Long id;
	private String name;
	private String lastName;
	private String email;
	private String pass;
	private String confirmPass;
	private String messageValidation;
	//Family
	private Long idFamily;
	private String nameFamily;

	@JsonIgnore
	public boolean isMaster(){
		return id.equals(idFamily);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this. pass  = PasswordUtils.encode(pass);
	}
	/**
	 * @return the confirmPass
	 */
	public String getConfirmPass() {
		return confirmPass;
	}
	/**
	 * @param confirmPass the confirmPass to set
	 */
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = PasswordUtils.encode(pass);
	}
	/**
	 * @return the messageValidation
	 */
	public String getMessageValidation() {
		return messageValidation;
	}
	/**
	 * @param messageValidation the messageValidation to set
	 */
	public void setMessageValidation(String messageValidation) {
		this.messageValidation = messageValidation;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idFamily
	 */
	public Long getIdFamily() {
		return idFamily;
	}

	/**
	 * @param idFamily the idFamily to set
	 */
	public void setIdFamily(Long idFamily) {
		this.idFamily = idFamily;
	}

	/**
	 * @return the nameFamily
	 */
	public String getNameFamily() {
		return nameFamily;
	}

	/**
	 * @param nameFamily the nameFamily to set
	 */
	public void setNameFamily(String nameFamily) {
		this.nameFamily = nameFamily;
	}

}
