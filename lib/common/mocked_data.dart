import 'package:pub_reader/common/models/resource_model.dart';

class MockedData {

  MockedData._();

  static final List<ResourceModel> hotResourceList = [
    ResourceModel.fromJson({
      "id": "1",
      "title": "谁懂啊、演的好像我自己！",
      "author": "好风自来",
      "authorAvatar": "https://pic2.zhimg.com/v2-ffdbbeea7a8063dd40a1e80a7c023b71_b.jpg",
      "likeNum": 1581,
      "type": 1,
      "heightRatio": 1.5,
      "thumbnail": "https://c-ssl.duitang.com/uploads/item/201912/09/20191209103907_VVJiv.jpeg",
    }),
    ResourceModel.fromJson({
      "id": "2",
      "title": "哥哥虽然是哥哥，但地位这块妹妹无疑是最高",
      "author": "小黑龙",
      "authorAvatar": "https://c-ssl.dtstatic.com/uploads/blog/202307/03/V2SoGOO7tmBvpYq.thumb.400_0.jpeg",
      "likeNum": 1581,
      "type": 1,
      "heightRatio": 0.9,
      "thumbnail": "https://puui.qpic.cn/vpic_cover/n3506ad1rh8/n3506ad1rh8_1679235618_hz.jpg/1280",
    }),
    ResourceModel.fromJson({
      "id": "2",
      "title": "玄鉴仙族",
      "author": "季越人",
      "authorAvatar": "https://ccportrait.yuewen.com/apimg/349573/p_16465333704674701/100",
      "likeNum": 1581,
      "type": 2,
      "heightRatio": 1.4,
      "score": 8.7,
      "bookStatus": 1,
      "summary": "陆江仙熬夜猝死，残魂却附在了一面满是裂痕的青灰色铜镜上，飘落到了浩瀚无垠的修仙世界。",
      "thumbnail": "https://bookcover.yuewen.com/qdbimg/349573/1035420986/600.webp",
    }),
    ResourceModel.fromJson({
      "id": "2",
      "title": "夜无疆",
      "author": "辰东",
      "authorAvatar": "https://ccportrait.yuewen.com/apimg/349573/p_3617756704644501/100",
      "likeNum": 1581,
      "type": 2,
      "heightRatio": 1.4,
      "score": 9.3,
      "bookStatus": 1,
      "summary": "那一天太阳落下再也没有升起………",
      "thumbnail": "https://bookcover.yuewen.com/qdbimg/349573/1040765595/600.webp",
    }),
  ];

}