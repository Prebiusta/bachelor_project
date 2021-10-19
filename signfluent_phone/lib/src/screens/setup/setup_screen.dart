import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/screens/background.dart';
import 'package:signfluent_phone/src/screens/setup/components/body.dart';

class SetupScreen extends StatefulWidget {
  const SetupScreen({Key? key}) : super(key: key);

  @override
  _SetupScreenState createState() => _SetupScreenState();
}

class _SetupScreenState extends State<SetupScreen> {
  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return const Scaffold(
      body: Background(
        child: SingleChildScrollView(
            child: Body()
        ),
      ),
      resizeToAvoidBottomInset: false,
    );
  }
}
