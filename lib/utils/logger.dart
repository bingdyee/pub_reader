import 'dart:developer';
import 'package:flutter/foundation.dart';

class Logger {
  static bool isOpenLog = kDebugMode;

  static void println(String msg) {
    if (isOpenLog) debugPrint(msg);
  }

  static void logging(String msg, {StackTrace? stackTrace, int level = 0 }) {
    if (isOpenLog) log(msg, stackTrace: stackTrace, level: level);
  }

}