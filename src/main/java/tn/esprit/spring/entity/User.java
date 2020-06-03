package tn.esprit.spring.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="d_type")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date datedenaissance;
	
	
	@NotBlank
	@Size(max = 50)
	private String adresseuser;
	
	@NotBlank
	@Size(max = 8)
	private Long numtel;
	
	
	@NotBlank
	@Size(max = 120)
	private String password;
	
	private Boolean EtatAcc=true;
	
	@Column(name = "enabled")
    private boolean enabled=false;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id")) 
			
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Boolean etatAcc) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		EtatAcc = etatAcc;
	}



	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,@NotBlank @Size(max = 120) String password,
			 @NotBlank @Size(max = 50) String adresseuser, Date datedenaissance,
			@NotBlank @Size(max = 8) Long numtel) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		
		this.adresseuser = adresseuser;
		this.datedenaissance = datedenaissance;
		
		this.numtel = numtel;
	}

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			Date datedenaissance, @NotBlank @Size(max = 50) String adresseuser, @NotBlank @Size(max = 8) Long numtel,
			@NotBlank @Size(max = 120) String password, Boolean etatAcc, boolean enabled, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.datedenaissance = datedenaissance;
		this.adresseuser = adresseuser;
		this.numtel = numtel;
		this.password = password;
		EtatAcc = etatAcc;
		this.enabled = enabled;
		this.roles = roles;
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			Date datedenaissance, @NotBlank @Size(max = 50) String adresseuser, @NotBlank @Size(max = 8) Long numtel,
			@NotBlank @Size(max = 120) String password, Boolean etatAcc, boolean enabled, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.datedenaissance = datedenaissance;
		this.adresseuser = adresseuser;
		this.numtel = numtel;
		this.password = password;
		EtatAcc = etatAcc;
		this.enabled = enabled;
		this.roles = roles;
	}

	public Date getDatedenaissance() {
		return datedenaissance;
	}

	public void setDatedenaissance(Date datedenaissance) {
		this.datedenaissance = datedenaissance;
	}

	public String getAdresseuser() {
		return adresseuser;
	}

	public void setAdresseuser(String adresseuser) {
		this.adresseuser = adresseuser;
	}

	public Long getNumtel() {
		return numtel;
	}

	public void setNumtel(Long numtel) {
		this.numtel = numtel;
	}

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Boolean etatAcc, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		EtatAcc = etatAcc;
		this.roles = roles;
	}



	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Boolean getEtatAcc() {
		return EtatAcc;
	}

	public void setEtatAcc(Boolean etatAcc) {
		EtatAcc = etatAcc;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
