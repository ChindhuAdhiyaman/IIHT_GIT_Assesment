//package bookmenu.test.repository;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.ServletTestExecutionListener;
//
//import bookmenu.entity.SubjectDO;
//import bookmenu.repository.SubjectRepository;
//
//@RunWith(SpringRunner.class)
//@TestExecutionListeners(listeners = { SpringBootDependencyInjectionTestExecutionListener.class,
//		ServletTestExecutionListener.class })
//@ContextConfiguration("classpath:bookmenu-beans-context.xml")
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class TestSubjectRepository {
//
//	
//	
//	@Autowired
//	private SubjectRepository subRepository;
//
//	/**
//	 * findBookByTitle
//	 */
//	@Test
//	public void findSubjectByDuration() {
//
//		SubjectDO subject = new SubjectDO();
//		subject.setSubjectId(101);
//		subject.setDurationInHours(30);
//		subject.setSubtitle("Tamil");
//
//		subRepository.save(subject);
//
//		List<SubjectDO> found = subRepository.findSubjectByDuration(30);
//		assertEquals(1, found.size());
//	}
//	
//	@Test
//	public void findSubject() {
//
//
//		SubjectDO subject = new SubjectDO();
//		subject.setSubjectId(101);
//		subject.setDurationInHours(30);
//		subject.setSubtitle("Tamil");
//
//		subRepository.save(subject);
//
//		SubjectDO found = subRepository.findOne((long)101);
//		assertEquals(found.getSubjectId(), subject.getSubjectId());
//
//	}
//
//}
