package maxb.facedating.service;

import maxb.facedating.domain.CompareInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by MaxB on 27/11/2017.
 */
public interface CompareInfoService {

    void save(CompareInfo compareInfo);

    List<CompareInfo> listCompares();

    Page<CompareInfo> findByUserFaceTokenAndValueGreaterThanEqual(String userFaceToken, double minValue, Pageable pageRequest);

}
