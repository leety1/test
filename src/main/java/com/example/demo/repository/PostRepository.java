//package com.example.demo.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import com.example.demo.domain.Post;
//@Repository
//public interface PostRepository extends JpaRepository<Post, Long> {
//	@Query("SELECT  p FROM Post p JOIN FETCH P.author")
//	List<Post> findAll();
//}
