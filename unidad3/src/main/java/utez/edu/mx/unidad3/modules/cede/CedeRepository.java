package utez.edu.mx.unidad3.modules.cede;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CedeRepository extends JpaRepository<Cede,Long> {
    List<Cede> findAll();
    Optional<Cede> findById(Long id);
    Cede save (Cede cede);//guardar y actualizar

    @Modifying
    @Query(value = "DELETE FROM cede WHERE id=:id",nativeQuery = true)
    void deleteById(@Param("id")Long id);

}
