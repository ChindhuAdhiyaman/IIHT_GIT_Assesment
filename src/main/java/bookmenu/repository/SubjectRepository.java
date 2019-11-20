package bookmenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bookmenu.entity.SubjectDO;


@Repository("subjectRepository")
public interface SubjectRepository extends CrudRepository<SubjectDO, Long> {

	
	@Query("FROM SubjectDO WHERE durationInHours = ?1")
	List<SubjectDO> findSubjectByDuration(int durationInHours);
	
}
