package com.stackroute.repository;



import com.stackroute.domain.RentItems;
import com.stackroute.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<User,Integer> {
    @Query("{'rentItems': { $elemMatch: { itemName: ?0}}}")
    List<User> getProductByName(String name);
}

