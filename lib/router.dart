import 'package:flutter/material.dart';
import 'package:pub_reader/pages/tabs.dart';

import 'pages/video/video_page.dart';


GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();

class RoutePath {
  static const String tabs = "/";
  static const String search = "/search";
  static const String category = "/category";
  static const String player = "/player";
  static const String bookDetail = "/bookDetail";
  static const String reader = "/reader";

}


class PageRoutes {

  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch(settings.name) {
      case RoutePath.tabs:
        return pageRoute(TabsPage(), settings: settings);
      case RoutePath.player:
        return pageRoute(VideoPage(), settings: settings);
    }
    return pageRoute(Center(child: Text("")));
  }

  static MaterialPageRoute pageRoute(Widget widget, {
    RouteSettings? settings,
    bool? fullscreenDialog,
    bool? maintainState,
    bool? allowSnapshotting
  }) {
    return MaterialPageRoute(
        builder: (context) => widget,
        settings: settings,
        fullscreenDialog: fullscreenDialog ?? false,
        maintainState: maintainState ?? true,
        allowSnapshotting: allowSnapshotting ?? true
    );
  }

}