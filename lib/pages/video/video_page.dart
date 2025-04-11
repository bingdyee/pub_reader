import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:preload_page_view/preload_page_view.dart';
import 'package:pub_reader/common/api/book_api.dart';
import 'package:pub_reader/common/models/book_model.dart';

import 'video_player_widget.dart';

class VideoPage extends StatefulWidget {
  const VideoPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _VideoPageState();
  }
}

class _VideoPageState extends State<VideoPage> {
  late PreloadPageController _pageController;

  List<Book> books = [];

  int _currentIndex = 0;

  final List<GlobalKey<VideoPlayerWidgetState>> _itemKeys = [];

  int page = 10 + Random().nextInt(40);

  @override
  void initState() {
    super.initState();
    _pageController = PreloadPageController();
    WidgetsBinding.instance.addPostFrameCallback((timestamp) {
      var args = ModalRoute.of(context)?.settings.arguments;
      if (args is Book) {
        books.add(args);
      }
    });
    _loadData(isInit: true);
  }

  Future<void> _loadData({isInit = false}) async {
    final bookList = await BookApi.getVideoBookList(page);
    setState(() {
      books.addAll(bookList);
      if (isInit) {
        _itemKeys.clear();
        _itemKeys.addAll(
          List.generate(
            books.length,
                (_) => GlobalKey<VideoPlayerWidgetState>(),
          ),
        );
      } else {
        _itemKeys.addAll(
          List.generate(
            books.length,
                (_) => GlobalKey<VideoPlayerWidgetState>(),
          ),
        );
      }
    });
  }

  @override
  void dispose() {
    _pageController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return AnnotatedRegion(
      value: SystemUiOverlayStyle.light,
      child: Scaffold(
        backgroundColor: Colors.transparent,
        body: Stack(
          alignment: Alignment.topCenter,
          children: [
            PreloadPageView.builder(
              controller: _pageController,
              scrollDirection: Axis.vertical,
              itemCount: books.length,
              preloadPagesCount: 1,
              onPageChanged: (index) {
                _currentIndex = index;
                setState(() {});
                if (index == books.length - 1) {
                  page += 1;
                  _loadData();
                }
                for (int i = 0; i < _itemKeys.length; i++) {
                  if (i != index) {
                    // 暂停非当前 item
                    _itemKeys[i].currentState?.pause();
                  } else if (i == index) {
                    // 恢复当前 item
                    _itemKeys[i].currentState?.resume();
                  }
                }
              },
              itemBuilder: (context, index) {
                return VideoPlayerWidget(
                  key: _itemKeys[index],
                  book: books[index],
                  autoPlay: index == _currentIndex,
                );
              },
            ),
            Positioned(
              child: Padding(
                padding: EdgeInsets.only(
                  top: MediaQuery.of(context).padding.top,
                  left: 15.w,
                  right: 15.w,
                ),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    GestureDetector(
                      onTap: () {
                        Navigator.pop(context);
                      },
                      child: Icon(
                        Icons.chevron_left,
                        size: 40.r,
                        color: Colors.white,
                      ),
                    ),
                    ImageIcon(
                      AssetImage("assets/icons/search.png"),
                      size: 30.r,
                      color: Colors.white,
                    ),
                  ],
                ),
              ),
            ),
            Positioned(
              bottom: ScreenUtil().bottomBarHeight,
              child: Container(
                height: 35.h,
                width: ScreenUtil().screenWidth - 30.w,
                padding: EdgeInsets.symmetric(horizontal: 18.w),
                decoration: BoxDecoration(
                  color: Color.fromRGBO(100, 100, 100, 0.3),
                  borderRadius: BorderRadius.circular(20),
                ),
                child: GestureDetector(
                  onTap: () {
                    showModalBottomSheet(
                      context: context,
                      enableDrag: true,
                      isScrollControlled: true,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.only(
                          topLeft: Radius.circular(10.r),
                          topRight: Radius.circular(10.r),
                        ),
                      ),
                      builder: (context) {
                        return SingleChildScrollView(
                          child: AnimatedPadding(
                            padding: MediaQuery.of(context).viewInsets,
                            duration: const Duration(milliseconds: 1),
                            child: Padding(
                              padding: EdgeInsets.all(15.r),
                              child: Column(
                                spacing: 12.h,
                                children: [
                                  TextFormField(
                                    autofocus: true,
                                    cursorColor: Colors.red,
                                    style: TextStyle(fontSize: 16.sp),
                                    minLines: 2,
                                    maxLines: null,
                                    decoration: InputDecoration(
                                      hintText: "留下你的想法吧",
                                      hintStyle: TextStyle(
                                        color: Colors.grey,
                                        fontSize: 16.sp,
                                      ),
                                      contentPadding: EdgeInsets.all(15.r),
                                      filled: true,
                                      fillColor: Colors.grey.shade100,
                                      focusedBorder: OutlineInputBorder(
                                        borderRadius: BorderRadius.circular(
                                          15.r,
                                        ),
                                        borderSide: BorderSide.none,
                                      ),
                                      border: OutlineInputBorder(
                                        borderRadius: BorderRadius.circular(
                                          15.r,
                                        ),
                                        borderSide: BorderSide.none,
                                      ),
                                    ),
                                  ),
                                  Row(
                                    mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                    children: [
                                      Row(
                                        spacing: 24.w,
                                        children: [
                                          Icon(
                                            Icons.alternate_email_outlined,
                                            size: 27.r,
                                            color: Colors.grey.shade600,
                                          ),
                                          Icon(
                                            Icons.emoji_emotions_outlined,
                                            size: 27.r,
                                            color: Colors.grey.shade600,
                                          ),
                                          Icon(
                                            Icons.image_outlined,
                                            size: 27.r,
                                            color: Colors.grey.shade600,
                                          ),
                                          Icon(
                                            Icons.add_circle_outline,
                                            size: 27.r,
                                            color: Colors.grey.shade600,
                                          ),
                                        ],
                                      ),
                                      TextButton(
                                        onPressed: () {
                                          Navigator.pop(context);
                                        },
                                        style: ButtonStyle(

                                          backgroundColor:
                                          WidgetStateProperty.all(
                                            Colors.red,
                                          ),
                                          padding: WidgetStateProperty.all(
                                            EdgeInsets.symmetric(
                                              horizontal: 0.r,
                                              vertical: 0.r,
                                            ),
                                          ),
                                        ),
                                        child: Text(
                                          "发送",
                                          style: TextStyle(
                                            fontSize: 16.sp,
                                            color: Colors.white,
                                          ),
                                        ),
                                      ),
                                    ],
                                  ),
                                ],
                              ),
                            ),
                          ),
                        );
                      },
                    );
                  },
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Text(
                        "说点什么...",
                        style: TextStyle(color: Colors.grey, fontSize: 14.sp),
                      ),
                      Row(
                        spacing: 12.w,
                        children: [
                          Icon(Icons.alternate_email, color: Colors.grey, size: 26.r),
                          Icon(Icons.mood, color: Colors.grey, size: 26.r),
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
              ),
            ),
          ],
        ),
      ),
    );
  }
}
