import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/constants.dart';

class SignfluentText extends StatelessWidget {
  final String text;

  const SignfluentText({Key? key, required this.text}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: const TextStyle(color: sTextColor, fontSize: 20),
    );
  }
}
