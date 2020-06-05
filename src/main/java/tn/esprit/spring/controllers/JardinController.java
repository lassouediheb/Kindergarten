package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.User;

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

	private String nomJ;
	private String logoJ;
	private String adresseJ;
	private String numJ;
	private Date dateCrea;
	private String descripJ;
	private float tarifJ;
	private Jardin jardin;
	private User user;
	private long id;
	private long jardinIdToBeUpdated;

	private List<Jardin> jardins;

	public List<Jardin> getJardin() {
		jardins = jardinService.getAllJardin();
		return jardins;
	}
	
	

	public void addJardin() {
		jardinService.addJardin(new Jardin(nomJ, logoJ, adresseJ, numJ, dateCrea, descripJ, tarifJ));
	}

	public void removeJardin(String id) {
		jardinService.deleteJardin(id);
	}

	public void displayJardin(Jardin jardin) {
		this.setNomJ(jardin.getNomJ());
		this.setLogoJ(jardin.getLogoJ());
		this.setAdresseJ(jardin.getAdresseJ());
		this.setNumJ(jardin.getNumJ());
		this.setDateCrea(jardin.getDateCrea());
		this.setDescripJ(jardin.getDescripJ());
		this.setTarifJ(jardin.getTarifJ());
		this.setJardinIdToBeUpdated(jardin.getId());
	}

	public String afficherJardin(Jardin jardin) {
		this.setJardin(jardin);
		this.setId(jardin.getId());
		return "/WEB-INF/jardinadmin.xhtml?faces-redirect=true";
	}
	
	

	public Jardin afficherProfil(String id) {
		jardin = jardinService.retrieveJardin(id);
		return jardin;
	}

	public long getJardinIdToBeUpdated() {
		return jardinIdToBeUpdated;
	}

	public void setJardinIdToBeUpdated(long jardinIdToBeUpdated) {
		this.jardinIdToBeUpdated = jardinIdToBeUpdated;
	}
	
	String a;
	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("idjj");
	}
	public int outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a = getCountryFromJSF(context);
		System.out.println("((((((((((((((((("+a);
		return Integer.parseInt(a);
	}
	
	
	
	public String getA() {
		return a;
	}



	public void setA(String a) {
		this.a = a;
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

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
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

	public JardinController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JardinController(List<Jardin> jardins) {
		super();
		this.jardins = jardins;
	}

}
