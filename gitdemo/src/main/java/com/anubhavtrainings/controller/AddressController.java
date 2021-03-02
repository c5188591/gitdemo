package com.anubhavtrainings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.entities.address;
import com.anubhavtrainings.service.addressService;

@RestController
public class AddressController {
	
	@Autowired
	addressService addSrv;
	
	//http://localhost:8080/addresses
	@RequestMapping("/addresses")
	public List<address> getAddress(){
		return addSrv.getAddress();
	}
	
	//POST operation test http://localhost:8080/addresses
//	{
//		"addressType":"H",
//	    "street":"MG Road",
//	    "city":"Bangalore",
//	    "country": "India",
//	    "region":"APJ"
//	}
	@PostMapping("/addresses")
	public address createAddress(@RequestBody address payload) {
		return addSrv.createAddress(payload);
	}
}
