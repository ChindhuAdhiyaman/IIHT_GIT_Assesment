package bookmenu.test.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.ServletTestExecutionListener;

import bookmenu.entity.BookDO;
import bookmenu.repository.BookMenuRepository;

@RunWith(SpringRunner.class)
@TestExecutionListeners(listeners = { SpringBootDependencyInjectionTestExecutionListener.class,
		ServletTestExecutionListener.class })
@ContextConfiguration("classpath:bookmenu-beans-context.xml")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestBookRepository {

	@Autowired
	private BookMenuRepository bookRepository;

	/**
	 * findBookByTitle
	 */
	@Test
	public void findBookByTitle() {

		BookDO book = new BookDO();
		book.setBookId(1001);
		book.setPrice(499);
		book.setPublishDate(Date.valueOf("2008-09-09"));
		book.setTitle("Thirukkural");
		book.setVolume(50);

		bookRepository.save(book);

		List<BookDO> found = bookRepository.findBookByTitle("Thirukkural");
		assertEquals(1, found.size());
	}

	/**
	 * findBook
	 */
	@Test
	public void findBook() {

		BookDO book = new BookDO();
		book.setBookId(1001);
		book.setPrice(499);
		book.setPublishDate(Date.valueOf("2008-09-09"));
		book.setTitle("Thirukkural");
		book.setVolume(50);

		bookRepository.save(book);

		BookDO found = bookRepository.findOne(1001);
		assertEquals(found.getBookId(), book.getBookId());

	}

	@Test
	public void findALLBook() {

		List<BookDO> found = (List<BookDO>) bookRepository.findAll();
		assertEquals(4, found.size());
	}

}
