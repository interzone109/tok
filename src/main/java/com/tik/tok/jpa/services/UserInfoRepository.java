package com.tik.tok.jpa.services;

import com.tik.tok.jpa.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

    Optional<UserInfoEntity> findByUserName(String userName);

}
