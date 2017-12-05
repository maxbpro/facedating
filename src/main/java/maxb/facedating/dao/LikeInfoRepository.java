package maxb.facedating.dao;

import maxb.facedating.domain.CompareInfo;
import maxb.facedating.domain.LikeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaxB on 27/11/2017.
 */
public interface LikeInfoRepository extends JpaRepository<LikeInfo, Long> {

    Page<LikeInfo> findByUserId(Long userId, Pageable pageRequest);

    LikeInfo findByUserIdAndOtherUserId(Long userId, Long otherUserId);
}
