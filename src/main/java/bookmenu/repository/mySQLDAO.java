package bookmenu.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bookmenu.entity.BookDO;
import bookmenu.entity.SubjectDO;
import bookmenu.model.Book;
import bookmenu.model.Subject;
import bookmenu.service.BookService;
import bookmenu.service.SubjectService;


@Component("mySQLDAO")
public class mySQLDAO  {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "pass@word1";

	@Autowired
	BookService bookService;
	
	@Autowired
	SubjectService subjectService = new SubjectService();
	
	/**
	 * @param conn
	 * @param stmt
	 * @throws SQLException
	 */
//	public boolean deleteBook(Integer bookId) throws SQLException {
//		boolean isDeleted = true;
//
//		bookService.deletebook(bookId);
//
//		return isDeleted;
//	}


	/**
	 * @param subId
	 * @return
	 * @throws SQLException
	 */
//	public boolean deleteSubject(Long subId) throws SQLException {
//
//		boolean isDeleted = true;
//		
//		subjectService.deletesubject(subId);
//		
//		return isDeleted;
//	}



	/**
	 * @param  
	 * @param conn
	 * @param stmt
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void insertBookTable(Book book, Long subId) throws SQLException, ParseException {

		BookDO entity = new BookDO();
		if(book != null) {

			LocalDate date = LocalDate.parse(book.getpublishDate());
			Date dateFormat = Date.valueOf(date) ;

			entity.setBookId((int) book.getBookId());
			entity.setTitle(book.getTitle());
			entity.setPrice(book.getPrice());
			entity.setVolume(book.getVolume());
			entity.setPublishDate(dateFormat);
			bookService.addbook(entity);


		}

	}

	/**
	 * @param conn
	 * @param stmt
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public void insertSubjectTable(Subject sub) throws SQLException, ParseException {

		SubjectDO entity = new SubjectDO();
		if(sub != null) {

			entity.setSubjectId(sub.getSubjectId());
			entity.setSubtitle(sub.getSubtitle());
			entity.setDurationInHours(sub.getDurationInHours());

			subjectService.addsubject(entity);

		}

		if (sub.getRefernces() != null) {

			for (Book book : sub.getRefernces())
				insertBookTable(book,sub.getSubjectId());
		}

		System.out.println("Subject " + sub.getSubtitle() + " Details are inserted");

	}


	/**
	 * @param bookId
	 * @return
	 * @throws SQLException
	 */
//	public boolean searchBook(Integer bookId) throws SQLException {
//
//		Boolean isAvailable = false;
//		BookDO book = new BookDO();		
//		book=bookService.getbook(bookId);
//		if(book!=null) {
//			isAvailable = true;
//		}
//
//		return isAvailable;
//	}


//	public boolean searchSubject(Long subjectId) throws SQLException {
//
//		boolean isAvailable = false;
//		SubjectDO subject = new SubjectDO();
//
//		subject = subjectService.getsubject(subjectId);
//		if(subject!=null) {
//			isAvailable = true;
//		}
//
//		return isAvailable;
//	}
	
	/**
	 * @throws SQLException
	 */
	public void searchBookBYTitle(String title) throws SQLException {

		List<BookDO> bookList = new ArrayList<BookDO>();

		bookList = bookService.searchBookByTitle(title);
		if(!bookList.isEmpty()) {

			for(BookDO b : bookList) {

				System.out.println("Book ID ::" + b.getBookId());
				System.out.println("Book Title ::" + b.getTitle());
				System.out.println("Book Price :: " + b.getPrice());
				System.out.println("Book Volume :: " + b.getVolume());
				System.out.println("Book PublishDate :: " + b.getPublishDate());	}
		}else {
			System.out.println("The searched Book "+ title + " is not available");

		}
	}
	
	/**
	 * @throws SQLException
	 */
	public void searchBookBYPublishDate() throws SQLException {

		List<BookDO> bookList = new ArrayList<BookDO>();

		bookList = getBook();
		
		if(bookList!=null) {

		final List<BookDO> sortedList = bookList.stream().sorted((o1, o2) -> o1.getPublishDate().compareTo(o2.getPublishDate())).collect(Collectors.toList());
		System.out.println("**Sorted list based on Book Publish Date:*** " );

		for(BookDO b : sortedList) {
			
			System.out.println("Book ID ::" + b.getBookId());
			System.out.println("Book Title ::" + b.getTitle());
			System.out.println("Book Price :: " + b.getPrice());
			System.out.println("Book Volume :: " + b.getVolume());
			System.out.println("Book PublishDate :: " + b.getPublishDate());	}
		}

	}



	/**
	 * @return
	 */
	public List<BookDO> getBook()  {

		List<BookDO> bookList = new ArrayList<BookDO>();
		
			bookList=bookService.getAllBooks();

			
		return bookList;
	
	}
	
	
	public void searchSubjectBYDuration(int duration ) throws SQLException {

		List<SubjectDO> subList = new ArrayList<SubjectDO>();
		
		subList = subjectService.getsubjectBYDuration(duration);
		
			if(subList!=null) {
			
			
			for(SubjectDO subject : subList) {
				
				System.out.println("Subject ID :: " + subject.getSubjectId());
				System.out.println("Subject Title :: " + subject.getSubtitle());
				System.out.println("Subject DurationHrs :: " + subject.getDurationInHours());
			}
			
		}
	}
}
		
	




