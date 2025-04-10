import 'package:flutter/material.dart';

class SubscriptionView extends StatefulWidget {
  const SubscriptionView({super.key});

  @override
  State<StatefulWidget> createState() => _SubscriptionViewState();

}

class _SubscriptionViewState extends State<SubscriptionView> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(child: Text("Subscription"),)
    );
  }

}