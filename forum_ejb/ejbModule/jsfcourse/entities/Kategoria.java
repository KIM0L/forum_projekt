package jsfcourse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategoria database table.
 * 
 */
@Entity
@NamedQuery(name="Kategoria.findAll", query="SELECT k FROM Kategoria k")
public class Kategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkategoria;

	@Lob
	private String nazwa;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="kategoria")
	private List<Post> posts;

	public Kategoria() {
	}

	public int getIdkategoria() {
		return this.idkategoria;
	}

	public void setIdkategoria(int idkategoria) {
		this.idkategoria = idkategoria;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setKategoria(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setKategoria(null);

		return post;
	}

}