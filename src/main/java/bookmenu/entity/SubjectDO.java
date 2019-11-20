package bookmenu.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@Table(name="subject")
public class SubjectDO   {
	

	@Id
	@Column(name = "subjectId")
	private long subjectId;

	@Column(name = "bookId")
	private Integer bookId;

	@Column(name = "durationInHours")
	private int durationInHours;

	@Column(name = "subtitle")
	private String subtitle;

	public SubjectDO() {
	}

	public long getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getDurationInHours() {
		return this.durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

}