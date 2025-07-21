package br.com.movieon.repository;

import br.com.movieon.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
