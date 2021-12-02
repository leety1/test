/*
 * package com.example.demo.login;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Table;
 * 
 * import org.springframework.data.annotation.Id;
 * 
 * import lombok.AccessLevel; import lombok.Builder; import lombok.Getter;
 * import lombok.NoArgsConstructor;
 * 
 * @Entity
 * 
 * @Table(name="user")
 * 
 * @Getter
 * 
 * @NoArgsConstructor(access = AccessLevel.PROTECTED)
 * 
 * public class UserEntity {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private long userId; private
 * String name; private String passWord; private String role; private String
 * Address;
 * 
 * @Builder public UserEntity(String name,String password,String role) {
 * this.name = name; this.passWord = passWord; this.role = role; }
 * 
 * }
 */