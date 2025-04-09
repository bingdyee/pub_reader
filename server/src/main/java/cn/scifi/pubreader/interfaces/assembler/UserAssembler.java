package cn.scifi.pubreader.interfaces.assembler;


import cn.scifi.pubreader.domain.model.entity.Author;
import cn.scifi.pubreader.infrastructure.common.utils.BeanConverter;
import cn.scifi.pubreader.interfaces.dto.vo.UserVO;

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
