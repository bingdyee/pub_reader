import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';


class SearchInput extends StatelessWidget {
  const SearchInput({super.key});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 35.h,
      child: Row(children: [Expanded(child: Container(
          height: 35.h,
          decoration: BoxDecoration(
            color: Color.fromRGBO(100, 100, 100, 0.1),
            borderRadius: BorderRadius.circular(20)
          ),
          child: GestureDetector(
              onTap: () {
                // Navigator.pushNamed(context, RoutePath.search);
              },
              child: Row(children: [
              Padding(padding: EdgeInsets.only(left: 10.w), child: Icon(Icons.search,color: Colors.grey)),
              Text("【仙侠】仙人消失之后",style: TextStyle(color: Colors.grey, fontSize: 14.sp))
            ])
          ),
        )),
        12.horizontalSpace,
        GestureDetector(
          onTap: () {
            // Navigator.pushNamed(context, RoutePath.category);
          },
          child: Column(children: [
            Icon(Icons.widgets, color: Colors.grey, size: 20.sp),
            Text("分类", style: TextStyle(color: Colors.grey.shade600, fontSize: 10.sp)),
          ])
        )
      ])
    );
  }

}
