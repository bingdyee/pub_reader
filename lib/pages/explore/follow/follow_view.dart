import 'package:flutter/material.dart';

class FollowView extends StatefulWidget {
  const FollowView({super.key});

  @override
  State<StatefulWidget> createState() => _FollowViewState();

}

class _FollowViewState extends State<FollowView> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(child: Text("Follow"),)
    );
  }

}