package digico.com.GGcontestb.community.domain.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digico.com.GGcontestb.community.domain.entity.NoticeEntity;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, String> {

    NoticeEntity findById(Long id);
}
