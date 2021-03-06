// @dart=2.14

import 'dart:ffi';

import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/service_location.dart';
import 'package:signfluent_phone/src/signfluent_app.dart';
import 'package:signfluent_phone/src/service/bearer_token_service.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  setupServiceLocator();
  runApp(const App());
}

class App extends StatefulWidget {
  const App({Key? key}) : super(key: key);

  @override
  _AppState createState() => _AppState();
}

class _AppState extends State<App> {
  final Future<FirebaseApp> _initialization = Firebase.initializeApp();
  final BearerTokenService _bearerTokenService = getIt<BearerTokenService>();


  @override
  void dispose() {
    _bearerTokenService.deleteBearerToken();
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      // Initialize FlutterFire:
      future: _initialization,
      builder: (context, snapshot) {
        // Check for errors
        if (snapshot.hasError) {
          return const Center(
            child: Text(
              "No firebase config found",
              textDirection: TextDirection.ltr,
            ),
          );
        }

        // Once complete, show your application
        if (snapshot.connectionState == ConnectionState.done) {
          return const SignfluentApp();
        }

        // Otherwise, show something whilst waiting for initialization to complete
        return const Center(
            child: Text("Loading...", textDirection: TextDirection.ltr));
      },
    );
  }
}
