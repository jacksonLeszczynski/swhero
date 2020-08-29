package repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swheroes.api.model.SwHero;

@Repository
public interface SwheroRepository extends JpaRepository<SwHero, Long>{
	Page<SwHero> findAll(Pageable page);
	Optional<SwHero> findById(long resultId);
}
