package digico.com.GGcontestb.file.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import digico.com.GGcontestb.file.domain.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {

    void deleteByIdIn(List<String> id);

    List<FileEntity> findByIdIn(List<String> id);

}
