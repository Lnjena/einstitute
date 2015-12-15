package com.einstitute.core.domain;


import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.einstitute.core.domain.Transaction.Status;
import com.einstitute.core.domain.schedule.Frequency;
import com.einstitute.core.domain.schedule.FrequencyType;
import com.einstitute.core.domain.schedule.Schedule;
import com.einstitute.core.repository.ActivityRepository;
import com.einstitute.core.repository.AttendanceRepository;
import com.einstitute.core.repository.CanteenInventoryRepository;
import com.einstitute.core.repository.EntityGroupRepository;
import com.einstitute.core.repository.EntityPermissionRepository;
import com.einstitute.core.repository.EntityRepository;
import com.einstitute.core.repository.LibraryRepository;
import com.einstitute.core.repository.MasterComponentsRepository;
import com.einstitute.core.repository.OrganisationRepository;
import com.einstitute.core.repository.ScheduleRepository;
import com.einstitute.core.repository.TransactionRepository;
import com.einstitute.core.repository.WalletRepository;
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
	
	@Autowired
	private EntityGroupRepository entityGroupRepository;
	
	@Autowired
	private OrganisationRepository organisationRepository;
	
	@Autowired
	private EntityPermissionRepository entityPermissionRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private CanteenInventoryRepository canteenInventoryRepository;
	
	@Autowired
	private OrderCartRepository orderCartRepository;
	
	//@Test
	public void test_createComponentDefn() {
		MasterComponent component = new MasterComponent("/components/attendance/takeAttendance", "/components/attendance.htm/takeAttendance");
		masterComponentsRepository.save(component);
	}
	
	//@Test
	public void test_searchComponents() {
		List<MasterComponent> components = masterComponentsRepository.findAll();
		
		for(MasterComponent component : components) {
			LOGGER.info("1. " + component.getUri());
			LOGGER.info("2. " + component.get_id());
		}
	}
	
	//@Test
	public void test_persistEntity() {
		Assert.assertNotNull(entityRepository);
		
		List<Permission> modulePermissions = Arrays.asList(
				new Permission("/attendance", PermissionType.MANAGE), 
				new Permission("/reports", PermissionType.VIEW), 
				new Permission("/calendar", PermissionType.MANAGE), 
				new Permission("/notices", PermissionType.MANAGE));
		
		List<Permission> pathPermissions = Arrays.asList(
				new Permission("/attendance/history", PermissionType.VIEW),
				new Permission("/reports/history", PermissionType.VIEW));
		
		List<Permission> elementPermissions = Arrays.asList(
				new Permission("/attendance/history/mail", PermissionType.VIEW),
				new Permission("/reports/history/mail", PermissionType.VIEW));
				
		ComponentPermission userPermission = new ComponentPermission(modulePermissions, pathPermissions, elementPermissions);
		
		
		EntityPermission entityPermission = new EntityPermission("T1002", userPermission, null, null);
				
		entityPermissionRepository.insert(entityPermission);
		
		List<EntityPermission> entities = entityPermissionRepository.findAll();
		Assert.assertNotNull(entities);
	}
	
	
	//@Test(dependsOnMethods={"test_persistEntity"})
	public void test_createGroupPermission() {
		List<Permission> modulePermissions = new ArrayList<Permission>();
		List<Permission> pathPermissions = new ArrayList<Permission>();
		List<Permission> elementPermissions = new ArrayList<Permission>();
		
		
		modulePermissions.add(new Permission("/attendance", PermissionType.MANAGE));
		modulePermissions.add(new Permission("/reports", PermissionType.VIEW));
		modulePermissions.add(new Permission("/calendar", PermissionType.MANAGE));
		modulePermissions.add(new Permission("/notices", PermissionType.MANAGE));
		
		pathPermissions.add(new Permission("/attendance/history", PermissionType.VIEW));
		pathPermissions.add(new Permission("/reports/history", PermissionType.VIEW));
		
		elementPermissions.add(new Permission("/attendance/history/mail", PermissionType.VIEW));
		elementPermissions.add(new Permission("/reports/history/mail", PermissionType.VIEW));
		
		ComponentPermission groupPermission = new ComponentPermission("2015_CLS2", modulePermissions, pathPermissions, elementPermissions);
		
		
		EntityPermission entity = entityPermissionRepository.findOne("T1001");
		
		assertNotNull(entity);
		
		List<ComponentPermission> groupPermissions = entity.getGroupsPermissions();
		if(groupPermissions == null) {
			groupPermissions = new ArrayList<ComponentPermission>();
		}
		groupPermissions.add(groupPermission);
		entity.setGroupsPermissions(groupPermissions);
		
		entityPermissionRepository.save(entity);
		
		List<Entity> entities = entityRepository.findAll();
		Assert.assertNotNull(entities);
		//Assert.assertTrue(entities.size() == 1);
		
	}
	

	//@Test
	public void test_getRestData() {
		Entity ent = restTemplate.getForObject("http://localhost:8080/entities/S1001", Entity.class);
		//LOGGER.info("ent." + ent.getCustomVal());		
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
	
	//@Test
	//TODO
	public void test_updateAttendance() {
		
		Attendance attendance = new Attendance("cls1_2015", "T201", "cls1_2015_maths", new Date(), new Date(), new ArrayList<AttendanaceReport>());
		attendance.registerAttendance("S101", "1");
		attendance.registerAttendance("S102", "1");
		attendance.registerAttendance("S103", "1");
		attendance.registerAttendance("S104", "1");
		attendance.registerAttendance("S105", "0");
		
		attendanceRepository.save(attendance);
	}
	
	//@Test
	public void test_getAttendanceReport() {
		
		List<Attendance> attendances = attendanceRepository.findAll();
		
		/*for (Attendance attendance : attendances) {
			LOGGER.info("AT E: " + attendance.getAttendanaceReport().get(0).getEntityId());
			LOGGER.info("AT S: " + attendance.getAttendanaceReport().get(0).getAttendanceStatus());
		}*/
		
		List<Attendance> report = attendanceRepository.getAttendanceHistory("cls1_2015", "cls1_2015_maths", "S102");
		
		for (Attendance attendance : report) {
			LOGGER.info("AT E: " + attendance.getAttendanaceReport().size());
			LOGGER.info("AT S: " + attendance.getAttendanaceReport().get(0).getAttendanceStatus());
		}
		
		
	}
	
	//@Test
	public void test_createOrganisation() {
		Organisation org = new Organisation("in.del.del.north.dps5657", null, true);
		organisationRepository.save(org);
		
		//Entity ent = new Entity("in.del.del.north.dps5657.2015.cls1.S1001", "STUDENT", "in.del.del.north.dps5657");
		Entity ent = new Entity("in.del.del.north.dps5657.2015.cls1.S1001", "STUDENT", "in.del.del.north.dps5657", null, null, null);
		
		entityRepository.save(ent);
	}
	
	//@Test
	public void test_createGroup() {
		List<Entity> teachers = entityRepository.findByEntityType("teacher");
		EntityGroup entityGroup = new EntityGroup("tch_2015", "Teachers 2015", new Date(), new Date(2016, 04, 30));
		entityGroup.setGroupMembers(teachers);
		//entityGroupRepository.save(entityGroup);
		
		
		List<Entity> students = entityRepository.findByEntityType("student");
		EntityGroup studentGrp = new EntityGroup("cls1_2015", "Students 2015", new Date(), new Date(2016, 04, 30));
		entityGroup.setGroupMembers(students);
		entityGroupRepository.save(studentGrp);
		
		sleep();
	}
	
	
	//@Test
	public void test_createSchedule() {
		Schedule every_n_days = new Schedule(new Frequency(FrequencyType.MonthsOfYear.JAN, FrequencyType.MonthsOfYear.FEB));
		
		//Activity activity = new Activity("Spring Fest", every_n_days);
		List<String> groupIds = new ArrayList<String>();
		groupIds.add("cls1_2015");
		Activity activity2 = new Activity("in.del.del.north.dps5657.2015.cls1.S1001", groupIds, "Spring Fest", every_n_days, true, new ObjectId("56374c0f600195dec64c9a38"));
		
		activityRepository.save(activity2);
	}
	
	//@Test
	public void test_createWallet() {
		
		String transactionId = "RFC234575";
		
		Transaction transaction = transactionRepository.findOne(transactionId);
		
		if(transaction == null) {
			 transaction = new Transaction(transactionId,
					500.00, 
					Transaction.Type.CREDIT, 
					Transaction.Medium.WALLET_TRANSFER, 
					Status.PROCESSING , 
					"Wallet Transfer", 
					new ArrayList<History>()); 
		} else {
			transaction.addHistory(new History(new Date(), "Transaction Success"));
			transaction.setStatus(Status.SUCCESS);
		}
		
		transaction = transactionRepository.save(transaction);
		
		Wallet wallet = walletRepository.findOne("in.del.del.north.dps5657.2015.cls1.S1001");
		
		if(wallet == null) {
			wallet = new Wallet("in.del.del.north.dps5657.2015.cls1.S1001", new ArrayList<Transaction>());
		}
		wallet.addTransaction(transaction);
		walletRepository.save(wallet);
	}
	
	//@Test
	public void test_createLibraryEntry() {
		LibraryInventory book = new LibraryInventory("ISBN12345672885", 10, 500.00, new BookDetails("Class1 Maths", "Someone", "Somebody", new Date()));
		libraryRepository.insert(book);
		
		CanteenInventory item = new CanteenInventory("BARCODE1234568", 10, 15.00, new CanteenItemDetails("Egg Sandwich", "chicken, EGG, Salad"));
		canteenInventoryRepository.insert(item);
		
	}
	
	//@Test
	public void test_doShopping() {
		Entity orderedBy = entityRepository.findOne("in.del.del.north.dps5657.2015.cls1.S1001");
		OrderCart cart = new OrderCart(orderedBy);
		
		LibraryInventory book = libraryRepository.findOne("ISBN12345672885");
		cart.add(new InventoryItem(book, 4));
		
		CanteenInventory sandwich = canteenInventoryRepository.findOne("BARCODE1234568");
		cart.add(new InventoryItem(sandwich, 1));
		
		orderCartRepository.insert(cart);
		
	}
	
	//@Test
	public void test_createEntity() {
		
		Identity id = new Identity("F818480234", "Passport", "Fir Mid Sur", "Govt of India", new LocalDate(2006, 8, 16), new LocalDate(2016, 8, 16), "IN");
		List<Identity> socialSecurityIds = new ArrayList<Identity>();
		socialSecurityIds.add(id);
		
		EntityHeader entityHeader = new EntityHeader("First", "Sur", "Mid", socialSecurityIds);
		Entity ent = new Entity("T103", "TEACHER", "in.del.del.north.dps.1001", entityHeader, null, null);
		
		entityRepository.insert(ent);
	}
	
	//@Test
	public void test_findGroupWithEntityRefs() {
		List<EntityGroup> teachers = entityGroupRepository.findAll();
		
		for (EntityGroup teacherGroup : teachers) {
			for (Entity teacher : teacherGroup.getGroupMembers()) {
				LOGGER.info("MEM: " + teacher.getEntityType());
			}
		}
		sleep();
	}
	
	private void sleep() {
		try {
		Thread.sleep(50000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
