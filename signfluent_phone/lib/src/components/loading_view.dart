import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/components/heading.dart';
import 'package:signfluent_phone/src/components/spinner.dart';

class LoadingView extends StatelessWidget {
  final Size size;
  final String text;

  const   LoadingView(
      {Key? key,
      required this.size,
      this.text = "Loading"})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        SizedBox(height: size.height * 0.05),
        Heading(text: text),
        SizedBox(height: size.height * 0.07),
        const Spinner(),
      ],
    );
  }
}
