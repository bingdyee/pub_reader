import 'package:flutter/material.dart';
import 'dark_theme.dart';
import 'light_theme.dart';


class ThemeProvider with ChangeNotifier {

  ThemeMode _themeMode = ThemeMode.light;

  ThemeMode get themeMode => _themeMode;

  bool get isDarkMode => _themeMode == ThemeMode.dark;

  ThemeData get themeData => isDarkMode ? darkData : lightData;

  void toggleTheme() {
    _themeMode = isDarkMode ? ThemeMode.light : ThemeMode.dark;
    notifyListeners();
  }

}