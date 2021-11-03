package com.phamngoctruong.laptoppnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phamngoctruong.laptoppnt.model.Transaction;


@Repository
@Transactional
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
@Query(value = "SELECT * FROM cdwebshoplaptop.transactions order by transactions.created_date desc limit 8",nativeQuery = true)
	List<Transaction> findAllByDateDESC();

}
