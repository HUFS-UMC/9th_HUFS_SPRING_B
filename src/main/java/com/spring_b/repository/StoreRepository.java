package umc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.demo.domain.store.Store;

public interface StoreRepository extends JpaRepository<Store,Long> {

}
