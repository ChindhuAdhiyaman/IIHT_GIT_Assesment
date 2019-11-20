package bookmenu.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmenu.entity.BookDO;
import bookmenu.repository.BookMenuRepository;

@Service("bookService")
public class BookService {

	@Autowired
	@Qualifier("bookRepository")
	BookMenuRepository bookRepository;

	@Transactional
	public List getAllBooks() {
		List books = new ArrayList<BookDO>();
		Iterable booksIterable = bookRepository.findAll();
		Iterator booksIterator = booksIterable.iterator();
		while (booksIterator.hasNext()) {
			books.add(booksIterator.next());
		}
		return books;
	}

	@Transactional
	public BookDO getbook(int id) {
		return bookRepository.findOne(id);
	}

	@Transactional
	public void addbook(BookDO book) {
		bookRepository.save(book);
	}

	@Transactional
	public void updatebook(BookDO book) {
		bookRepository.save(book);

	}

	@Transactional
	public void deletebook(int id) {
		bookRepository.delete(id);
	}

	@Transactional
	public List<BookDO> searchBookByTitle(String title) {
		return bookRepository.findBookByTitle(title);
	}

}
