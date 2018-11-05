package com.emartos.cheesemvc.models.data;

import com.emartos.cheesemvc.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//Allow the interaction with the DB
@Repository
//Transaction: A communication with the DB
@Transactional
public interface CheeseDao extends CrudRepository<Cheese, Integer>
{

}
