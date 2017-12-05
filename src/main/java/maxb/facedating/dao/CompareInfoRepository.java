package maxb.facedating.dao;

import maxb.facedating.domain.CompareInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaxB on 27/11/2017.
 */
public interface CompareInfoRepository extends JpaRepository<CompareInfo, Long> {

    Page<CompareInfo> findByUserFaceTokenAndValueGreaterThanEqual(String userFaceToken, double minValue, Pageable pageRequest);
}
