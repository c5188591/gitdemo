package com.anubhavtrainings.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.entities.Vendor;
import com.anubhavtrainings.service.vendorService;

@RestController

public class VendorController {

	@Autowired
	vendorService vendorService;
	
	//ES_GET_ENTITYSET
	@RequestMapping("/vendor")
	public List<Vendor> getVendors(){
		return vendorService.readAllVendors();		
	}
	
	//ES_CREATE_ENTITY
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		System.out.println(myPostBody);
		return vendorService.createVendor(myPostBody);
	}
	
	//Test Using localhost:8080/vendor/search?company=SAP
	@RequestMapping("/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company){
		return vendorService.searchByCompanyName(company);
	}
	
	//Test Using localhost:8080/vendor/77
	@RequestMapping("/vendor/lookup/{gstNo}")
	public List<Vendor> searchVendorByGST(@PathVariable("gstNo") String GSTNo){
		return vendorService.lookupVendorByGST(GSTNo);
	}
	
	//ES_GET_ENTITY
	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") Long code) {
		return vendorService.getSingleVendor(code);
	}
	

	//Test Yourself - http://localhost:8080/vendor
	//Payload:
	//	{
	//        "id": 4,
	//        "companyName": "SAP",
	//        "firstName": "Sobhan",
	//        "lastName": "Sharma",
	//        "website": "sap.com",
	//        "email": "shobhan.sharma@ibm.com",
	//        "status": "A",
	//        "gstNo": "GSTIN77555596"
	//}
	@RequestMapping(method=RequestMethod.PUT, value="/vendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorService.changeVendor(vendor);
	}
	
	//Test Yourself using - http://localhost:8080/vendor/4
	@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{id}")
	public String removeVendor(@PathVariable("id") Long Id) {
		return vendorService.deleteVendor(Id);
	}
	
	
}
