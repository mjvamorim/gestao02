package com.algaworks.festas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festas.models.Upload;

public interface  Uploads extends JpaRepository <Upload,Long> {

}
