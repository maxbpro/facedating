package maxb.facedating.service;

import maxb.facedating.domain.CompareInfo;
import maxb.facedating.domain.LikeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by MaxB on 27/11/2017.
 */
public interface LikeInfoService {

    void save(LikeInfo likeInfo);

    void delete(LikeInfo likeInfo);

    void delete(Long id);

    Page<LikeInfo> findByUserId(Long userId, Pageable pageRequest);

    LikeInfo findByUserIdAndOtherUserId(Long userId, Long otherUserId);
}
