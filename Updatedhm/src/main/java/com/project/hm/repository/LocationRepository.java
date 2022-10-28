package com.project.hm.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.hm.entity.Locations;

@Repository
public interface LocationRepository extends JpaRepository<Locations,Long> 
{
	
	@Query			
	("SELECT l FROM Locations l  WHERE l.cityName LIKE CONCAT('%',:name, '%')")
     List<Locations> findBycityNameLike(String name);

//@Query("SELECT p FROM ProductsEntity p WHERE " + "p.prodName LIKE CONCAT('%',:query, '%')"
//        + "Or p.categoriesEntity.catName LIKE CONCAT('%', :query, '%')")
//List<ProductsEntity> searchProducts(@Param("query") String query);
	
    List<Locations> findBycityName(String cityName);
}
