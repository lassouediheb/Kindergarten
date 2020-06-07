package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Directeurs;
import tn.esprit.spring.entity.ERole;
import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.JardinRepository;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.JardinService;

import tn.esprit.spring.services.UserService;

@Scope(value = "session")
@Controller(value = "jardinController")
@ELBeanName(value = "jardinController")
@Join(path = "/jardin", to = "/jardin.jsf")
public class JardinController {

	@Autowired
	JardinService jardinService;

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JardinRepository jardinRepository;

	private long jardinIdToBeUpdated;

	private Jardin jardin;
	private String nomJ;
	private String logoJ;
	private String adresseJ;
	private String numJ;
	private Date dateCrea;
	private String descripJ;
	private float tarifJ;

	private User user;
	private long id;
	private String username;
	private String email;
	private String password;
	private Boolean EtatAcc;
	private boolean enabled;
	private Set<Role> roles;

	private Directeurs directeurs;
	private String nomD;

	// Afficher liste des jardins
	private List<Jardin> jardins;

	public List<Jardin> getJardin() {
		jardins = jardinService.getAllJardin();
		return jardins;
	}

	// Ajouter un jardin
	public void addJardin() {
		jardinService.addJardin(new Jardin(nomJ, logoJ, adresseJ, numJ, dateCrea, descripJ, tarifJ));
	}

	// Modifier un jardin
	public void updateJardin() {
		Jardin jardin = new Jardin(jardinIdToBeUpdated, username, email, encoder.encode(password), true, nomJ, logoJ,
				adresseJ, numJ, dateCrea, descripJ, tarifJ);
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_JARDINDENFANT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		jardin.setRoles(roles);
		userRepository.save(jardin);
	}

	// Supprimer un jardin
	public void removeJardin(long id) {
		userRepository.deleteById(id);
	}

	// Display jardin
	public void displayJardin(Jardin jardin) {
		this.setUsername(jardin.getUsername());
		this.setPassword(jardin.getPassword());
		this.setNomJ(jardin.getNomJ());
		this.setLogoJ(jardin.getLogoJ());
		this.setAdresseJ(jardin.getAdresseJ());
		this.setNumJ(jardin.getNumJ());
		this.setDateCrea(jardin.getDateCrea());
		this.setDescripJ(jardin.getDescripJ());
		this.setTarifJ(jardin.getTarifJ());
		this.setEmail(jardin.getEmail());
		this.setJardinIdToBeUpdated(jardin.getId());
	}

	// Get jardin by id
	public Jardin jardinprofil(Jardin jardin) {
		return jardinRepository.getJardById(jardin.getId());
	}

	// Get jardin by id
	public Jardin jardindetail(long id) {
		return jardinRepository.getJardById(id);
	}

	// Passer le param idJardin à une autre view
	String a;

	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("idjj");
	}

	public int outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a = getCountryFromJSF(context);
		System.out.println("(((((((((((((((((" + a);
		return Integer.parseInt(a);
	}

	// Passer paramètre idJardin pour afficher details jardin
	private long idJ;

	public String detailsjardin(Jardin jardin) {
		this.setJardin(jardin);
		this.setIdJ(jardin.getId());
		return "jardindetailjardin.xhtml?faces-redirect=true";
	}

	public long getIdJ() {
		return idJ;
	}

	public void setIdJ(long idJ) {
		this.idJ = idJ;
	}

	public JardinService getJardinService() {
		return jardinService;
	}

	public void setJardinService(JardinService jardinService) {
		this.jardinService = jardinService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public long getJardinIdToBeUpdated() {
		return jardinIdToBeUpdated;
	}

	public void setJardinIdToBeUpdated(long jardinIdToBeUpdated) {
		this.jardinIdToBeUpdated = jardinIdToBeUpdated;
	}

	public String getNomJ() {
		return nomJ;
	}

	public void setNomJ(String nomJ) {
		this.nomJ = nomJ;
	}

	public String getLogoJ() {
		return logoJ;
	}

	public void setLogoJ(String logoJ) {
		this.logoJ = logoJ;
	}

	public String getAdresseJ() {
		return adresseJ;
	}

	public void setAdresseJ(String adresseJ) {
		this.adresseJ = adresseJ;
	}

	public String getNumJ() {
		return numJ;
	}

	public void setNumJ(String numJ) {
		this.numJ = numJ;
	}

	public Date getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public String getDescripJ() {
		return descripJ;
	}

	public void setDescripJ(String descripJ) {
		this.descripJ = descripJ;
	}

	public float getTarifJ() {
		return tarifJ;
	}

	public void setTarifJ(float tarifJ) {
		this.tarifJ = tarifJ;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Jardin> getJardins() {
		return jardins;
	}

	public void setJardins(List<Jardin> jardins) {
		this.jardins = jardins;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public JardinController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JardinController(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ,
			float tarifJ, long id) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
		this.id = id;
	}

	public JardinController(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ,
			float tarifJ) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
	}

	public JardinController(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ,
			float tarifJ, User user, long id) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
		this.user = user;
		this.id = id;
	}

	public JardinController(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ,
			float tarifJ, User user) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
		this.user = user;
	}

	public JardinController(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ,
			float tarifJ, long id, String username, String email, String password, boolean enabled) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public JardinController(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ,
			float tarifJ, long id, String username, String email, String password) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public JardinRepository getJardinRepository() {
		return jardinRepository;
	}

	public void setJardinRepository(JardinRepository jardinRepository) {
		this.jardinRepository = jardinRepository;
	}

	public PasswordEncoder getEncoder() {
		return encoder;
	}

	public void setEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public Directeurs getDirecteurs() {
		return directeurs;
	}

	public void setDirecteurs(Directeurs directeurs) {
		this.directeurs = directeurs;
	}

	public String getNomD() {
		return nomD;
	}

	public void setNomD(String nomD) {
		this.nomD = nomD;
	}

}
