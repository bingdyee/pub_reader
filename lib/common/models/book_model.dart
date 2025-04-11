import 'package:pub_reader/common/models/video_model.dart';

class Book {
  String id = '';
  String title = '';
  String author = '';
  String authorAvatar = '';
  String summary = '';
  String coverUrl = '';
  String categoryName = '';
  String subCategoryName = '';
  int wordNum = 0;
  int bookStatus = 1;
  int readNum = 0;
  int collectNum = 0;
  int commentNum = 0;
  double score = 0.0;
  VideoData? video;
  List<String> tags = [];

  Book.fromJson(dynamic book) {
    if (book == null || !book.containsKey('id')) return;
    id = book['id'] ?? '';
    title = book['title'] ?? '';
    author = book['author'] ?? '';
    authorAvatar = book['authorAvatar'] ?? '';
    summary = book['summary'] ?? '';
    coverUrl = book['coverUrl'] ?? '';
    categoryName = book['categoryName'] ?? '';
    subCategoryName = book['subCategoryName'] ?? '';
    wordNum = book['wordNum'] ?? 0;
    commentNum = book['commentNum'] ?? 0;
    bookStatus = book['bookStatus'] ?? 1;
    collectNum = book['collectNum'] ?? 0;
    readNum = book['readNum'] ?? 0;
    score = book['score'] ?? 0.0;
    List<dynamic>? tagList = book['tags'];
    if (tagList != null && tagList.isNotEmpty) {
      tags = tagList.map<String>((t) => t).toList();
    }
    if (book['video'] != null) {
      video = VideoData.fromJson(book['video']);
    }
  }

  bool get hasVideo => video != null;

}


class Tag {
  String id = '';
  String tagName = '';

  Tag.fromJson(dynamic tag) {
    if (tag == null || !tag.containsKey('id')) return;
    id = tag['id'];
    tagName = tag['tagName'];
  }
}