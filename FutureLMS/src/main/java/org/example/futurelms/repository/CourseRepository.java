package org.example.futurelms.repository;

import org.example.futurelms.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findBySlug(String slug);
    List<Course> findAllByTutorId(Long tutorId);
}
