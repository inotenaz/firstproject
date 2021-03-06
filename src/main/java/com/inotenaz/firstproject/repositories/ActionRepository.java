package com.inotenaz.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inotenaz.firstproject.domain.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {

}
