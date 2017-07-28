package com.eightlegged.ksy.user.entity;

public enum Role {
	
	ADMIN, MASTER, MEMBER;
    
	public String authority() {
        return "ROLE_" + this.name();
    }

}
