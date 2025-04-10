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
  final data = [56.0, 35.0, 44.0, 58.0, 15.0, 20.0, 39.0];
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.all(15.r),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(12.r),
      ),
      child: Column(
        spacing: 20.h,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                "阅读时长分布",
                style: TextStyle(
                  fontWeight: FontWeight.w500,
                  fontSize: 15.sp,
                  color: Colors.grey.shade700,
                ),
              ),
              Container(
                padding: EdgeInsets.all(5.r),
                decoration: BoxDecoration(
                  color: Colors.grey.shade100,
                  borderRadius: BorderRadius.circular(20.r),
                ),
                child: Icon(
                  Icons.calendar_month,
                  color: Colors.grey.shade500,
                  size: 20.sp,
                ),
              ),
            ],
          ),
          AspectRatio(
            aspectRatio: 1.5,
            child: BarChart(
              BarChartData(
                maxY: 60,
                minY: 0,
                groupsSpace: 10,
                alignment: BarChartAlignment.spaceBetween,
                borderData: FlBorderData(
                  border: Border(
                    right: BorderSide.none,
                    left: BorderSide.none,
                    top: BorderSide(width: 0.5, color: Colors.grey.shade300),
                    bottom: BorderSide(width: 0.8, color: Colors.grey),
                  ),
                ),
                titlesData: FlTitlesData(
                  show: true,
                  leftTitles: const AxisTitles(
                    sideTitles: SideTitles(showTitles: false),
                  ),
                  topTitles: const AxisTitles(
                    sideTitles: SideTitles(showTitles: false),
                  ),
                  rightTitles: AxisTitles(
                    sideTitles: SideTitles(
                      showTitles: true,
                      interval: 20,
                      getTitlesWidget: getRightTitles,
                      reservedSize: 38,
                    ),
                  ),
                  bottomTitles: AxisTitles(
                    sideTitles: SideTitles(
                      showTitles: true,
                      getTitlesWidget: getBottomTitles,
                      reservedSize: 38,
                    ),
                  ),
                ),
                gridData: const FlGridData(show: true, drawVerticalLine: false),
                barGroups: List.generate(7, (index) {
                  return BarChartGroupData(
                    x: index,
                    barRods: [
                      BarChartRodData(
                        toY: data[index],
                        width: 32.w,
                        color: Colors.blueAccent.shade400,
                        borderRadius: BorderRadius.circular(4.r),
                      ),
                    ],
                  );
                }),
              ),
            ),
          ),
          Container(
            width: double.infinity,
            padding: EdgeInsets.symmetric(horizontal: 15.r, vertical: 6.r),
            decoration: BoxDecoration(
              color: Colors.blue.shade50,
              borderRadius: BorderRadius.circular(20.r),
            ),
            child: Text(
              "周一阅读最久 · 2小时13分钟",
              textAlign: TextAlign.center,
              style: TextStyle(
                color: Colors.black87,
                fontSize: 15.sp,
                fontWeight: FontWeight.w500,
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget getRightTitles(double value, TitleMeta meta) {
    return SideTitleWidget(
      meta: meta,
      space: 16,
      child: Text("${value.toInt()}m", maxLines: 1, style: TextStyle(fontSize: 10.sp, color: Colors.grey)),
    );
  }

  Widget getBottomTitles(double value, TitleMeta meta) {
    String text;
    switch (value.toInt()) {
      case 0:
        text = "一";
        break;
      case 1:
        text = "二";
        break;
      case 2:
        text = "三";
        break;
      case 3:
        text = "四";
        break;
      case 4:
        text = "五";
        break;
      case 5:
        text = "六";
        break;
      case 6:
        text = "日";
        break;
      default:
        text = '';
        break;
    }
    return SideTitleWidget(
      meta: meta,
      space: 16,
      child: Text(text, style: TextStyle(fontSize: 14.sp, color: Colors.grey)),
    );
  }
}
