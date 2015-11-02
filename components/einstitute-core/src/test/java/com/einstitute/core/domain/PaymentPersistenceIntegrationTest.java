package com.einstitute.core.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.einstitute.core.repository.DiscountRepository;
import com.einstitute.core.repository.PaymentRepository;
import com.einstitute.core.repository.config.RepositoryConfig;

@SpringApplicationConfiguration(classes = { RepositoryConfig.class }, initializers = ConfigFileApplicationContextInitializer.class)
@WebIntegrationTest
public class PaymentPersistenceIntegrationTest extends AbstractTestNGSpringContextTests {

	private static Logger LOGGER = Logger.getLogger(PaymentPersistenceIntegrationTest.class);

	@Autowired
	private DiscountRepository discountRepository;
	@Autowired
	private PaymentRepository paymentRepository;

	//@Test
	public void test_createDiscount() {
		Calendar startDate = Calendar.getInstance();
		startDate.set(2015, 4, 1);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2016, 3, 31);
		Discount discount = new Discount("SC/ST Discount", 0.0, 50.0,startDate.getTime(), endDate.getTime());
		discountRepository.save(discount);
	}

	@Test
	public void test_DiscountfindBy_Id() {
		Discount discount = discountRepository.findOne(new ObjectId("5637495060018fed9d5f9287"));
		LOGGER.info("Discount description:" + discount.getDescription());
		Assert.assertNotNull(discount);
	}

	@Test
	public void test_createPayment() {
		Calendar startDate = Calendar.getInstance();
		startDate.set(2015, 4, 1);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2016, 3, 31);
		PaymentComponent paymentComponent1 = new PaymentComponent("Tution Fee",	3000.0);
		Discount discount = discountRepository.findOne(new ObjectId("5637495060018fed9d5f9287"));
		List<Discount> paymentDiscounts = new ArrayList<Discount>();
		paymentDiscounts.add(discount);
		paymentComponent1.setPaymentDiscounts(paymentDiscounts);

		PaymentComponent paymentComponent2 = new PaymentComponent("Library Fee", 800.0);
		List<PaymentComponent> paymentComponents = new ArrayList<PaymentComponent>();
		paymentComponents.add(paymentComponent1);
		paymentComponents.add(paymentComponent2);

		Payment payment = new Payment("Monthly Fee for Class 4, 2015",startDate.getTime(), endDate.getTime());
		payment.setPaymentComponents(paymentComponents);
		paymentRepository.save(payment);
	}

	/*
	 * @Test public void test_PaymentfindBy_Id() { ObjectId id = new
	 * ObjectId("56372c156001556a64efe3d9"); Discount discount =
	 * discountRepository.findBy_id(id); LOGGER.info("Discount description:"+
	 * discount.getDescription()); Assert.assertNotNull(discount); }
	 */

}
