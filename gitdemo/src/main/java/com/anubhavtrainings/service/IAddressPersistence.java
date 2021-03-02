package com.anubhavtrainings.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anubhavtrainings.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long> {

}
