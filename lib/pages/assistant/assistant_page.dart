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
    );
  }
}
