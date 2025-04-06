import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';
import 'package:pub_reader/common/mocked_data.dart';
import 'package:pub_reader/common/models/resource_model.dart';
import 'package:pub_reader/common/values/book_status.dart';
import 'package:pub_reader/common/values/resource_type.dart';
import 'package:pub_reader/components/easy_refresh_wrapper.dart';
import 'package:pub_reader/components/keep_alive_wrapper.dart';
import 'package:pub_reader/utils/fmt.dart';

class HotView extends StatefulWidget {
  const HotView({super.key});

  @override
  State<StatefulWidget> createState() => _HotViewState();
}

class _HotViewState extends State<HotView> {
  List<ResourceModel> resourceList = [];

  @override
  void initState() {
    super.initState();
    resourceList = MockedData.hotResourceList;
  }

  @override
  Widget build(BuildContext context) {
    return KeepAliveWrapper(
      child: EasyRefreshWrapper(
        refreshOnStart: true,
        onRefresh: () async {
          setState(() {});
        },
        onLoad: () async {
          setState(() {});
        },
        backgroundColor: Colors.grey.shade50,
        child: StaggeredGrid.count(
          crossAxisCount: 2,
          mainAxisSpacing: 10.r,
          crossAxisSpacing: 10.r,
          children: List.generate(resourceList.length, (index) {
            return _buildResourceCard(index);
          }),
        ),
      ),
    );
  }

  Widget _buildResourceCard(int index) {
    final height = (ScreenUtil().screenWidth / 2 - 30.r) * resourceList[index].heightRatio;
    Widget tag;
    List<Widget> footer;
    final content = [
      Text(
        resourceList[index].title,
        maxLines: 2,
        overflow: TextOverflow.ellipsis,
        style: TextStyle(fontWeight: FontWeight.w500, fontSize: 16.sp),
      ),
    ];
    if (resourceList[index].type == ResourceType.video) {
      tag = Icon(Icons.play_circle, color: Colors.white60, size: 26.r);
      footer = [
        Row(
          spacing: 5.r,
          children: [
            CircleAvatar(
              backgroundColor: Colors.grey.shade300,
              backgroundImage: NetworkImage(resourceList[index].authorAvatar),
              radius: 12.r,
            ),
            Container(
              constraints: BoxConstraints(maxWidth: 68.w),
              child: Text(
                resourceList[index].author,
                maxLines: 1,
                overflow: TextOverflow.ellipsis,
                style: TextStyle(color: Colors.grey.shade600),
              ),
            ),
          ],
        ),
        Row(
          spacing: 2.r,
          children: [
            Icon(
              Icons.favorite_outline,
              size: 17.r,
              color: Colors.grey.shade600,
            ),
            Text(
              formatInt(resourceList[index].likeNum),
              style: TextStyle(color: Colors.grey.shade600),
            ),
          ],
        ),
      ];
    } else {
      tag = Text(
        "${resourceList[index].score}分",
        style: TextStyle(color: Colors.white),
      );
      footer = [
        Text(
          "家族修仙",
          maxLines: 1,
          style: TextStyle(color: Colors.grey.shade600),
        ),
        Container(
          decoration: BoxDecoration(
            color: Colors.red.shade50,
            borderRadius: BorderRadius.circular(5.r),
          ),
          padding: EdgeInsets.symmetric(horizontal: 4.r, vertical: 2.r),
          child: Text(
            resourceList[index].bookStatus == BookStatus.ongoing
                ? "连载中"
                : "已完结",
            style: TextStyle(color: Colors.red),
          ),
        ),
      ];
      content.add(
        Text(
          resourceList[index].summary,
          maxLines: 2,
          overflow: TextOverflow.ellipsis,
          style: TextStyle(
            color: Colors.grey.shade600,
            fontWeight: FontWeight.w500,
            fontSize: 12.sp,
          ),
        ),
      );
    }

    return GestureDetector(
      onTap: () {},
      child: Stack(
        children: [
          Column(
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
                child: Image.network(
                  resourceList[index].thumbnail,
                  fit: BoxFit.cover,
                ),
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
                  spacing: 6.h,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    ...content,
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: footer,
                    ),
                  ],
                ),
              ),
            ],
          ),
          Positioned(top: 10.r, right: 10.r, child: tag),
        ],
      ),
    );
  }
}
