import 'dart:math';

import 'models/book_model.dart';

Random random = Random();

List<Book> books = [
  Book.fromJson({
    "id": "1",
    "title": "寒门权相",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043488621/600.webp",
    "summary": "奉命巡抚江南的卫王来到了江南，面对困局，他按照临行前母妃的交待，逐一拜访三位大贤。",
    "author": "皇家大芒果",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "历史",
    "subCategoryName": "架空历史",
    "wordCount": 18,
    "tags": ["穿越", "草根崛起", "轻松"],
    "collectNum": 891,
    "score": 9.3,
    "video": {
      "url": "https://cdn.pixabay.com/video/2024/08/30/228847_small.mp4",
      "width": 1080,
      "height": 1920,
      "size": 75579502,
      "thumbnail": "https://cdn.pixabay.com/video/2024/08/30/228847_small.jpg"
    }
  }),
  Book.fromJson({
    "id": "2",
    "title": "重生鉴宝：我真没想当专家",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043813234/600.webp",
    "summary": "好消息：林思成重生了。坏消息：重生前，他是国内最年轻的考古学家，文物鉴定、保护及修复等学科带头人。多次荣获国家级科研奖项，并在多家国字头考古研究机构担任顾问。",
    "author": "眀智",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "都市",
    "subCategoryName": "都市生活",
    "wordCount": 6,
    "tags": ["重生", "轻松", "快节奏"],
    "collectNum": 112,
    "score": 9.1,
    "video": {
      "url": "https://cdn.pixabay.com/video/2025/04/07/270696_large.mp4",
      "width": 1920,
      "height": 1080,
      "size": 15780397,
      "thumbnail": "https://cdn.pixabay.com/video/2025/04/07/270696_large.jpg"
    }
  }),
  Book.fromJson({
    "id": "3",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043748975/600.webp",
    "title": "山河祭",
    "summary": "且夫天地为炉兮，造化为工；阴阳为炭兮，万物为铜。——终有一天，要让这祭炼世界的炉火，换成属于我的火焰。",
    "author": "姬叉",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "仙侠",
    "subCategoryName": "幻想修仙",
    "wordCount": 8,
    "tags": [],
    "collectNum": 1023,
    "score": 9.9,
    "video": {
      "url": "https://cdn.pixabay.com/video/2022/12/07/141964-778907198_large.mp4",
      "width": 1920,
      "height": 1080,
      "size": 9008226,
      "thumbnail": "https://cdn.pixabay.com/video/2022/12/07/141964-778907198_large.jpg"
    }
  }),
  Book.fromJson({
    "id": "4",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043542410/600.webp",
    "title": "末日：这款游戏绝对有问题",
    "summary": "百分百无差评游戏！末日题材策略手游大作《末日指挥官online》，独具特色的丧尸题材，高度还原末日血战场景，考验战争策略的高自由玩法，精彩世界将在玩家的眼前呈现。",
    "author": "南天时钟座",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "轻小说",
    "subCategoryName": "原生幻想",
    "wordCount": 12,
    "tags": ["诡异游戏", "丧尸", "经营"],
    "collectNum": 2019,
    "score": 9.7,
    "video": {
      "url": "https://cdn.pixabay.com/video/2025/04/09/270940_small.mp4",
      "width": 1920,
      "height": 1080,
      "size": 3852615,
      "thumbnail": "https://cdn.pixabay.com/video/2025/04/09/270940_small.jpg"
    }
  }),
  Book.fromJson({
    "id": "5",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043249350/600.webp",
    "title": "惊涛落日",
    "summary": "王义穿越了，一抬头就看见掠过的飞机上那鲜红的膏药标。来自血脉的怒火被唤醒了。他不知道穿成了谁，也不知道他在哪儿，甚至不知道他有啥外挂。",
    "author": "康斯坦丁伯爵",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "历史",
    "subCategoryName": "架空历史",
    "wordCount": 17,
    "tags": [],
    "collectNum": 655,
    "score": 9.6,
    "video": {
      "url": "https://cdn.pixabay.com/video/2025/03/12/264272_large.mp4",
      "width": 1080,
      "height": 1920,
      "size": 30008468,
      "thumbnail": "https://cdn.pixabay.com/video/2025/03/12/264272_large.jpg"
    }
  }),
  Book.fromJson({
    "id": "6",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043420839/600.webp",
    "title": "你这秘境游戏绝对有毒！",
    "summary": "这座传奇地下城的缔造者，奇迹城的领主——齐霁！",
    "author": "月下藏锋",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "轻小说",
    "subCategoryName": "原生幻想",
    "wordCount": 19,
    "tags": ["游戏制作", "领主流", "第四天灾"],
    "collectNum": 9102,
    "score": 9.8,
    "video": {
      "url": "https://cdn.pixabay.com/video/2024/08/20/227567_small.mp4",
      "width": 1080,
      "height": 1920,
      "size": 143277682,
      "thumbnail": "https://cdn.pixabay.com/video/2024/08/20/227567_small.jpg"
    }
  }),
  Book.fromJson({
    "id": "7",
    "title": "长生从炼丹宗师开始",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1036526469/600.webp",
    "summary": "山人是为仙，往来青云巅。阴阳炉中炼，大道在心间。罗尘穿越修仙界，以一块熟练度面板，炼丹服气，习法研术，一步步走向长生大道。",
    "author": "雨去欲续",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "仙侠",
    "subCategoryName": "修真文明",
    "wordCount": 441,
    "tags": ["穿越修仙", "炼丹", "长生"],
    "collectNum": 876,
    "score": 8.9,
    "video": {
      "url": "https://cdn.pixabay.com/video/2024/03/31/206294_large.mp4",
      "width": 1080,
      "height": 1920,
      "size": 9267237,
      "thumbnail": "https://cdn.pixabay.com/video/2024/03/31/206294_large.jpg"
    }
  }),
  Book.fromJson({
    "id": "8",
    "title": "娘子，你不会真的给我下药了吧",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1039639282/600.webp",
    "summary": "大乾末年，恶霸横行，战乱四起，民不聊生。陈解穿越而来，发现自己竟然是个嗜酒的烂赌鬼，家里还有一对苦命的姐妹。",
    "author": "桃公旺",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "玄幻",
    "subCategoryName": "东方玄幻",
    "wordCount": 301,
    "tags": [],
    "collectNum": 8309,
    "score": 9.2,
    "video": {
      "url": "https://cdn.pixabay.com/video/2025/01/03/250395_small.mp4",
      "width": 1080,
      "height": 1920,
      "size": 14620514,
      "thumbnail": "https://cdn.pixabay.com/video/2025/01/03/250395_small.jpg"
    }
  }),
  Book.fromJson({
    "id": "9",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1039391177/600.webp",
    "title": "吞噬星空2起源大陆",
    "summary": "罗峰带着界兽摩罗撒闯过轮回，来到了起源大陆……",
    "author": "我吃西红柿",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "科幻",
    "subCategoryName": "未来科幻",
    "wordCount": 103,
    "tags": ["进化", "轮回", "宇宙幻想"],
    "collectNum": 901,
    "score": 9.8,
    "video": {
      "url": "https://cdn.pixabay.com/video/2025/03/23/266971_large.mp4",
      "width": 1080,
      "height": 1920,
      "size": 19144062,
      "thumbnail": "https://cdn.pixabay.com/video/2025/03/23/266971_large.jpg"
    }
  }),
  Book.fromJson({
    "id": "10",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1026225232/600.webp",
    "title": "人族镇守使",
    "summary": "重活一世，沈长青成为大秦镇魔司一员，此时恰逢妖魔乱世，诡怪猖獗——斩杀幽级诡怪，纯阳功圆满！斩杀怨级诡怪，天武罡气圆满！斩杀强大妖邪，打破自身极限！",
    "author": "白驹易逝",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "玄幻",
    "subCategoryName": "东方玄幻",
    "wordCount": 972,
    "tags": ["系统流", "穿越"],
    "collectNum": 470,
    "score": 9.1,
    "video": {
      "url": "https://cdn.pixabay.com/video/2020/05/25/40130-424930032_large.mp4",
      "width": 1920,
      "height": 1080,
      "size": 6652465,
      "thumbnail": "https://cdn.pixabay.com/video/2020/05/25/40130-424930032_large.jpg"
    }
  }),
  Book.fromJson({
    "id": "11",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1037798729/600.webp",
    "title": "那年花开1981",
    "summary": "这是一个考上大学就能鱼跃龙门的时代，这是一个处处风口飞上天的时代，这也是一个还有纯洁不渝、真挚感情的时代。",
    "author": "风随流云",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "都市",
    "subCategoryName": "都市生活",
    "wordCount": 350,
    "tags": ["赚钱", "穿越"],
    "collectNum": 583,
    "score": 9.0,
    "video": {
      "url": "https://cdn.pixabay.com/video/2023/05/20/163869-828669760_small.mp4",
      "width": 1920,
      "height": 1080,
      "size": 20463285,
      "thumbnail": "https://cdn.pixabay.com/video/2023/05/20/163869-828669760_small.jpg"
    }
  }),
  Book.fromJson({
    "id": "12",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1041770282/600.webp",
    "title": "满级悟性：我以升格下界成就道祖",
    "summary": "穿越到武道世界，开局婴儿之身，还惨遭灭门，宁奇人都麻了。好在身负满级悟性，一念百悟，创法顿悟如呼吸喝水一般简单。",
    "author": "爆炒螺丝椒",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "玄幻",
    "subCategoryName": "东方玄幻",
    "wordCount": 90,
    "tags": ["穿越"],
    "collectNum": 671,
    "score": 9.9,
    "video": {
      "url": "https://cdn.pixabay.com/video/2023/11/10/188595-883402169_small.mp4",
      "width": 1920,
      "height": 1080,
      "size": 15699030,
      "thumbnail": "https://cdn.pixabay.com/video/2023/11/10/188595-883402169_small.jpg"
    }
  }),
  Book.fromJson({
    "id": "13",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043682224/600.webp",
    "title": "冠军法则",
    "summary": "林奇穿越回2002年成为了一个篮球运动员，似乎拥有了实现梦想的机会。但为什么我只能获得NBA角色球员的能力？",
    "author": "葛洛夫街兄弟",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "体育",
    "subCategoryName": "篮球运动",
    "wordCount": 14,
    "tags": ["热血", "系统流", "轻松"],
    "collectNum": 492,
    "score": 9.4,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "14",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043916323/600.webp",
    "title": "权游之哈顿王朝",
    "summary": "这里是维斯特洛大陆，骑士、魔法与龙的世界！",
    "author": "周末不钓鱼",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "奇幻",
    "subCategoryName": "史诗奇幻",
    "wordCount": 4,
    "tags": [],
    "collectNum": 107,
    "score": 8.6,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "15",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043091612/600.webp",
    "title": "左道成神从美恐开始",
    "summary": "北美人民水深火热，各地频出杀人大案、灵异事件，急需铁拳制裁！",
    "author": "星汉如梦",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "轻小说",
    "subCategoryName": "衍生同人",
    "wordCount": 36,
    "tags": ["腹黑"],
    "collectNum": 773,
    "score": 8.7,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "16",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043620792/600.webp",
    "title": "天灾信使",
    "summary": "《信使》是蝉联十年全球最佳游戏运营奖的MMORPG。亦是全球第一款突破千万玩家在线的网络游戏。宴青以前从未玩过这款游戏。现在，他是这款游戏的唯一玩家。",
    "author": "听日",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "轻小说",
    "subCategoryName": "原生幻想",
    "wordCount": 36,
    "tags": ["穿越", "系统流"],
    "collectNum": 871,
    "score": 9.4,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "17",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043805237/600.webp",
    "title": "混元魔王：魔婴降世！",
    "summary": "当混元珠在雷劫中碎成十二道流光后，他才惊觉自己被天庭算计了三世！曾经剖骨还父、剔肉还母的他，如今竟然成了诸天神佛的劫材！",
    "author": "血神纪",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "都市",
    "subCategoryName": "都市异能",
    "wordCount": 8,
    "tags": [],
    "collectNum": 509,
    "score": 8.1,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "18",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043285370/600.webp",
    "title": "剑啸灵霄",
    "summary": "年少轻狂，袖里白蛇，铮铮化剑，直上灵霄。",
    "author": "流浪的蛤蟆",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "武侠",
    "subCategoryName": "武侠幻想",
    "wordCount": 37,
    "tags": [],
    "collectNum": 322,
    "score": 9.8,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "19",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1038229163/600.webp",
    "title": "普罗之主",
    "summary": "他叫李伴峰，山峰的峰，不是发疯的疯，医生说过他没有疯。为了救朋友一条命，他去了96号站台，上了1160蒸汽列车，来到了停留在蒸汽时代的普罗州。",
    "author": "沙拉古斯",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "玄幻",
    "subCategoryName": "东方玄幻",
    "wordCount": 385,
    "tags": ["宅男"],
    "collectNum": 990,
    "score": 9.5,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "20",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1039141715/600.webp",
    "title": "高武纪元",
    "summary": "从南洋深海中飞起的黑龙，掀起灭世海啸……火焰魔灵毁灭一座座钢筋水泥城市，于核爆中心安然离去……域外神明试图统治整片星海……",
    "author": "烽仙",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "玄幻",
    "subCategoryName": "高武世界",
    "wordCount": 292,
    "tags": ["热血", "系统流"],
    "collectNum": 672,
    "score": 9.6,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "21",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1043182343/600.webp",
    "title": "苟在初圣魔门当人材",
    "summary": "吕阳穿越修仙界，却成了魔门初圣宗的弟子。幸得异宝【百世书】，死后可以重开一世，让一切从头再来，还能带回前世的宝物，修为，寿命，甚至觉醒特殊的天赋。",
    "author": "鹤守月满池",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "玄幻",
    "subCategoryName": "东方玄幻",
    "wordCount": 37,
    "tags": ["凡人流", "穿越", "重生"],
    "collectNum": 545,
    "score": 9.7,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "22",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1041753908/600.webp",
    "title": "掌门师伯新收了个女徒弟",
    "summary": "掌教师伯新收了一个女徒弟。她很漂亮，让无数人为之神往。直至周清终于激活词条，看到很多人头上都闪烁着一个金色的标签。",
    "author": "三行的书哟",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "玄幻",
    "subCategoryName": "东方玄幻",
    "wordCount": 115,
    "tags": ["轻松", "日常", "爆笑"],
    "collectNum": 908,
    "score": 9.8,
    "videoUrl": ""
  }),
  Book.fromJson({
    "id": "23",
    "coverUrl": "https://bookcover.yuewen.com/qdbimg/349573/1037762892/600.webp",
    "title": "天才俱乐部",
    "summary": "“从出生开始，我每天都会做一个同样的梦，梦里不断重复着同样的一天。”“你在梦里都做了什么？”“抢银行、炸大楼、泡妹子、侠盗飞车……反正是梦里，自然做了很多无法无天的事。”",
    "author": "城城与蝉",
    "authorAvatar": "https://www.loliapi.com/acg/pp?_=${random.nextDouble()}",
    "categoryName": "科幻",
    "subCategoryName": "时空穿梭",
    "wordCount": 283,
    "tags": [],
    "collectNum": 762,
    "score": 9.3,
    "videoUrl": ""
  }),
];


class MockedData {
  MockedData._();

  static Future<List<Book>> mockBooks(int count) async {
    return (books..shuffle()).take(count).toList();
  }

  static Future<List<Book>> mockVideoBooks() async {
    return books.where((b) => b.hasVideo).toList();
  }

}

