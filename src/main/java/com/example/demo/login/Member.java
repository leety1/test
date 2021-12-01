/*
 * package com.example.demo.login;
 * 
 * import java.sql.Date;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.EnumType; import javax.persistence.Enumerated; import
 * javax.persistence.GeneratedValue; import javax.persistence.Id; import
 * javax.persistence.Table; import javax.persistence.Temporal; import
 * javax.persistence.TemporalType; import javax.validation.constraints.NotBlank;
 * 
 * import org.hibernate.annotations.CreationTimestamp; import
 * org.hibernate.annotations.UpdateTimestamp;
 * 
 * @Entity
 * 
 * @Table(name = "Members") public class Member {
 * 
 * @Id
 * 
 * @GeneratedValue private int seq;
 * 
 * @Column(unique = true)
 * 
 * @NotBlank private String username;
 * 
 * @NotBlank private String password;
 * 
 * @NotBlank private String name;
 * 
 * @NotBlank private String email;
 * 
 * @NotBlank private String address;
 * 
 * @Column(name = "role")
 * 
 * @Enumerated(EnumType.STRING) private UserRole role =
 * UserRole.ROLE_NOT_PERMITTED;
 * 
 *//**
	 * @return the seq
	 */
/*
 * public int getSeq() { return seq; }
 *//**
	 * @param seq the seq to set
	 */
/*
 * public void setSeq(int seq) { this.seq = seq; }
 *//**
	 * @return the username
	 */
/*
 * public String getUsername() { return username; }
 *//**
	 * @param username the username to set
	 */
/*
 * public void setUsername(String username) { this.username = username; }
 *//**
	 * @return the password
	 */
/*
 * public String getPassword() { return password; }
 *//**
	 * @param password the password to set
	 */
/*
 * public void setPassword(String password) { this.password = password; }
 *//**
	 * @return the name
	 */
/*
 * public String getName() { return name; }
 *//**
	 * @param name the name to set
	 */
/*
 * public void setName(String name) { this.name = name; }
 *//**
	 * @return the email
	 */
/*
 * public String getEmail() { return email; }
 *//**
	 * @param email the email to set
	 */
/*
 * public void setEmail(String email) { this.email = email; }
 *//**
	 * @return the address
	 */
/*
 * public String getAddress() { return address; }
 *//**
	 * @param address the address to set
	 */
/*
 * public void setAddress(String address) { this.address = address; }
 *//**
	 * @return the role
	 */
/*
 * public UserRole getRole() { return role; }
 *//**
	 * @param role the role to set
	 */
/*
 * public void setRole(UserRole role) { this.role = role; }
 *//**
	 * @return the createAt
	 */
/*
 * public Date getCreateAt() { return createAt; }
 *//**
	 * @param createAt the createAt to set
	 */
/*
 * public void setCreateAt(Date createAt) { this.createAt = createAt; }
 *//**
	 * @return the updateAt
	 */
/*
 * public Date getUpdateAt() { return updateAt; }
 *//**
	 * @param updateAt the updateAt to set
	 *//*
		 * public void setUpdateAt(Date updateAt) { this.updateAt = updateAt; }
		 * 
		 * @Temporal(TemporalType.TIMESTAMP)
		 * 
		 * @CreationTimestamp private Date createAt;
		 * 
		 * @Temporal(TemporalType.TIMESTAMP)
		 * 
		 * @UpdateTimestamp private Date updateAt;
		 * 
		 * public Object getMemberRoles() { // TODO Auto-generated method stub return
		 * null; }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */