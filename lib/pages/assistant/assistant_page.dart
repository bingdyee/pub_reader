import 'package:flutter/material.dart';

class AssistantPage extends StatefulWidget {
  const AssistantPage({super.key});

  @override
  State<StatefulWidget> createState() => _AssistantPageState();

}

class _AssistantPageState extends State<AssistantPage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(child: Text("Assistant"),)
    );
  }

}