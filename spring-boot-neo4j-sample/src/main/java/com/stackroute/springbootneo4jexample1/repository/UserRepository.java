package com.stackroute.springbootneo4jexample1.repository;

import com.stackroute.springbootneo4jexample1.model.Category;
import com.stackroute.springbootneo4jexample1.model.Product;
import com.stackroute.springbootneo4jexample1.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("MATCH (p:Product) RETURN p")
    Collection<Product> getAllProducts();

    @Query(" MATCH (u:User {name:'Nikhila'})-[:LIKES]->(c:Category) return c")
    Collection<Category> getAllLikes();


    @Query("MATCH (u:User {name:'Nikhila'})-[:LIKES]->(:Category)<-[:BELONGS_TO]-(p:Product) RETURN p")
    Collection<Product> getAllRecommendProducts();



}