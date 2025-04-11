class VideoData {
  String url = '';
  int height = 0;
  int width = 0;
  int size = 0;
  String thumbnail = '';

  VideoData(this.url, this.height, this.width, this.thumbnail, this.size);

  double get aspectRatio => height / width > 1 ? 1.4 : 0.8;

  VideoData.fromJson(dynamic data) {
    url = data['url'];
    height = data['height'];
    width = data['width'];
    thumbnail = data['thumbnail'];
    size = data['size'];
  }

}


class Video {
  String id = '';
  String title = '';
  int likeNum = 0;
  int commentNum = 0;
  int collectNum = 0;
  String author = '';
  String authorAvatar = '';
  int duration = 0;

  Video.fromJson(dynamic data) {
    if (data == null || !data.containsKey('id')) return;
    id = data['id'];
    title = data['title'];
    likeNum = data['likeNum'];
    commentNum = data['commentNum'];
    collectNum = data['collectNum'];
    author = data['author'];
    authorAvatar = data['authorAvatar'];
    duration = data['duration'];
  }

}

