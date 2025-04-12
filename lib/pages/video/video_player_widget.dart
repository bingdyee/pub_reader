import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:pub_reader/utils/fmt.dart';
import 'package:pub_reader/common/models/book_model.dart';
import 'package:video_player/video_player.dart';

class VideoPlayerWidget extends StatefulWidget {
  const VideoPlayerWidget({
    super.key,
    required this.book,
    this.autoPlay = false,
  });

  final Book book;

  final bool autoPlay;

  @override
  State<StatefulWidget> createState() {
    return VideoPlayerWidgetState();
  }
}

class VideoPlayerWidgetState extends State<VideoPlayerWidget> {
  late VideoPlayerController _playerController;
  bool isVertical = true;

  @override
  void initState() {
    super.initState();
    initializePlayer();
  }

  Future<void> initializePlayer() async {
    isVertical = widget.book.video!.height / widget.book.video!.width > 1.7;
    _playerController = VideoPlayerController.networkUrl(
      Uri.parse(widget.book.video!.url),
    );
    _playerController.setLooping(true);
    await _playerController.initialize();
    setState(() {});
    if (widget.autoPlay) {
      _playerController.play();
    }
  }

  @override
  void dispose() {
    _playerController.dispose();
    super.dispose();
  }

  void pause() {
    setState(() {
      _playerController.pause();
    });
  }

  void resume() {
    setState(() {
      _playerController.play();
    });
  }

  void playOrPause() {
    setState(() {
      _playerController.value.isPlaying
          ? _playerController.pause()
          : _playerController.play();
    });
  }

  @override
  Widget build(BuildContext context) {
    final double paddingBottom = ScreenUtil().bottomBarHeight + 45.h;
    final videoHeight =
        isVertical
            ? double.infinity
            : ScreenUtil().screenWidth *
                widget.book.video!.height /
                widget.book.video!.width;
    final videoWidth = double.infinity;
    final Widget player = AspectRatio(
      aspectRatio: _playerController.value.aspectRatio,
      child: VideoPlayer(_playerController),
    );
    return Stack(
      children: [
        GestureDetector(
          onTap: playOrPause,
          child: Container(
            color: Colors.black,
            padding: EdgeInsets.zero,
            width: ScreenUtil().screenWidth,
            height: ScreenUtil().screenHeight - paddingBottom,
            child: Center(
              child: SizedBox(
                height: videoHeight,
                width: videoWidth,
                child:
                    _playerController.value.isInitialized
                        ? player
                        : Image.network(
                          widget.book.video!.thumbnail,
                          fit: BoxFit.fill,
                        ),
              ),
            ),
          ),
        ),
        _buildVideoInfo(paddingBottom),
        _buildControls(paddingBottom),
      ],
    );
  }

