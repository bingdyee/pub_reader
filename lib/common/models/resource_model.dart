import 'package:pub_reader/common/values/book_status.dart';
import 'package:pub_reader/common/values/resource_type.dart';

class ResourceModel {
  String id = '';
  String title = '';
  String thumbnail = '';
  int likeNum = 0;
  String author = '';
  String authorAvatar = '';
  double score = 0.0;
  double heightRatio = 4/3;
  String summary = '';
  BookStatus bookStatus = BookStatus.ongoing;
  ResourceType type = ResourceType.book;

  ResourceModel.fromJson(dynamic data) {
    if (data == null || !data.containsKey('id')) return;
    id = data['id'];
    title = data['title'];
    thumbnail = data['thumbnail'];
    likeNum = data['likeNum'];
    author = data['author'];
    authorAvatar = data['authorAvatar'];
    heightRatio = data['heightRatio'];
    if (data['type'] == 1) {
      type = ResourceType.video;
    } else if (data['type'] == 2) {
      type = ResourceType.book;
      summary = data['summary'];
      score = data['score'];
      bookStatus = data['bookStatus'] == 1 ? BookStatus.ongoing : BookStatus.completed;
    }
  }

}