package com.BlogApp.Entities;
import java.util.LinkedList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Post> post=new LinkedList<>();
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
	    name = "user_role",
	    joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
	    inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}
	)
	private List<Role> roles;

	public User(User user) {
		
		
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}

	
		
		
	
	
	
	
}
