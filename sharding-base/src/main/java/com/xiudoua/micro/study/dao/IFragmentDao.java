package com.xiudoua.micro.study.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.study.entity.FragmentEntity;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午5:04:01
 */
@Repository
public interface IFragmentDao extends JpaRepository<FragmentEntity, Long> {

	/**
	 * @desc 
	 * @param id
	 * @return
	 */
	@Query(value = "select * from tb_fragment WHERE :id BETWEEN start_id and end_id",nativeQuery = true)
	FragmentEntity findByIdIn(@Param("id") Long id);
	
	/**
	 * @desc 查询有效的配置列表
	 * @param shardIdList
	 * @return
	 */
	@Query(value = "select DISTINCT tb_fragment.* from tb_sharding_group LEFT JOIN tb_sharding on tb_sharding_group.id = tb_sharding.group_id left JOIN tb_fragment on tb_sharding.id = tb_fragment.shard_id where write_able = 1",nativeQuery = true)
	List<FragmentEntity> findEffectiveList();
	
}
