import 'package:flutter/material.dart';

class CurationView extends StatefulWidget {
  const CurationView({super.key});

  @override
  State<StatefulWidget> createState() => _CurationViewState();

}

class _CurationViewState extends State<CurationView> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(child: Text("Curation"),)
    );
  }

}