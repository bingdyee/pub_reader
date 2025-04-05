import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'dart:ui' as ui;

class FocusTabIndicator extends Decoration {

  @override
  BoxPainter createBoxPainter([VoidCallback? onChanged]) {
    return _FocusBoxPainter();
  }

}

class _FocusBoxPainter extends BoxPainter {

  @override
  void paint(Canvas canvas, Offset offset, ImageConfiguration configuration) {
    final Rect rect = Rect.fromLTWH(offset.dx, offset.dy + configuration.size!.height / 2, 26.r, 10.r);
    final RRect rRect = RRect.fromRectAndCorners(rect,
        topLeft: Radius.circular(5.r),
        bottomRight: Radius.circular(5.r)
    );
    final Paint paint = Paint();
    paint.shader = ui.Gradient.linear(Offset(rRect.left, 0), Offset(rRect.right, 0), [Colors.red, Colors.red.shade100]);
    canvas.drawRRect(rRect, paint);
  }

}