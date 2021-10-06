import 'package:flutter/material.dart';
import 'package:signfluent_phone/screens/sign/components/body.dart';

class SignScreen extends StatefulWidget {
  const SignScreen({Key? key}) : super(key: key);

  @override
  _SetupScreenState createState() => _SetupScreenState();
}

class _SetupScreenState extends State<SignScreen> {
  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return const Scaffold(
      body: Body(),
      resizeToAvoidBottomInset: false,
    );
  }
}
