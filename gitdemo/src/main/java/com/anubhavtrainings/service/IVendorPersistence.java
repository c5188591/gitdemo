package com.anubhavtrainings.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anubhavtrainings.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, Long> {
	List <Vendor> findByCompanyName(String companyName);
	
	@Query(nativeQuery=true, 
			value="SELECT * FROM public.vendor where lower(GST_NO) like %?1% ")
	List<Vendor> lookupVendorByGST(String GSTNo);
	
}
