package com.psagar3codes.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.psagar3codes.entity.CitizenPlan;
import com.psagar3codes.repository.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		repo.deleteAll();

		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Sagar");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5000.00);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Aisha");
		c2.setGender("Female");
		c2.setPlanName("Food");
		c2.setPlanStatus("Approved");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(3));
		c2.setBenefitAmt(3000.00);

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("John");
		c3.setGender("Male");
		c3.setPlanName("Medical");
		c3.setPlanStatus("Denied");
		c3.setPlanStartDate(LocalDate.now());
		c3.setDenialReason("Income too high");

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Maria");
		c4.setGender("Female");
		c4.setPlanName("Employment");
		c4.setPlanStatus("Terminated");
		c4.setPlanStartDate(LocalDate.now().minusMonths(2));
		c4.setTerminatedDate(LocalDate.now());
		c4.setTerminationRsn("No longer eligible");

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Ravi");
		c5.setGender("Male");
		c5.setPlanName("Cash");
		c5.setPlanStatus("Approved");
		c5.setPlanStartDate(LocalDate.now().minusMonths(1));
		c5.setPlanEndDate(LocalDate.now().plusMonths(5));
		c5.setBenefitAmt(6000.00);

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Anita");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Denied");
		c6.setPlanStartDate(LocalDate.now());
		c6.setDenialReason("Already receiving benefits");

		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Vikram");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now().minusMonths(1));
		c7.setPlanEndDate(LocalDate.now().plusMonths(11));
		c7.setBenefitAmt(15000.00);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Emily");
		c8.setGender("Female");
		c8.setPlanName("Employment");
		c8.setPlanStatus("Approved");
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(12));
		c8.setBenefitAmt(20000.00);

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Raj");
		c9.setGender("Male");
		c9.setPlanName("Cash");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(6));
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationRsn("Job found");

		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Priya");
		c10.setGender("Female");
		c10.setPlanName("Food");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(4));
		c10.setBenefitAmt(4000.00);

		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Sam");
		c11.setGender("Male");
		c11.setPlanName("Medical");
		c11.setPlanStatus("Approved");
		c11.setPlanStartDate(LocalDate.now());
		c11.setPlanEndDate(LocalDate.now().plusMonths(8));
		c11.setBenefitAmt(8000.00);

		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Lily");
		c12.setGender("Female");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Denied");
		c12.setPlanStartDate(LocalDate.now());
		c12.setDenialReason("Incomplete documents");

		CitizenPlan c13 = new CitizenPlan();
		c13.setCitizenName("Ramesh");
		c13.setGender("Male");
		c13.setPlanName("Cash");
		c13.setPlanStatus("Denied");
		c13.setPlanStartDate(LocalDate.now());
		c13.setDenialReason("Exceeds income limit");

		CitizenPlan c14 = new CitizenPlan();
		c14.setCitizenName("Sophia");
		c14.setGender("Female");
		c14.setPlanName("Food");
		c14.setPlanStatus("Terminated");
		c14.setPlanStartDate(LocalDate.now().minusMonths(3));
		c14.setTerminatedDate(LocalDate.now());
		c14.setTerminationRsn("Moved to another city");

		CitizenPlan c15 = new CitizenPlan();
		c15.setCitizenName("Mohit");
		c15.setGender("Male");
		c15.setPlanName("Medical");
		c15.setPlanStatus("Approved");
		c15.setPlanStartDate(LocalDate.now());
		c15.setPlanEndDate(LocalDate.now().plusMonths(2));
		c15.setBenefitAmt(2000.00);

		CitizenPlan c16 = new CitizenPlan();
		c16.setCitizenName("Olivia");
		c16.setGender("Female");
		c16.setPlanName("Employment");
		c16.setPlanStatus("Terminated");
		c16.setPlanStartDate(LocalDate.now().minusMonths(1));
		c16.setTerminatedDate(LocalDate.now());
		c16.setTerminationRsn("Became self-employed");

		CitizenPlan c17 = new CitizenPlan();
		c17.setCitizenName("Aman");
		c17.setGender("Male");
		c17.setPlanName("Cash");
		c17.setPlanStatus("Approved");
		c17.setPlanStartDate(LocalDate.now().minusMonths(2));
		c17.setPlanEndDate(LocalDate.now().plusMonths(4));
		c17.setBenefitAmt(4000.00);

		CitizenPlan c18 = new CitizenPlan();
		c18.setCitizenName("Isla");
		c18.setGender("Female");
		c18.setPlanName("Food");
		c18.setPlanStatus("Approved");
		c18.setPlanStartDate(LocalDate.now());
		c18.setPlanEndDate(LocalDate.now().plusMonths(3));
		c18.setBenefitAmt(3500.00);

		CitizenPlan c19 = new CitizenPlan();
		c19.setCitizenName("Kabir");
		c19.setGender("Male");
		c19.setPlanName("Medical");
		c19.setPlanStatus("Terminated");
		c19.setPlanStartDate(LocalDate.now().minusMonths(5));
		c19.setTerminatedDate(LocalDate.now());
		c19.setTerminationRsn("Health improved");

		CitizenPlan c20 = new CitizenPlan();
		c20.setCitizenName("Aarav");
		c20.setGender("Male");
		c20.setPlanName("Employment");
		c20.setPlanStatus("Approved");
		c20.setPlanStartDate(LocalDate.now());
		c20.setPlanEndDate(LocalDate.now().plusMonths(6));
		c20.setBenefitAmt(10000.00);

		List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17,
				c18, c19, c20);

		repo.saveAll(list);
	}
}
