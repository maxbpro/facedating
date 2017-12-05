package maxb.facedating.service.impl;

import maxb.facedating.dao.LikeInfoRepository;
import maxb.facedating.domain.LikeInfo;
import maxb.facedating.service.LikeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LikeInfoServiceImpl implements LikeInfoService {

    @Autowired
    private LikeInfoRepository likeInfoRepository;

    @Override
    public void save(LikeInfo likeInfo) {
        likeInfoRepository.save(likeInfo);
    }

    @Override
    public void delete(LikeInfo likeInfo) {
        likeInfoRepository.delete(likeInfo);
    }

    @Override
    public void delete(Long id) {
        likeInfoRepository.delete(id);
    }

    @Override
    public Page<LikeInfo> findByUserId(Long userId, Pageable pageRequest) {
        return likeInfoRepository.findByUserId(userId, pageRequest);
    }

    @Override
    public LikeInfo findByUserIdAndOtherUserId(Long userId, Long otherUserId){
        return likeInfoRepository.findByUserIdAndOtherUserId(userId, otherUserId);
    }
}
