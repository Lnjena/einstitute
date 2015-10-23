package com.einstitute.core.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.einstitute.core.repository.AttendanceRepository;
import com.einstitute.core.repository.EntityRepository;
import com.einstitute.core.repository.MasterComponentsRepository;
import com.einstitute.core.repository.config.RepositoryConfig;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {RepositoryConfig.class}, initializers = ConfigFileApplicationContextInitializer.class, loader = SpringApplicationContextLoader.class)
@SpringApplicationConfiguration(classes = {RepositoryConfig.class}, initializers = ConfigFileApplicationContextInitializer.class)
@WebIntegrationTest
public class DomainPersistenceIntegrationTest extends AbstractTestNGSpringContextTests {
	
	private static Logger LOGGER = Logger.getLogger(DomainPersistenceIntegrationTest.class);
	
	private RestTemplate restTemplate = new TestRestTemplate();
	
	@Autowired
	private EntityRepository entityRepository;
	
	@Autowired
	private MasterComponentsRepository masterComponentsRepository;
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	//@Test
	//@BeforeTest()
	public void test_createComponentDefn() {
		MasterComponent component = new MasterComponent("/components/attendance/takeAttendance", "/components/attendance.htm/takeAttendance");
		masterComponentsRepository.insert(component);
	}
	
	//@Test
	public void test_searchComponents() {
		List<MasterComponent> components = masterComponentsRepository.findAll();
		
		for(MasterComponent component : components) {
			LOGGER.info("1. " + component.getUri());
			LOGGER.info("2. " + component.getPath());
		}
	}
	
	//@Test
	public void test_persistEntity() {
		Assert.assertNotNull(entityRepository);
				
		Entity entity = new Entity();
		entity.setEntityId("S1001");
		entity.setEntityType("student");
		List<String> defRoles = new ArrayList<String>();
		defRoles.add("ct");
		defRoles.add("hm");
		entity.setDefaultRoles(defRoles);
		
		entityRepository.insert(entity);
		
		List<Entity> entities = entityRepository.findAll();
		Assert.assertNotNull(entities);
		Assert.assertTrue(entities.size() == 1);
	}
	
	//@Test
	public void test_getRestData() {
		Entity ent = restTemplate.getForObject("http://localhost:8080/entities/S1001", Entity.class);
		LOGGER.info("ent." + ent.getCustomVal());		
	}
	
	//@Test
	public void test_registerAttendance() {
		
		Attendance attendance = new Attendance("cls1_2015", "T201", "cls1_2015_maths", new Date(), new Date(), new ArrayList<AttendanaceReport>());
		attendance.registerAttendance("S101", "1");
		attendance.registerAttendance("S102", "1");
		attendance.registerAttendance("S103", "1");
		attendance.registerAttendance("S104", "1");
		attendance.registerAttendance("S105", "0");
		
		attendanceRepository.save(attendance);
	}
	
	@Test
	public void test_getAttendanceReport() {
		
		List<Attendance> attendances = attendanceRepository.findAll();
		
		for (Attendance attendance : attendances) {
			LOGGER.info("AT E: " + attendance.getAttendanaceReport().get(0).getEntityId());
			LOGGER.info("AT S: " + attendance.getAttendanaceReport().get(0).getAttendanceStatus());
		}
		
		List<Attendance> report = attendanceRepository.findByEntityId("cls1_2015", "cls1_2015_maths", "S102");
		
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
