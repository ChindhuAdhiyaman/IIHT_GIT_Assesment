package bookmenu.model;

import java.io.*;
import java.util.Set;

 public class BookComponents implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient long subjectId;
	private transient String subtitle;
	private transient int durationInHours;
	private transient Set<Book> refernces;
	private transient Subject subject;

	// Default constructor
	public BookComponents(Subject sub) {

		this.subjectId = sub.getSubjectId();
		this.subtitle = sub.getSubtitle();
		this.durationInHours = sub.getDurationInHours();
		this.refernces = sub.getRefernces();
		this.subject = sub;
	}

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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
