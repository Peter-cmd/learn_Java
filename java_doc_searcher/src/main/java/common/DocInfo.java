package common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DocInfo {
    // 文档的唯一身份标识
    private int docId;

    // 文档的标题(即文件名去掉 html 表示)
    private String title;

    // 文档的线上路径
    private String url;

    // 文档的正文
    private String content;
}
