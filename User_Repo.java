package validation.icicibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import validation.icicibank.entity.User_Entity;

public interface User_Repo extends JpaRepository<User_Entity,Integer> {

}
