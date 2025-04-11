import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';
import 'package:pub_reader/common/api/book_api.dart';
import 'package:pub_reader/common/models/book_model.dart';
import 'package:pub_reader/components/easy_refresh_wrapper.dart';
import 'package:pub_reader/components/keep_alive_wrapper.dart';
import 'package:pub_reader/router.dart';

class DiscoverView extends StatefulWidget {
  const DiscoverView({super.key});

  @override
  State<StatefulWidget> createState() => _DiscoverViewState();
}

class _DiscoverViewState extends State<DiscoverView> {
  final List<Book> bookList = [];

  @override
  Widget build(BuildContext context) {
    return KeepAliveWrapper(
      child: EasyRefreshWrapper(
        refreshOnStart: true,
        onRefresh: () async {
          final books = await BookApi.getBookList();
          bookList.addAll(books);
          setState(() {});
        },
        onLoad: () async {
          final books = await BookApi.getBookList();
          bookList.addAll(books);
          setState(() {});
        },
        backgroundColor: Colors.grey.shade100,
        child: StaggeredGrid.count(
          crossAxisCount: 2,
          mainAxisSpacing: 10.r,
          crossAxisSpacing: 10.r,
          children: List.generate(bookList.length, (index) {
            return GestureDetector(
              onTap: () {
                if (bookList[index].hasVideo) {
                  Navigator.pushNamed(context, RoutePath.player, arguments: bookList[index]);
                }
              },
              child: bookCard(index)
            );
          }),
        ),
      ),
    );
  }

  Widget bookCard(int index) {
    final height =
        (ScreenUtil().screenWidth / 2 - 30.r) *
        (bookList[index].hasVideo ? bookList[index].video!.aspectRatio : 1.5);
    final cover =
        bookList[index].hasVideo
            ? bookList[index].video!.thumbnail
            : bookList[index].coverUrl;
    return Column(
      children: [
        Stack(
          children: [
            Container(
              width: double.infinity,
              height: height,
              clipBehavior: Clip.hardEdge,
              decoration: BoxDecoration(
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(4.r),
                  topRight: Radius.circular(4.r),
                ),
              ),
              child: Image.network(cover, fit: BoxFit.cover),
            ),
            Positioned(
              top: 10.r,
              right: 10.r,
              child: bookList[index].hasVideo
                  ? Icon(
                Icons.play_circle,
                color: Colors.white60,
                size: 26.r,
              )
                  : Text(
                "${bookList[index].score}分",
                style: TextStyle(color: Colors.white),
              ),
            )
          ],
        ),
        Container(
          decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.only(
              bottomLeft: Radius.circular(4.r),
              bottomRight: Radius.circular(4.r),
            ),
          ),
          padding: EdgeInsets.all(8.r),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                bookList[index].title,
                maxLines: 2,
                overflow: TextOverflow.ellipsis,
                style: TextStyle(fontWeight: FontWeight.w500, fontSize: 16.sp),
              ),
              bookList[index].hasVideo
                  ? const SizedBox()
                  : Text(
                    bookList[index].summary,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                    style: TextStyle(
                      color: Colors.grey.shade600,
                      fontWeight: FontWeight.w500,
                      fontSize: 12.sp,
                    ),
                  ),
              6.verticalSpace,
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  bookList[index].hasVideo
                      ? Row(
                        spacing: 5.r,
                        children: [
                          CircleAvatar(
                            backgroundColor: Colors.grey.shade300,
                            backgroundImage: NetworkImage(
                              bookList[index].authorAvatar,
                            ),
                            radius: 12.r,
                          ),
                          Container(
                            constraints: BoxConstraints(maxWidth: 68.w),
                            child: Text(
                              bookList[index].author,
                              maxLines: 1,
                              overflow: TextOverflow.ellipsis,
                              style: TextStyle(color: Colors.grey.shade600),
                            ),
                          ),
                        ],
                      )
                      : Container(
                        decoration: BoxDecoration(
                          color: Colors.blue.shade50,
                          borderRadius: BorderRadius.circular(5.r),
                        ),
                        padding: EdgeInsets.symmetric(
                          horizontal: 4.r,
                          vertical: 2.r,
                        ),
                        child: Text(
                          bookList[index].subCategoryName,
                          maxLines: 1,
                          style: TextStyle(color: Colors.blue),
                        ),
                      ),
                  Row(
                    spacing: 2.r,
                    children: [
                      ImageIcon(
                        AssetImage("assets/icons/hot_outline.png"),
                        size: 18.r,
                        color: Colors.grey.shade600,
                      ),
                      Text(
                        "${bookList[index].collectNum}",
                        style: TextStyle(color: Colors.grey.shade600),
                      ),
                    ],
                  ),
                ],
              ),
            ],
          ),
        ),
      ],
    );
  }
}
