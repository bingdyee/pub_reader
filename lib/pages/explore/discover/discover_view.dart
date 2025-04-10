import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';
import 'package:pub_reader/common/api/book_api.dart';
import 'package:pub_reader/common/models/book_model.dart';
import 'package:pub_reader/components/easy_refresh_wrapper.dart';
import 'package:pub_reader/components/keep_alive_wrapper.dart';

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
              onTap: () {},
              child: Stack(
                children: [
                  bookCard(index),
                  Positioned(
                    top: 10.r,
                    right: 10.r,
                    child: Icon(
                      Icons.play_circle,
                      color: Colors.white60,
                      size: 26.r,
                    ),
                  ),
                ],
              ),
            );
          }),
        ),
      ),
    );
  }

  Widget bookCard(int index) {
    final height = (ScreenUtil().screenWidth / 2 - 30.r) * 1.5;
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
              child: Image.network(bookList[index].coverUrl, fit: BoxFit.cover),
            ),
            Positioned(
              left: 10.r,
              bottom: 10.r,
              child: Text("${bookList[index].score}分", style: TextStyle(color: Colors.white)),
            ),
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
              Text(
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
                  Text(
                    bookList[index].subCategoryName,
                    maxLines: 1,
                    style: TextStyle(color: Colors.grey.shade600),
                  ),
                  Row(
                    spacing: 2.r,
                    children: [
                      Icon(
                        Icons.favorite_outline,
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
