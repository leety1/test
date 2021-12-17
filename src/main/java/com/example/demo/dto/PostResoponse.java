//package com.example.demo.dto;
//
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//import lombok.*;
//import com.example.demo.domain.*;
//
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class PostResoponse {
//	private long id;
//    private String title;
//    private String text;
//    private String category;
//    private Author author;
//    
//    public static List<PostResoponse> from(Collection<Post> entites){
//    	return entites.stream().map(PostResoponse::from).collect(Collectors.toList());
//    }
//    
//    public static PostResoponse from(Post entity) {
//    	return PostResoponse.builder()
//    			.id(entity.getId())
//    			.title(entity.getTitle())
//    			.text(entity.getText())
//    			.category(entity.getCategory())
//    			.author(entity.getAuthor())
//    			.build();
//    }
//
//}
