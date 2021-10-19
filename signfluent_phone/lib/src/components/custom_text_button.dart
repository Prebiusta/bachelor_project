import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:signfluent_phone/src/constants.dart';

class CustomTextButton extends StatelessWidget {
  final String text;
  final VoidCallback onPressed;

  const CustomTextButton({Key? key, required this.text, required this.onPressed}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    
    return TextButton(
        onPressed: onPressed,
        child: Text(text, style: const TextStyle(color: sTextColor, fontSize: 18, fontWeight: FontWeight.w500)));
  }
}