package br.com.t4k.user.entity;

public enum Role {
	
	ADMIN, MASTER, MEMBER;
    
	public String authority() {
        return "ROLE_" + this.name();
    }

}
