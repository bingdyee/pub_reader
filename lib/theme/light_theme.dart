import 'package:flutter/material.dart';
import 'package:flutter/services.dart';


ThemeData lightData = ThemeData(
  useMaterial3: true,
  primaryColor: Colors.red,
  scaffoldBackgroundColor: Colors.grey.shade50,
  appBarTheme: const AppBarTheme(
    systemOverlayStyle: SystemUiOverlayStyle.dark,
  ),
  tabBarTheme: const TabBarTheme(
    labelColor: Colors.black,
  ),
  badgeTheme: const BadgeThemeData(
    backgroundColor: Colors.red,
  ),
  colorScheme: ColorScheme.light(


  ),
);