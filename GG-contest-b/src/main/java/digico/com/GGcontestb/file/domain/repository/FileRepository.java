package digico.com.GGcontestb.file.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import digico.com.GGcontestb.file.domain.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

    //void deleteByIdIn(Long id);

    Optional<FileEntity> findById(Long id);

}
