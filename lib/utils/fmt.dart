
import 'package:intl/intl.dart';

String formatInt(int num, {fixed = 1}) {
  if (num > 9999) {
    return "${(num / 10000).toStringAsFixed(fixed)}万";
  }
  return "$num";
}

String formatNow({String fmt = "HH:mm"}) {
  // 'yyyy-MM-dd HH:mm'
  DateTime now = DateTime.now();
  DateFormat formatter = DateFormat(fmt);
  return formatter.format(now);
}