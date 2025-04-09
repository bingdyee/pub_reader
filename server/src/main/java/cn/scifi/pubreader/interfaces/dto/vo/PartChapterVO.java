package cn.scifi.pubreader.interfaces.dto.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author bingdyee
 * @since 2024/10/22
 */
@Getter
@Setter
public class PartChapterVO implements Serializable {

    private String partName;

    private List<ChapterVO> chapterList;

}
