import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:lazy_load_indexed_stack/lazy_load_indexed_stack.dart';
import 'package:pub_reader/pages/assistant/assistant_page.dart';
import 'package:pub_reader/pages/bookshelf/bookshelf_page.dart';
import 'package:pub_reader/pages/explore/explore_page.dart';
import 'package:pub_reader/pages/home/home_page.dart';
import 'package:pub_reader/pages/profile/profile_page.dart';

class TabsPage extends StatefulWidget {
  const TabsPage({super.key});

  @override
  State<StatefulWidget> createState() => _TabsPageState();
}

class _TabsPageState extends State<TabsPage> {
  int _currentPageIndex = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      bottomNavigationBar: BottomNavigationBar(
        onTap: (index) {
          setState(() {
            _currentPageIndex = index;
          });
        },
        type: BottomNavigationBarType.fixed,
        currentIndex: _currentPageIndex,
        selectedItemColor: Theme.of(context).primaryColor,
        showUnselectedLabels: true,
        selectedFontSize: 12.r,
        unselectedFontSize: 12.r,
        iconSize: 24.r,
        items: const [
          BottomNavigationBarItem(
            icon: ImageIcon(AssetImage("assets/icons/explore.png")),
            label: "热门",
          ),
          BottomNavigationBarItem(
            icon: ImageIcon(AssetImage("assets/icons/bookshelf.png")),
            label: "书架",
          ),
          BottomNavigationBarItem(
            icon: ImageIcon(AssetImage("assets/icons/ai_assistant.png")),
            label: "问书",
          ),
          BottomNavigationBarItem(
            icon: Badge(
              child: ImageIcon(AssetImage("assets/icons/person.png")),
            ),
            label: "我的",
          ),
        ],
      ),
      body: LazyLoadIndexedStack(
        index: _currentPageIndex,
        children: const [
          HomePage(),
          BookshelfPage(),
          ExplorePage(),
          ProfilePage(),
        ],
      ),
    );
  }
}
