package com.authApp.repository;

import com.authApp.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OtpRepository extends JpaRepository<Otp, Integer> {
    @Query("""
SELECT o FROM Otp o inner join User u on o.user.id =u.id
where u.id=:userId and (o.expirationTime > CURRENT_TIMESTAMP )

""")
    Otp findValidOtpByUserID(int userId);
    @Modifying
    @Transactional
    @Query("""
delete FROM Otp o where o.user.id =:userId 

""")
    void deleteOtpByUserID(int userId);
}
