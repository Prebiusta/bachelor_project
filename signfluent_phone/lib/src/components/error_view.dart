import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/components/custom_text_button.dart';
import 'package:signfluent_phone/src/components/heading.dart';
import 'package:signfluent_phone/src/constants.dart';

class ErrorView extends StatelessWidget {
  final Size size;
  final VoidCallback onConfirm;
  final String text;
  final String buttonText;

  const ErrorView({Key? key, required this.size, required this.onConfirm, required this.text, this.buttonText = "CONTINUE"}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        SizedBox(height: size.height * 0.18),
        Heading(text: text),
        SizedBox(height: size.height * 0.07),
        const Icon(Icons.close_rounded, size: 140, color: sTextColor),
        SizedBox(height: size.height * 0.03),
        CustomTextButton(
          text: buttonText,
          onPressed: onConfirm,
        )
      ],
    );
  }
}
