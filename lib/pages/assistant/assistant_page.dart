import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class AssistantPage extends StatefulWidget {
  const AssistantPage({super.key});

  @override
  State<StatefulWidget> createState() => _AssistantPageState();
}

class _AssistantPageState extends State<AssistantPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey.shade100,
      appBar: AppBar(
        backgroundColor: Colors.grey.shade100,
        title: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            ImageIcon(AssetImage("assets/icons/menu.png"), size: 24.r),
            Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "AI 问书",
                  style: TextStyle(
                    fontSize: 16.sp,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                Text(
                  "《海边的卡夫卡》",
                  style: TextStyle(
                    fontSize: 12.sp,
                    fontWeight: FontWeight.w500,
                    color: Colors.grey.shade600,
                  ),
                ),
              ],
            ),
            ImageIcon(
              AssetImage("assets/icons/new_conversation.png"),
              size: 24.r,
            ),
          ],
        ),
      ),
      body: history()
    );
  }

  Widget history() {
    return Column(
      children: [
        Expanded(
          child: Padding(
            padding: EdgeInsets.symmetric(horizontal: 20.r, vertical: 15.r),
            child: Column(
              spacing: 15.h,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: [
                    Container(
                      constraints: BoxConstraints(
                        maxWidth: ScreenUtil().screenWidth * 0.85,
                      ),
                      padding: EdgeInsets.symmetric(
                        horizontal: 20.r,
                        vertical: 15.r,
                      ),
                      decoration: BoxDecoration(
                        color: Colors.blue.shade100,
                        borderRadius: BorderRadius.circular(12.r),
                      ),
                      child: Text(
                        "人物介绍",
                        style: TextStyle(fontSize: 16.sp),
                      ),
                    ),
                  ],
                ),
                Container(
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(12.r),
                  ),
                  padding: EdgeInsets.all(20.r),
                  child: Column(
                    spacing: 15.h,
                    children: [
                      Text(
                        "控制室边上是个平台，下方则是一个巨型洞穴，里头一束光也没有，萨德伯里中微子观测站就坐落其中。世界上最大的亚克力球体就挂在洞穴中央，它的直径有十二米，或者“将近四十英尺”，里面装满了从加拿大原子能有限公司借来的一千一百吨重水。",
                        style: TextStyle(fontSize: 16.sp),
                      ),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Container(
                            padding: EdgeInsets.symmetric(
                              horizontal: 12.r,
                              vertical: 8.r,
                            ),
                            decoration: BoxDecoration(
                              color: Colors.grey.shade100,
                              borderRadius: BorderRadius.circular(20.r),
                            ),
                            child: Row(
                              spacing: 4.r,
                              children: [
                                Icon(
                                  Icons.open_in_new,
                                  color: Colors.grey.shade600,
                                  size: 20.r,
                                ),
                                Text(
                                  "分享图片",
                                  style: TextStyle(
                                    fontSize: 14.sp,
                                    height: 1.2,
                                    color: Colors.grey.shade600,
                                  ),
                                ),
                              ],
                            ),
                          ),
                          Icon(Icons.more_vert, color: Colors.grey, size: 24.r),
                        ],
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }

}
