package bookmenu.application;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import bookmenu.action.Keyin;
import bookmenu.model.Book;
import bookmenu.model.Subject;
import bookmenu.repository.mySQLDAO;


@EnableJpaRepositories(basePackages = { "bookmenu.repository" })
@EnableTransactionManagement
@SpringBootApplication
@ImportResource("classpath:bookmenu-beans-context.xml")
public class MenuDemo {

	@Autowired
	Keyin keyin;

	@Autowired
	mySQLDAO mySqldao;

	/**
	 * @param args
	 */
	public void menuOperations() {

		int option;
		while (true) {
			option = PrintDetails();
			Subject sub = new Subject();
			try {
				// Switch construct
				switch (option) {

				case 1:

					addSubject(sub);

					System.out.println("The Subject details are successfully added :) ");
					break;

				case 2:
					addBook(sub);
					System.out.println("The Book details are successfully added :) ");
					break;

				case 3:
					Integer subDel = keyin.inInt("Enter the Subject ID to be Deleted: ");
					boolean isDeleted = mySqldao.deleteSubject((long) subDel);
					if (isDeleted)
						System.out.println("The Subject details are Deleted ");
					else {
						System.out.println("Sorry, the details given doesnt exist in the file, please try again ");
					}
					break;
				case 4:
					Integer bookDel = keyin.inInt("Enter the Book ID to be Deleted: ");
					boolean isBookDeleted = mySqldao.deleteBook(bookDel);
					if (isBookDeleted)
						System.out.println("The Book details are Deleted ");
					else {
						System.out.println("Sorry, the details given doesnt exist in the file, please try again ");
					}
					break;
				case 5:
					Integer bookName = keyin.inInt("Enter the Book Id to be searched: ");
					boolean searchResult = mySqldao.searchBook(bookName);
					if (searchResult) {
						System.out.println("The Book " + bookName + " is available");
					} else {
						System.out.println("Sorry , The Book " + bookName + " is not available");
					}
					break;
				case 6:
					Integer subName = keyin.inInt("Enter the Subject Id to be searched: ");
					searchResult = mySqldao.searchSubject((long) subName);
					if (searchResult) {
						System.out.println("The Subject " + subName + " is available");
					} else {
						System.out.println("Sorry , The Subject " + subName + " is not available");
					}
					break;
				case 7:

					String title = keyin.inString("Enter the Book Name to be searched: ");
					mySqldao.searchBookBYTitle(title);
					break;

				case 8:
					int durationInHours = keyin.inInt("Enter the Duration of subject to be searched: ");
					mySqldao.searchSubjectBYDuration(durationInHours);
					break;

				default:
					System.out.println("Invalid selection");
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return
	 */
	private int PrintDetails() {
		int swValue;
		System.out.println("|   MENU SELECTION DEMO 	|");
		System.out.println("| 	Options:              	|");
		System.out.println("|  	1. Add a Subject   		|");
		System.out.println("|  	2. Add a Book      		|");
		System.out.println("|  	3. Delete a Subject		|");
		System.out.println("|  	4. Delete a Book   		|");
		System.out.println("|  	5. Search for a Book	|");
		System.out.println("|  	6. Search for a Subject |");
		System.out.println("|  	7. Search a Book By Title  |");
		System.out.println("|  	8. Search subject by duration |");
		swValue = keyin.inInt(" Select option: ");
		return swValue;
	}

	/**
	 * @param sub
	 * @throws SQLException
	 * @throws ParseException
	 */
	private void addSubject(Subject sub) throws SQLException, ParseException {
		String subId = keyin.inString("Select SubjectID to be Added: ");
		sub.setSubjectId(Long.valueOf(subId));
		String Soption = keyin.inString("Select Subject to be Added: ");
		sub.setSubtitle(Soption);
		String Sduration = keyin.inString("Please add the subject hours: ");
		sub.setDurationInHours(Integer.parseInt(Sduration));
		String bReferenceOption = keyin.inString("Do you want to add book reference:Y/N ");
		addReference(sub, bReferenceOption);

	}

	/**
	 * @param sub
	 * @throws SQLException
	 * @throws ParseException
	 */
	private void addBook(Subject sub) throws SQLException, ParseException {
		Book book = new Book();

		Integer bookId = keyin.inInt("Select BookId to be Added: ");
		book.setBookId(bookId);
		String bOption = keyin.inString("Please Enter the Book Title: ");
		book.setTitle(bOption);
		String price = keyin.inString("Please add the price of Book: ");
		book.setPrice(Double.valueOf(price));
		String volume = keyin.inString("Please enter volume of Book: ");
		book.setVolume(Integer.valueOf(volume));
		String publishDate = keyin.inString("Please enter the publish date of Book in YYYY-MM-DD format: ");

		book.setpublishDate(publishDate);

		mySqldao.insertBookTable(book, null);

	}

	/**
	 * @param sub
	 * @param bReferenceOption
	 * @throws SQLException
	 * @throws ParseException
	 */
	private void addReference(Subject sub, String bReferenceOption) throws SQLException, ParseException {
		if (bReferenceOption.equalsIgnoreCase("Y")) {
			addBook(sub);

		} else {
			mySqldao.insertSubjectTable(sub);

		}

	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MenuDemo.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bookmenu-beans-context.xml");
		MenuDemo menuDemo = context.getBean(MenuDemo.class);
		menuDemo.menuOperations();
		context.close();

	}


}
