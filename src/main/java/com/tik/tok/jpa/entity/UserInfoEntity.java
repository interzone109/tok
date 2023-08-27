package com.tik.tok.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "USER_INFO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_name ", nullable = false, unique = true)
    private String userName;
    @Column(name = "online_status", nullable = false)
    private Boolean onlineStatus;
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;
    @Column(name = "last_activity_date", nullable = false)
    private LocalDate lastActivityDate;
    @Column(name = "subscribers", nullable = false)
    private Integer subscribers;
    @Column(name = "followers", nullable = false)
    private Integer followers;

}
