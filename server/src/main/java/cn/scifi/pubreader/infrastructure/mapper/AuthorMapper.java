package cn.scifi.pubreader.infrastructure.mapper;

import cn.scifi.pubreader.infrastructure.po.AuthorPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bingdyee
 * @since 2024/10/21
 */
@Mapper
public interface AuthorMapper extends BaseMapper<AuthorPO> {

    /**
     * 根据唯一键查询用户
     *
     * @param email 邮箱
     * @param mobile 手机
     * @return {@link AuthorPO}
     */
    AuthorPO selectByUid(String email, String mobile);

    /**
     * 获取作者信息
     *
     * @param pseudonym 笔名
     * @return {@link AuthorPO}
     */
    AuthorPO selectByPseudonym(String pseudonym);

}
