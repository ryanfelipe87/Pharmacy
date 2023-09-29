package com.project.pharmacy.repositories;

import com.project.pharmacy.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
