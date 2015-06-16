package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String alias;
	private String name;
	
	@Column(name = "KM_FROM_TBILISI")
	private String kmFromTbilisi;
	
	@Column(name = "TIME_FROM_TBILISI")
	private String timeFromTbilisi;
	
	@Column(name = "ACCESS_BY_MINIBUS")
	private boolean accessByMinibus;
	
	@Column(name = "SHORT_INFO")
	private String shortInfo;

	@Override
	public String toString() {
		return String.format("<h2><a href=\"%s\">%s</a></h2>\n<p>%s...</p>\n"
				+ "<img id=\"smallImg\" src=\"./images/small/%s.jpg\" >", alias, name,
				shortInfo, alias);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKmFromTbilisi() {
		return kmFromTbilisi;
	}

	public void setKmFromTbilisi(String kmFromTbilisi) {
		this.kmFromTbilisi = kmFromTbilisi;
	}

	public String getTimeFromTbilisi() {
		return timeFromTbilisi;
	}

	public void setTimeFromTbilisi(String timeFromTbilisi) {
		this.timeFromTbilisi = timeFromTbilisi;
	}

	public boolean isAccessByMinibus() {
		return accessByMinibus;
	}

	public void setAccessByMinibus(boolean accessByMinibus) {
		this.accessByMinibus = accessByMinibus;
	}

	public String getShortInfo() {
		return shortInfo;
	}

	public void setShortInfo(String shortInfo) {
		this.shortInfo = shortInfo;
	}

}