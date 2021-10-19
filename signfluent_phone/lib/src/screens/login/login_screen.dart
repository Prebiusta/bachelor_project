import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/screens/login/components/body.dart';


class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Body(),
      resizeToAvoidBottomInset: false,
    );
  }
}
