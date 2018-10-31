package com.algaworks.festas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festas.models.Festa;

public interface  Festas extends JpaRepository <Festa,Long> {

}