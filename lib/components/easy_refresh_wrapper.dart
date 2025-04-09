import 'package:easy_refresh/easy_refresh.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:pub_reader/common/values/colors.dart';

class EasyRefreshWrapper extends StatefulWidget {
  final Widget child;

  final Future Function()? onRefresh;

  final Future Function()? onLoad;

  final bool refreshOnStart;

  final Color? backgroundColor;

  const EasyRefreshWrapper({
    super.key,
    required this.child,
    this.onRefresh,
    this.onLoad,
    this.backgroundColor = Colors.white,
    this.refreshOnStart = false,
  });

  @override
  State<StatefulWidget> createState() => _EasyRefreshWrapperState();
}

class _EasyRefreshWrapperState extends State<EasyRefreshWrapper> {
  late EasyRefreshController _controller;

  @override
  void initState() {
    super.initState();
    _controller = EasyRefreshController(
      controlFinishRefresh: true,
      controlFinishLoad: true,
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return EasyRefresh.builder(
      controller: _controller,
      refreshOnStart: widget.refreshOnStart,
      refreshOnStartHeader: BuilderHeader(
        triggerOffset: 70,
        clamping: true,
        position: IndicatorPosition.above,
        processedDuration: Duration.zero,
        builder: (ctx, state) {
          return Container(
            width: double.infinity,
            height: ScreenUtil().screenHeight,
            color: Colors.grey.shade50,
            alignment: Alignment.topCenter,
            padding: EdgeInsets.only(top: 12.h),
            child: CircularProgressIndicator(
              strokeWidth: 3.r,
              valueColor: const AlwaysStoppedAnimation(AppColors.primary),
            ),
          );
        }
      ),
      header: ClassicHeader(
        dragText: "下拉刷新",
        armedText: "准备刷新",
        readyText: "刷新中...",
        processingText: "刷新中...",
        processedText: "刷新成功",
        messageText: '上次更新时间 %T',
      ),
      footer: ClassicFooter(
        noMoreText: "已经到底了",
        failedText: "加载失败",
        showMessage: false,
        showText: false,
        iconTheme: IconThemeData(color: Colors.red),
      ),
      onRefresh: () async {
        if (widget.onRefresh != null) {
          await widget.onRefresh!();
        }
        _controller.finishRefresh();
        _controller.resetFooter();
      },
      onLoad: () async {
        if (widget.onLoad != null) {
          await widget.onLoad!();
        }
        _controller.finishLoad(IndicatorResult.success);
      },
      childBuilder: (context, physics) => Container(
        color: widget.backgroundColor,
        width: double.infinity,
        child: SingleChildScrollView(
          scrollDirection: Axis.vertical,
          physics: physics,
          padding: EdgeInsets.all(12.r),
          child: widget.child,
        ),
      ),
    );
  }
}
