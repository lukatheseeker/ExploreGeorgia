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
	private int kmFromTbilisi;

	@Column(name = "TIME_FROM_TBILISI")
	private String timeFromTbilisi;

	@Column(name = "ACCESS_BY_MINIBUS")
	private boolean accessByMinibus;

	@Column(name = "SHORT_INFO")
	private String shortInfo;

	@Column(name = "LARGE_INFO")
	private String largeInfo;

	private int days;

	@Override
	public String toString() {
		return String
				.format("<h2><a href=\"%s.jsp\">%s</a></h2>\n<p>%s...<a id=\"smallLink\" href=\"%s.jsp\">more</a></p>\n"
						+ "<img id=\"smallImg\" src=\"./images/small/%s.jpg\" >",
						alias, name, shortInfo, alias, alias);
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

	public int getKmFromTbilisi() {
		return kmFromTbilisi;
	}

	public void setKmFromTbilisi(int kmFromTbilisi) {
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

	public String getLargeInfo() {
		return largeInfo;
	}

	public void setLargeInfo(String largeInfo) {
		this.largeInfo = largeInfo;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

}