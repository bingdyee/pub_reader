class Video {
  String id = '';
  String title = '';
  String thumbnail = '';
  int likeNum = 0;
  int commentNum = 0;
  int collectNum = 0;
  String author = '';
  String authorAvatar = '';
  String url = '';
  int duration = 0;
  double height = 0;
  double width = 0;
  double aspectRatio = 0;

  Video.fromJson(dynamic data) {
    if (data == null || !data.containsKey('id')) return;
    id = data['id'];
    title = data['title'];
    thumbnail = data['thumbnail'];
    likeNum = data['likeNum'];
    commentNum = data['commentNum'];
    collectNum = data['collectNum'];
    author = data['author'];
    authorAvatar = data['authorAvatar'];
    url = data['url'];
    duration = data['duration'];
    height = data['height'];
    width = data['width'];
    aspectRatio = height / width;
  }

}