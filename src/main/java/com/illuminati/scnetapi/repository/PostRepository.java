package com.illuminati.scnetapi.repository;
import org.springframework.stereotype.Repository;
import com.illuminati.scnetapi.entity.*;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
@Repository
public interface PostRepository extends CrudRepository<Post , String>{
  //search posts by date
  @Query("Select p From Post p Where p.postDate = :date")
  public List<Post> getByDate(@Param("date") String date);
}
