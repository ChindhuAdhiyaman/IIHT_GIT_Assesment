//package bookmenu.test.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import bookmenu.entity.BookDO;
//import bookmenu.repository.BookMenuRepository;
//import bookmenu.service.BookService;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TestBookService {
//
//	@InjectMocks
//	BookService bookService;
//
//	@Mock
//	BookMenuRepository bookRepository;
//
//	
//	@Test
//	public void getAllBooksTest() {
//
//		List<BookDO> list = new ArrayList<BookDO>();
//		BookDO book = new BookDO();
//		book.setBookId(1001);
//		book.setPrice(499);
//		book.setPublishDate(Date.valueOf("2008-09-09"));
//		book.setTitle("Thirukkural");
//		book.setVolume(50);
//		list.add(book);
//
//		when(bookRepository.findAll()).thenReturn(list);
//
//		// test
//		List<BookDO> bookList = bookService.getAllBooks();
//
//		assertEquals(1, bookList.size());
//		verify(bookRepository, times(1)).findAll();
//
//	}
//
//	@Test
//	public void getbookByIdTest() {
//		BookDO book = new BookDO();
//		book.setBookId(1001);
//		book.setPrice(499);
//		book.setPublishDate(Date.valueOf("2008-09-09"));
//		book.setTitle("Thirukkural");
//		book.setVolume(50);
//		
//
//		when(bookRepository.findOne(1001)).thenReturn(book);
//
//		// test
//		BookDO bookEn = bookService.getbook(1001);
//
//		assertEquals(bookEn.getBookId(),book.getBookId());
//		verify(bookRepository, times(1)).findOne(1001);
//	}
//
//	@Test
//	public void addbookTest() {
//
//		BookDO book = new BookDO();
//		book.setBookId(1001);
//		book.setPrice(499);
//		book.setPublishDate(Date.valueOf("2008-09-09"));
//		book.setTitle("Thirukkural");
//		book.setVolume(50);
//		
//		bookService.addbook(book);
//
//		verify(bookRepository, times(1)).save(book);
//	}
//
//	@Test
//	public void updatebookTest() {
//		BookDO book = new BookDO();
//		book.setBookId(1001);
//		book.setPrice(399);
//		book.setPublishDate(Date.valueOf("2008-09-09"));
//		book.setTitle("Thirukkural");
//		book.setVolume(50);
//		
//		bookService.updatebook(book);
//
//		verify(bookRepository, times(1)).save(book);
//	}
//
//	@Test
//	public void deletebookTest() {
//
//		bookService.deletebook(1001);
//		verify(bookRepository, times(1)).delete(1001);;
//	}
//
//	@Test
//	public void searchBookByTitleTest() {
//
//		List<BookDO> bookList = new ArrayList<BookDO>();
//		BookDO book = new BookDO();
//		book.setBookId(1001);
//		book.setPrice(499);
//		book.setPublishDate(Date.valueOf("2008-09-09"));
//		book.setTitle("Thirukkural");
//		book.setVolume(50);
//		bookList.add(book);
//
//		when(bookRepository.findBookByTitle("Thirukkural")).
//		thenReturn(bookList);
//
//		// test
//		List<BookDO> bookEn = bookService.searchBookByTitle("Thirukkural");
//
//		assertEquals(1,bookEn.size());
//		verify(bookRepository, times(1)).findBookByTitle("Thirukkural");
//		
//	}
//
//}
