package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.data.validation.URL;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Speaker extends Model {
	public String firstName;
	@Required
	public String lastName;
	public String title;
	@Type(type="org.hibernate.type.StringClobType")
	@Lob
	@Required
	@MaxSize(10000)
	public String biography;
	public String company;
	@URL
	public String companyURL;
	@URL
	public String blogURL;
	public String twitterAccount;
	
	public Blob photo;
	
	/* La dernière année à laquelle l'orateur a participé au RivieraDEV */
	@MaxSize(4)
	public Integer year;

	@ManyToMany(mappedBy = "speakers")
	public List<Talk> talks = new ArrayList<Talk>();
	
	@Override
	public String toString() {
		return firstName+" "+lastName;
	}
}
