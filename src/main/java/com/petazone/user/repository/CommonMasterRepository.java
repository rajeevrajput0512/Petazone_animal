package com.petazone.user.repository;

import com.petazone.user.entity.CommonMaster;
import com.petazone.user.entity.CommonMasterPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommonMasterRepository extends JpaRepository<CommonMaster, CommonMasterPK> {

    @Query(value = "select * from cmn_tbl.common_master where key ilike CONCAT('%', :param1, '%')", nativeQuery = true)
    List<CommonMaster> findRelatedKeyNames(@Param("param1") String key);

    List<CommonMaster> findByIdKey(String key);

}
