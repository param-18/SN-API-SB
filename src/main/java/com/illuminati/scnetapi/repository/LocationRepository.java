package com.illuminati.scnetapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.illuminati.scnetapi.entity.*;
@Repository
public interface LocationRepository extends CrudRepository<Location , String>{

}
