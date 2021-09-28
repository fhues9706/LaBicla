package mx.ipn.upiicsa.segsw.labicla.valueobject;

import java.io.Serializable;
/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class JokeValueObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String jokeCreatorEmail;
	private String name;
	private String category;
	private String keyWords;
	private String content;
	private String image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJokeCreatorEmail() {
		return jokeCreatorEmail;
	}
	public void setJokeCreatorEmail(String jokeCreatorEmail) {
		this.jokeCreatorEmail = jokeCreatorEmail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
