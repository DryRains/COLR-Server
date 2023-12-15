package ken.study.repository;

import ken.study.domain.Mission;
import ken.study.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByRestaurant(Restaurant restaurant, Pageable pageable);
}
