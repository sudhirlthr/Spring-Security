/**
 * 
 */
package com.pramati.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sudhirk
 *
 */

@Entity
@Table(name = "users")
public class Users implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Long id;
	
	
	@Column(name="username", unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private Boolean enabled;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "userrole", joinColumns = @JoinColumn(referencedColumnName = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	private Set<Authority> authority = new HashSet<>();

	public Users() {
	}

	public Users(String username, String password, Boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	

	public Users(String username, String password, Boolean enabled, Set<Authority> authoritySet) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authoritySet;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
