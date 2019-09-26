package com.habibu.repository;
import com.habibu.model.Report;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = ReportRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Report.class)
public interface ReportRepository extends DetachableJpaRepository<Report, Long>, ReportRepositoryCustom {
}
