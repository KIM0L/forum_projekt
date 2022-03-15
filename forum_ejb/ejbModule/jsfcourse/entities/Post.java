package jsfcourse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the post database table.
 * 
 */
@Entity
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpost;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Lob
	private String tresc;

	//bi-directional many-to-one association to Kategoria
	@ManyToOne
	private Kategoria kategoria;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Post() {
	}

	public int getIdpost() {
		return this.idpost;
	}

	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTresc() {
		return this.tresc;
	}

	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

	public Kategoria getKategoria() {
		return this.kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}