package com.inotenaz.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inotenaz.firstproject.domain.SocialAction;

@Repository
public interface SocialActionRepository extends JpaRepository<SocialAction, Integer> {

}
