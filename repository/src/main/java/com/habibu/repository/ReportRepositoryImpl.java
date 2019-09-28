package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Report;
import com.habibu.model.QReport;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ReportRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = ReportRepositoryCustom.class)
@Transactional(readOnly = true)
public class ReportRepositoryImpl extends QueryDslRepositorySupportExt<Report> implements ReportRepositoryCustom {

    /**
     * Default constructor
     */
    ReportRepositoryImpl() {
        super(Report.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String TYPE = "type";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Report> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QReport report = QReport.report;
        JPQLQuery<Report> query = from(report);
        Path<?>[] paths = new Path<?>[] { report.type };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(TYPE, report.type);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, report);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Report> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QReport report = QReport.report;
        JPQLQuery<Report> query = from(report);
        Path<?>[] paths = new Path<?>[] { report.type };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(report.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(TYPE, report.type);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, report);
    }
}
