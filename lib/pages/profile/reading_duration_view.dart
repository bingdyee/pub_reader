import 'dart:math';

import 'package:fl_chart/fl_chart.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:pub_reader/common/values/colors.dart';

class ReadingDurationView extends StatefulWidget {
  const ReadingDurationView({super.key});

  @override
  State<StatefulWidget> createState() {
    return _ReadingDurationViewState();
  }
}

class _ReadingDurationViewState extends State<ReadingDurationView> {
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.symmetric(vertical: 15.r),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(12.r),
      ),
      child: Column(
        spacing: 20.h,
        children: [
          Container(
            width: double.infinity,
            margin: EdgeInsets.symmetric(horizontal: 15.r),
            padding: EdgeInsets.symmetric(horizontal: 15.r, vertical: 6.r),
            decoration: BoxDecoration(
              color: Colors.blue.shade100,
              borderRadius: BorderRadius.circular(20.r)
            ),
            child: Text(
              "周一阅读最久 · 2小时13分钟", textAlign: TextAlign.center,
              style: TextStyle(color: Colors.black87, fontSize: 15.sp, fontWeight: FontWeight.w500),
            ),
          ),
          AspectRatio(
            aspectRatio: 1.55,
            child: BarChart(
              BarChartData(
                groupsSpace: 10,
                borderData: FlBorderData(
                  border: const Border(
                    top: BorderSide.none,
                    right: BorderSide.none,
                    left: BorderSide.none,
                    bottom: BorderSide(width: 1),
                  ),
                ),
                barGroups: List.generate(7, (index) {
                  return BarChartGroupData(
                    x: index + 1,
                    barRods: [
                      BarChartRodData(
                        toY: Random().nextDouble() * 60,
                        width: 32.w,
                        color: AppColors.primary,
                        borderRadius: BorderRadius.circular(4.r),
                      ),
                    ],
                  );
                }),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
