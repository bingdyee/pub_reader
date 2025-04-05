import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:provider/provider.dart';
import 'app.dart';
import 'theme/theme_provider.dart';
import 'utils/requests.dart';
import 'utils/shared_storage.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  SharedStorageManager.initialize();
  Requests.initialize();

  SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp]);
  runApp(
    MultiProvider(
      providers: [ChangeNotifierProvider(create: (context) => ThemeProvider())],
      child: const ReaderApp(),
    ),
  );
}
