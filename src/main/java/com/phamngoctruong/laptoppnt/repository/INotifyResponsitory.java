package com.phamngoctruong.laptoppnt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phamngoctruong.laptoppnt.model.Notify;
@Repository
@Transactional
public interface INotifyResponsitory extends JpaRepository<Notify, Long> {


}
