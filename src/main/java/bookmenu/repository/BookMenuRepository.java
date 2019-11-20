package bookmenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bookmenu.entity.BookDO;


@Repository("bookRepository")
public interface BookMenuRepository extends CrudRepository<BookDO, Integer> {

	@Query("FROM BookDO WHERE title = ?1")
	List<BookDO> findBookByTitle(String title);

}
