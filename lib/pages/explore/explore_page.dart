import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:pub_reader/common/values/colors.dart';
import 'follow/follow_view.dart';
import 'discover/discover_view.dart';
import 'library/library_view.dart';

class ExplorePage extends StatefulWidget {
  const ExplorePage({super.key});

  @override
  State<StatefulWidget> createState() => _ExplorePageState();
}

class _ExplorePageState extends State<ExplorePage>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 3, initialIndex: 1, vsync: this);
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        surfaceTintColor: Colors.white,
        title: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            ImageIcon(AssetImage("assets/icons/menu.png"), size: 24.r),
            TabBar(
              controller: _tabController,
              dividerHeight: 0,
              tabAlignment: TabAlignment.center,
              overlayColor: WidgetStateColor.transparent,
              indicator: UnderlineTabIndicator(
                borderRadius: BorderRadius.circular(2.r),
                borderSide: const BorderSide(
                  width: 3,
                  color: AppColors.primary,
                ),
              ),
              labelStyle: TextStyle(
                fontSize: 18.sp,
                fontWeight: FontWeight.w500,
              ),
              unselectedLabelStyle: TextStyle(
                fontSize: 18.sp,
                fontWeight: FontWeight.w500,
                color: Colors.grey.shade600,
              ),
              tabs: [Tab(text: "关注"), Tab(text: "发现"), Tab(text: "阅读")],
            ),
            ImageIcon(AssetImage("assets/icons/search_s.png"), size: 24.r),
          ],
        ),
      ),
      body: TabBarView(
        controller: _tabController,
        children: const [FollowView(), DiscoverView(), LibraryView()],
      ),
    );
  }
}
