package cn.scifi.novelogic.interfaces.assembler;


import cn.scifi.novelogic.domain.model.entity.Author;
import cn.scifi.novelogic.infrastructure.common.utils.BeanConverter;
import cn.scifi.novelogic.interfaces.dto.vo.UserVO;

/**
 * @author bingdyee
 * @since 2024/10/22
 */
public class UserAssembler {

    public static UserVO toVO(Author author) {
        UserVO userVO = new UserVO();
        BeanConverter.copyProperties(author, userVO);
        return userVO;
    }

}
