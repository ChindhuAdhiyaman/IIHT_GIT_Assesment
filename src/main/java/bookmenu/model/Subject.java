  package bookmenu.model;

import java.io.Serializable;
import java.util.Set;

public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long subjectId;
	private String subtitle;
	private int durationInHours;
	private Set<Book> refernces;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public Set<Book> getRefernces() {
		return refernces;
	}

	public void setRefernces(Set<Book> refernces) {
		this.refernces = refernces;
	}

}
