package maxb.facedating.service.impl;

import maxb.facedating.dao.CompareInfoRepository;
import maxb.facedating.domain.CompareInfo;
import maxb.facedating.service.CompareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MaxB on 27/11/2017.
 */
@Service
public class CompareInfoServiceImpl implements CompareInfoService {

    @Autowired
    private CompareInfoRepository compareInfoRepository;

    @Override
    public void save(CompareInfo compareInfo) {
        compareInfoRepository.save(compareInfo);
    }

    @Override
    public List<CompareInfo> listCompares() {
        return compareInfoRepository.findAll();
    }

    @Override
    public Page<CompareInfo> findByUserFaceTokenAndValueGreaterThanEqual(String userFaceToken, double minValue, Pageable pageRequest) {
        return compareInfoRepository.findByUserFaceTokenAndValueGreaterThanEqual(userFaceToken, minValue, pageRequest);
    }
}
