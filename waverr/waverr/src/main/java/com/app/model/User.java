package com.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.app.model.enums.Gender;
import com.app.model.enums.ProfileType;
import com.app.model.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "public")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "first_name" , length = 50)
	private String firstName;
	
	@Column(name = "last_name" , length = 50)
	private String lastName;
	
	@Column(name = "email" , length = 100 , unique = true)
	private String email;
	
	@Column(name = "created_At")
	private LocalDateTime createdAt;
	
	@Column(name = "phone_number", length = 10 , unique = true)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "profile_type" )
	private ProfileType profileType;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Roles role;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "profile_name", length = 100)
	private String profileName;
	
	@Column(name = "reset_pass_otp")
	private String resetPassOtp;
	
	@Column(name = "reset_pass_time")
	private LocalDateTime resetPassTime;
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name="latitude")
	private double latitude;

	@Lob
    @Column(name = "profile_pic")
    private byte[] profilePic;
	
	@Column(name = "user_bio" , length = 50)
	private String bio;
	
	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
		this.role = this.role == null ? Roles.USER : this.role;
		this.profileType = this.profileType == null ? ProfileType.PUBLIC : this.profileType;
	}
	
	@PreUpdate
	public void preUpdate() {
		this.lastUpdated = LocalDateTime.now();
	}
	
}
