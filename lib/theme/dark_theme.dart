import 'package:flutter/material.dart';
import 'package:flutter/services.dart';


ThemeData darkData = ThemeData(
  useMaterial3: true,
  brightness: Brightness.dark,
  primaryColor: Colors.red,
  appBarTheme: const AppBarTheme(
    systemOverlayStyle: SystemUiOverlayStyle.light,
  ),
  tabBarTheme: const TabBarTheme(
    labelColor: Colors.white,
  ),
  colorScheme: ColorScheme.dark(

  ),
);