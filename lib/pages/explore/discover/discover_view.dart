import 'package:flutter/material.dart';

class DiscoverView extends StatefulWidget {
  const DiscoverView({super.key});

  @override
  State<StatefulWidget> createState() => _DiscoverViewState();

}

class _DiscoverViewState extends State<DiscoverView> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(child: Text("Discover"),)
    );
  }

}