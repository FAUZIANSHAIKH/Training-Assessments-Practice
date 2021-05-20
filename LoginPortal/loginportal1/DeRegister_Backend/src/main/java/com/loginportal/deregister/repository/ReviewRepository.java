package com.loginportal.deregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loginportal.deregister.model.Review;


@Repository("reviewRepository")
public interface ReviewRepository extends JpaRepository<Review,Long> {
		@Modifying
		@Query(value = "update Review set first_name=:msg where userid = :id")
	    void changeName(@Param("id") Long id ,@Param("msg") String msg);
		
		@Modifying
		@Query(value="DELETE FROM Review r where r.userid = :uid")
	    void deleteByUid(@Param("uid") Long uid);
		
}
