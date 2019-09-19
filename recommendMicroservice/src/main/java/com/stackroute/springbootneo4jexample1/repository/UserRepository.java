package com.stackroute.springbootneo4jexample1.repository;

import com.stackroute.springbootneo4jexample1.model.Category;
import com.stackroute.springbootneo4jexample1.model.RentItems;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.model.WishlistProduct;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("MATCH (p:RentItems) RETURN p")
    Collection<RentItems> getAllProducts();
//
//    @Query("MERGE (u:User {userEmail : {userEmail} , userEmail : {userEmail} , category : {category} , products : {products }) return u")
//    User saveUser(@Param("userEmail") String userEmail, @Param("userName")String userName, @Param("category") List<String> category,@Param("products") List<RentItems> rentItems);

    @Query(" MATCH (u:User {userName:'Pranee'})-[:LIKES]->(c:Category) return c")
    Collection<Category> getAllLikes();
   // @Query("Create (u:User {name: {name}, emailid)")

    @Query("MATCH (u:User { userEmail:{userEmail} } )-[:LIKES]->(:Category)<-[:BELONGS_TO]-(p:RentItems) RETURN p")
    Collection<RentItems> getAllRecommendProducts(@Param("userEmail") String userEmail);


    @Query("match(u:User {userEmail: {email}})\n" +
            "match(r:RentItems {itemName :{itemName} ,itemDescription: {itemDescription}})\n" +
            "merge (u)-[:INTERESTED_IN]->(r) return r")
    RentItems saveMyFav(@Param("email") String email, @Param("itemName") String itemName, @Param("itemDescription") String itemDescription);

    @Query("match(u:User {userEmail: {email}})  MATCH (u)-[:INTERESTED_IN]->(p:RentItems) RETURN p")
    Collection<RentItems> getMyFavs(String email);

    @Query("match(u:User {userEmail: {email}})  MATCH (u)-[rel:INTERESTED_IN]->(p:RentItems {itemName : {name}}) delete  rel")
    Collection<RentItems> deleteWLProductByName(@Param("email") String email,@Param("name") String name);







}