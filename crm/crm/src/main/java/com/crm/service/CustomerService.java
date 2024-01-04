package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Customer;
import com.crm.repo.CustomerRepository;

//CustomerService.java
@Service
public class CustomerService {

 @Autowired
 private CustomerRepository customerRepository;

 public List<Customer> getAllCustomers() {
     return customerRepository.findAll();
 }

 public Customer getCustomerById(Long id) {
     return customerRepository.findById(id).orElse(null);
 }

 
 
 
 
 public Customer createCustomer(Customer customer) {
     return customerRepository.save(createCustomerDetails(customer));
 }

 private Customer createCustomerDetails(Customer customer) {
	 Customer customer2 = new Customer();
	 customer2.setFirstName(customer.getFirstName());
	 customer2.setLastName(customer.getLastName());
	 customer2.setEmail(customer.getEmail());
	 customer2.setDob(customer.getDob());
	 customer2.setPhone(customer.getPhone());
	 customer2.setAadhar(customer.getAadhar());
	 customer2.setBloodgroup(customer.getBloodgroup());
	 customer2.setAddress(customer.getAddress());
	 customer2.setGender(customer.getGender());
	 customer2.setPincode(customer.getPincode());
	 return customer2;
 }
 
 
 
 
 
 public Customer updateCustomer(Long id, Customer updatedCustomer) {
     Customer existingCustomer = customerRepository.findById(id).orElse(null);

     if (existingCustomer != null) {
         existingCustomer.setFirstName(updatedCustomer.getFirstName());
         existingCustomer.setLastName(updatedCustomer.getLastName());
         existingCustomer.setEmail(updatedCustomer.getEmail());
         existingCustomer.setDob(updatedCustomer.getDob());
         existingCustomer.setPhone(updatedCustomer.getPhone());
         existingCustomer.setAadhar(updatedCustomer.getAadhar());
         existingCustomer.setBloodgroup(updatedCustomer.getBloodgroup());
         existingCustomer.setAddress(updatedCustomer.getAddress());
         existingCustomer.setGender(updatedCustomer.getGender());
         existingCustomer.setPincode(updatedCustomer.getPincode());
         return customerRepository.save(existingCustomer);
     }

     return null;
 }

 public void deleteCustomer(Long id) {
     customerRepository.deleteById(id);
 }
}










//@Override
//public void processSms(SmsDto smsDto) {
//	channelRepository.save(createSmsDetails(smsDto));
//
//}
//
//@Override
//public void processSmsList(List<SmsDto> channelList) {
//	List<SmsDetails> smsList = new ArrayList<SmsDetails>();
//	for (SmsDto smsDto : channelList) {
//		smsList.add(createSmsDetails(smsDto));
//	}
//	channelRepository.saveAll(smsList);
//}
//
//private SmsDetails createSmsDetails(SmsDto smsDto) {
//	SmsDetails smsDetails = new SmsDetails();
//	smsDetails.setContactNumber(smsDto.getContactNumber());
//	smsDetails.setName(smsDto.getName());
//	smsDetails.setSmsContent(smsDto.getSmsContent());
//	smsDetails.setCreatedDate(new Date());
//	smsDetails.setSmsStatus("SUCCESS");
//	return smsDetails;
//
//}


