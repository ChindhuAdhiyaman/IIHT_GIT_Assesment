package bookmenu.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmenu.entity.SubjectDO;
import bookmenu.repository.SubjectRepository;

@Service("subjectService")
public class SubjectService {

	
	@Autowired
	SubjectRepository subjectRepository;


	@Transactional
	public List getAllsubjects() {
		List subjects = new ArrayList<SubjectDO>();
		Iterable subjectsIterable = subjectRepository.findAll();
		Iterator subjectsIterator = subjectsIterable.iterator();
		while (subjectsIterator.hasNext()) {
			subjects.add(subjectsIterator.next());
		}
		return subjects;
	}

//	@Transactional
//	public SubjectDO getsubject(Long id) {
//		return subjectRepository.findOne(id);
//	}

	@Transactional
	public void addsubject(SubjectDO subject) {
		subjectRepository.save(subject);
	}

	@Transactional
	public void updatesubject(SubjectDO subject) {
		subjectRepository.save(subject);

	}

//	@Transactional
//	public void deletesubject(Long id) {
//		subjectRepository.delete(id);
//	}

	@Transactional
	public List<SubjectDO> getsubjectBYDuration(int duration) {
		return subjectRepository.findSubjectByDuration(duration);
	}

}
