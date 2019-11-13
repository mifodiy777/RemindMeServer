package com.remindme.server.repository;

import com.remindme.server.entity.Remind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemindRepository extends JpaRepository<Remind, Long> {
}
