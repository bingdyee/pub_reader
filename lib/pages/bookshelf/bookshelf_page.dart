import 'package:flutter/material.dart';

class BookshelfPage extends StatefulWidget {
  const BookshelfPage({super.key});

  @override
  State<StatefulWidget> createState() => _BookshelfPageState();

}

class _BookshelfPageState extends State<BookshelfPage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(child: Text("Bookshelf"),)
    );
  }

}