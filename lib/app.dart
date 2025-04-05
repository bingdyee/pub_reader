import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'router.dart';
import 'theme/dark_theme.dart';
import 'theme/light_theme.dart';
import 'theme/theme_provider.dart';

Size get designSize {
  final firstView = WidgetsBinding.instance.platformDispatcher.views.first;
  // 逻辑边框
  final logicalShortestSize = firstView.physicalSize.shortestSide / firstView.devicePixelRatio;
  // 逻辑边长
  final logicalLongestSize = firstView.physicalSize.longestSide / firstView.devicePixelRatio;
  // 缩放比例
  const scaleFactor = 0.95;
  return Size(logicalShortestSize * scaleFactor, logicalLongestSize * scaleFactor);
}

class ReaderApp extends StatelessWidget {
  const ReaderApp({super.key});

  @override
  Widget build(BuildContext context) {

    return ScreenUtilInit(
        designSize: designSize,
        builder: (context, child) => MaterialApp(
            builder: FToastBuilder(),
            title: '阅读',
            debugShowCheckedModeBanner: false,
            theme: lightData,
            darkTheme: darkData,
            themeMode: Provider.of<ThemeProvider>(context).themeMode,
            navigatorKey: navigatorKey,
            onGenerateRoute: PageRoutes.generateRoute,
            initialRoute: RoutePath.tabs
        )
    );
  }

}
