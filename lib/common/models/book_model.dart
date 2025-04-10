class Book {
  String id = '';
  String title = '';
  String author = '';
  String summary = '';
  String coverUrl = '';
  String categoryName = '';
  String subCategoryName = '';
  int wordNum = 0;
  int bookStatus = 1;
  int readNum = 0;
  int collectNum = 0;
  double score = 0.0;
  String videoUrl = '';
  List<String> tags = [];

  Book.fromJson(dynamic book) {
    if (book == null || !book.containsKey('id')) return;
    id = book['id'] ?? '';
    title = book['title'] ?? '';
    author = book['author'] ?? '';
    summary = book['summary'] ?? '';
    coverUrl = book['coverUrl'] ?? '';
    categoryName = book['categoryName'] ?? '';
    subCategoryName = book['subCategoryName'] ?? '';
    wordNum = book['wordNum'] ?? 0;
    bookStatus = book['bookStatus'] ?? 1;
    collectNum = book['collectNum'] ?? 0;
    readNum = book['readNum'] ?? 0;
    score = book['score'] ?? 0.0;
    videoUrl = book['videoUrl'] ?? '';
    List<dynamic>? tagList = book['tags'];
    if (tagList != null && tagList.isNotEmpty) {
      tags = tagList.map<String>((t) => t).toList();
    }
  }

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