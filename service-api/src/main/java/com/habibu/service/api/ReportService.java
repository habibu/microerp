package com.habibu.service.api;
import com.habibu.model.Report;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = ReportService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Report.class)
public interface ReportService extends EntityResolver<Report, Long>, ValidatorService<Report> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Report
     */
    public abstract Report findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param report
     */
    public abstract void delete(Report report);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Report> save(Iterable<Report> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Report
     */
    public abstract Report save(Report entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Report
     */
    public abstract Report findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Report> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Report> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Report> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Report> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
