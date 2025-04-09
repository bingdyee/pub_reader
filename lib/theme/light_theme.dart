import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:pub_reader/common/values/colors.dart';


ThemeData lightData = ThemeData(
  useMaterial3: true,
  primaryColor: AppColors.primary,
  scaffoldBackgroundColor: Colors.grey.shade50,
  appBarTheme: const AppBarTheme(
    systemOverlayStyle: SystemUiOverlayStyle.dark,
  ),
  tabBarTheme: const TabBarTheme(
    labelColor: Colors.black,
  ),
  badgeTheme: const BadgeThemeData(
    backgroundColor: AppColors.primary,
  ),
  colorScheme: ColorScheme.light(


  ),
);