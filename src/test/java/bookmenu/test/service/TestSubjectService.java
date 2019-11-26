package bookmenu.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import bookmenu.entity.SubjectDO;
import bookmenu.repository.SubjectRepository;
import bookmenu.service.SubjectService;


@RunWith(MockitoJUnitRunner.class)
public class TestSubjectService {


	@InjectMocks
	SubjectService subjectService;

	@Mock
	SubjectRepository subjectRepository;

	

	@Test
	public void getAllsubjects() {
		List<SubjectDO> list = new ArrayList<SubjectDO>();
		SubjectDO subject = new SubjectDO();
		subject.setSubjectId(101);
		subject.setSubtitle("Tamil");
		subject.setDurationInHours(50);
		list.add(subject);

		when(subjectRepository.findAll()).thenReturn(list);

		// test
		List<SubjectDO> subList = subjectService.getAllsubjects();

		assertEquals(1, subList.size());
		verify(subjectRepository, times(1)).findAll();
	}

	@Test
	public void getsubject() {
		SubjectDO subject = new SubjectDO();
		subject.setSubjectId(101);
		subject.setSubtitle("Tamil");
		subject.setDurationInHours(50);
		when(subjectRepository.findOne((long)101)).thenReturn(subject);

		// test
		SubjectDO subjectEn = subjectService.getsubject((long)101);

		assertEquals(subjectEn.getSubjectId(),subject.getSubjectId());
		verify(subjectRepository, times(1)).findOne((long)101);
	}

	@Test
	public void addsubject() {
		
		SubjectDO subject = new SubjectDO();
		subject.setSubjectId(101);
		subject.setSubtitle("Tamil");
		subject.setDurationInHours(50);
		
		subjectService.addsubject(subject);

		verify(subjectRepository, times(1)).save(subject);
	}

	@Test
	public void updatesubject() {
		SubjectDO subject = new SubjectDO();
		subject.setSubjectId(101);
		subject.setSubtitle("Tamil");
		subject.setDurationInHours(50);
		
		subjectService.updatesubject(subject);

		verify(subjectRepository, times(1)).save(subject);

	}

	@Test
	public void deletesubject() {
		subjectService.deletesubject((long)101);
		verify(subjectRepository, times(1)).delete((long)101);
	}

	@Test
	public void getsubjectBYDuration() {
		List<SubjectDO> list = new ArrayList<SubjectDO>();
		SubjectDO subject = new SubjectDO();
		subject.setSubjectId(101);
		subject.setSubtitle("Tamil");
		subject.setDurationInHours(50);
		list.add(subject);

		when(subjectRepository.findSubjectByDuration(50)).thenReturn(list);

		// test
		List<SubjectDO> subList = subjectService.getsubjectBYDuration(50);

		assertEquals(1, subList.size());
		verify(subjectRepository, times(1)).findSubjectByDuration(50);
	
	}

}
