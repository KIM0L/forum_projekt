package jsfcourse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrole;

	@Lob
	private String nazwa;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="rola")
	private List<User> users;

	public Rola() {
	}

	public int getIdrole() {
		return this.idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRola(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRola(null);

		return user;
	}

}