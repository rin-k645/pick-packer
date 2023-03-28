package com.pickpack.memberservice.repository;

import com.pickpack.memberservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> , TicketRepositoryCustom{
}
