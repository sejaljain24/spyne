package com.backend.spyne.entity;

import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Entity
//@Getter
//@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "u")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @NotEmpty(message = "Name is required")
	    private String name;

	    @NotEmpty(message = "Mobile number is required")
	    @Column(unique = true)
	    private String mobileNo;

	    @Email(message = "Email should be valid")
	    @NotEmpty(message = "Email is required")
	    @Column(unique = true)
	    private String email;

	    @NotEmpty(message = "Password is required")
	    private String password;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_followers",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "follower_id"))
	    private Set<User> followers = new HashSet<>();

	    @ManyToMany(mappedBy = "followers")
	    private Set<User> following = new HashSet<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Set<User> getFollowers() {
			return followers;
		}

		public void setFollowers(Set<User> followers) {
			this.followers = followers;
		}

		public Set<User> getFollowing() {
			return following;
		}

		public void setFollowing(Set<User> following) {
			this.following = following;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", email=" + email + ", password="
					+ password + ", followers=" + followers + ", following=" + following + ", getId()=" + getId()
					+ ", getName()=" + getName() + ", getMobileNo()=" + getMobileNo() + ", getEmail()=" + getEmail()
					+ ", getPassword()=" + getPassword() + ", getFollowers()=" + getFollowers() + ", getFollowing()="
					+ getFollowing() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}
	    
	    

}