  Widget _buildVideoInfo(double paddingBottom) {
    return Positioned(
      bottom: paddingBottom,
      right: 12.r,
      left: 12.r,
      child: Column(
        spacing: 5.h,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            crossAxisAlignment: CrossAxisAlignment.end,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                spacing: 10.h,
                children: [
                  Row(
                    spacing: 10.r,
                    children: [
                      Container(
                        width: 40.r,
                        height: 54.r,
                        clipBehavior: Clip.hardEdge,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(4.r),
                        ),
                        child: Image.network(
                          widget.book.coverUrl,
                          fit: BoxFit.cover,
                        ),
                      ),
                      Container(
                        constraints: BoxConstraints(
                          maxWidth: ScreenUtil().screenWidth * 0.7,
                        ),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          spacing: 8.h,
                          children: [
                            Row(
                              children: [
                                Text(
                                  widget.book.title,
                                  maxLines: 1,
                                  overflow: TextOverflow.ellipsis,
                                  style: TextStyle(
                                    color: Colors.white,
                                    fontSize: 16.sp,
                                    fontWeight: FontWeight.w500,
                                  ),
                                ),
                                Icon(Icons.chevron_right, color: Colors.white),
                              ],
                            ),
                            Container(
                              decoration: BoxDecoration(
                                color: Colors.white.withAlpha(70),
                                borderRadius: BorderRadius.circular(5.r),
                              ),
                              padding: EdgeInsets.symmetric(
                                horizontal: 4.r,
                                vertical: 2.r,
                              ),
                              child: Text(
                                widget.book.subCategoryName,
                                maxLines: 1,
                                style: TextStyle(color: Colors.white),
                              ),
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    width: ScreenUtil().screenWidth * 0.78,
                    child: Text(
                      widget.book.summary,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: TextStyle(color: Colors.white, fontSize: 15.sp),
                    ),
                  ),
                ],
              ),
              Column(
                spacing: 16.h,
                children: [
                  Column(
                    children: [
                      ImageIcon(
                        AssetImage("assets/icons/like.png"),
                        color: Colors.white,
                        size: 32.r,
                      ),
                      Text(
                        formatInt(widget.book.readNum),
                        style: TextStyle(
                          fontSize: 14.sp,
                          color: Colors.white,
                          fontWeight: FontWeight.normal,
                        ),
                      ),
                    ],
                  ),
                  GestureDetector(
                    onTap: () {
                      showModalBottomSheet(
                        context: context,
                        enableDrag: true,
                        isScrollControlled: true,
                        backgroundColor: Colors.white,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.only(
                            topLeft: Radius.circular(10.r),
                            topRight: Radius.circular(10.r),
                          ),
                        ),
                        builder: (context) {
                          return SafeArea(
                            child: Container(
                              height: ScreenUtil().screenHeight * 0.68,
                              padding: EdgeInsets.all(12.r),
                              child: Column(
                                spacing: 12.h,
                                children: [
                                  Row(
                                    mainAxisAlignment:
                                        MainAxisAlignment.spaceBetween,
                                    children: [
                                      Text(
                                        "共 ${widget.book.commentNum} 条评论",
                                        style: TextStyle(
                                          fontSize: 16.sp,
                                          fontWeight: FontWeight.w500,
                                        ),
                                      ),
                                      GestureDetector(
                                        onTap: () {
                                          Navigator.pop(context);
                                        },
                                        child: Icon(Icons.close),
                                      ),
                                    ],
                                  ),
                                  Expanded(
                                    child: SingleChildScrollView(
                                      child: Column(
                                        spacing: 24.h,
                                        children: List.generate(10, (index) {
                                          return _buildComment();
                                        }),
                                      ),
                                    ),
                                  ),
                                  Container(
                                    height: 35.h,
                                    width: ScreenUtil().screenWidth - 30.w,
                                    padding: EdgeInsets.symmetric(
                                      horizontal: 18.w,
                                    ),
                                    decoration: BoxDecoration(
                                      color: Colors.grey.shade100,
                                      borderRadius: BorderRadius.circular(20),
                                    ),
                                    child: Row(
                                      mainAxisAlignment:
                                          MainAxisAlignment.spaceBetween,
                                      children: [
                                        Text(
                                          "说点什么...",
                                          style: TextStyle(
                                            color: Colors.grey,
                                            fontSize: 14.sp,
                                          ),
                                        ),
                                        Row(
                                          spacing: 12.w,
                                          children: [
                                            Icon(
                                              Icons.alternate_email,
                                              color: Colors.grey,
                                              size: 26.r,
                                            ),
                                            Icon(
                                              Icons.mood,
                                              color: Colors.grey,
                                              size: 26.r,
                                            ),
                                            Icon(
                                              Icons.image_outlined,
                                              color: Colors.grey,
                                              size: 26.r,
                                            ),
                                          ],
                                        ),
                                      ],
                                    ),
                                  ),
                                ],
                              ),
                            ),
                          );
                        },
                      );
                    },
                    child: Column(
                      children: [
                        ImageIcon(
                          AssetImage("assets/icons/comment.png"),
                          color: Colors.white,
                          size: 32.r,
                        ),
                        Text(
                          formatInt(widget.book.commentNum),
                          style: TextStyle(
                            fontSize: 14.sp,
                            color: Colors.white,
                            fontWeight: FontWeight.normal,
                          ),
                        ),
                      ],
                    ),
                  ),
                  Column(
                    children: [
                      ImageIcon(
                        AssetImage("assets/icons/favorite.png"),
                        color: Colors.white,
                        size: 32.r,
                      ),
                      Text(
                        formatInt(widget.book.readNum),
                        style: TextStyle(
                          fontSize: 14.sp,
                          color: Colors.white,
                          fontWeight: FontWeight.normal,
                        ),
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      ImageIcon(
                        AssetImage("assets/icons/share.png"),
                        color: Colors.white,
                        size: 32.r,
                      ),
                      Text(
                        formatInt(widget.book.collectNum),
                        style: TextStyle(
                          fontSize: 14.sp,
                          color: Colors.white,
                          fontWeight: FontWeight.normal,
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ],
          ),
          SizedBox(
            height: 6.sp,
            width: ScreenUtil().screenWidth,
            child: VideoProgressIndicator(
              _playerController,
              allowScrubbing: true,
              colors: const VideoProgressColors(
                playedColor: Colors.white70,
                backgroundColor: Colors.white60,
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildControls(double paddingBottom) {
    if (_playerController.value.isInitialized &&
        !_playerController.value.isPlaying) {
      return Positioned(
        top: 0,
        bottom: paddingBottom,
        left: 0,
        right: 0,
        child: GestureDetector(
          onTap: playOrPause,
          child: Icon(
            Icons.play_circle_outline,
            color: Colors.white60,
            size: 68.r,
          ),
        ),
      );
    }
    return const SizedBox();
  }

  Widget _buildComment() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          spacing: 10.w,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            CircleAvatar(
              backgroundColor: Colors.grey.shade300,
              backgroundImage: NetworkImage(widget.book.authorAvatar),
              radius: 20.r,
            ),
            Column(
              spacing: 5.w,
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  "收藏侠",
                  style: const TextStyle(
                    fontWeight: FontWeight.bold,
                    color: Colors.grey,
                  ),
                ),
                ConstrainedBox(
                  constraints: BoxConstraints(
                    maxWidth: ScreenUtil().screenWidth * 0.81,
                  ),
                  child: Column(
                    spacing: 5.w,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "扑上去了吗?扑上去了吗?扑上去了吗?扑上去了吗?扑上去了吗?扑上去了吗?扑上去了吗?扑上去了吗?",
                        softWrap: true,
                        style: TextStyle(fontSize: 14.sp),
                      ),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Row(
                            spacing: 15.w,
                            children: [
                              Text(
                                "40分钟前 · 中国台湾",
                                style: TextStyle(
                                  fontSize: 12.sp,
                                  color: Colors.grey.shade600,
                                ),
                              ),
                              Text(
                                "回复",
                                style: TextStyle(
                                  fontSize: 12.sp,
                                  fontWeight: FontWeight.w500,
                                ),
                              ),
                            ],
                          ),
                          Row(
                            spacing: 20.w,
                            children: [
                              Row(
                                spacing: 5.w,
                                children: [
                                  ImageIcon(
                                    AssetImage("assets/icons/like.png"),
                                    size: 18.r,
                                    color: Colors.grey.shade600,
                                  ),
                                  Text(
                                    "3.8万",
                                    style: TextStyle(
                                      fontSize: 12.sp,
                                      fontWeight: FontWeight.normal,
                                      color: Colors.grey.shade600,
                                    ),
                                  ),
                                ],
                              ),
                              ImageIcon(
                                AssetImage("assets/icons/dislike.png"),
                                size: 18.r,
                                color: Colors.grey.shade600,
                              ),
                            ],
                          ),
                        ],
                      ),
                      3.verticalSpace,
                      GestureDetector(
                        onTap: () {},
                        child: Row(
                          children: [
                            Container(
                              width: 25.w,
                              decoration: BoxDecoration(
                                border: Border.all(
                                  color: Colors.grey,
                                  width: 0.3.h,
                                ),
                              ),
                            ),
                            Text(
                              "\t\t\t展开828条回复",
                              style: TextStyle(
                                color: Colors.grey.shade600,
                                fontWeight: FontWeight.w500,
                              ),
                            ),
                            Icon(
                              Icons.expand_more,
                              color: Colors.grey.shade600,
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ],
        ),
      ],
    );
  }
}
