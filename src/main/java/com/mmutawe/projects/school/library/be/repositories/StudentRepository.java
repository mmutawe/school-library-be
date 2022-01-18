package com.mmutawe.projects.school.library.be.repositories;

import com.mmutawe.projects.school.library.be.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(
        readOnly = true,
        timeout = 10
)
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);

    Optional<List<Student>> findAllByFirstNameEqualsAndLastNameEquals(String firstName, String lastName);

    // JPQL: Java Persistence Query Language
    //    @Query("SELECT s FROM Student s WHERE year(now()) - year(dob) >= 18")
    // Native Query - PostgreSQL
    @Query(
            value = "SELECT * FROM students " +
                    "WHERE EXTRACT(YEAR from AGE(now(), dob))  >= 18",
            nativeQuery = true
    )
    Optional<List<Student>> findAllByAgeGreaterThan18();

    @Query(
            value = "SELECT * FROM students " +
                    "WHERE email LIKE '%' || :domain || '%'",
            nativeQuery = true
    )
    Optional<List<Student>> findAllUseEmailDomain(@Param("domain") String domain);

    // return the number of affected rows after deletion
    @Query(
            value = "DELETE FROM students " +
                    "WHERE email LIKE '%' || :domain || '%'",
            nativeQuery = true
    )
    @Modifying
    @Transactional
    int deleteAllUseEmailDomain(@Param("domain") String domain);
}
