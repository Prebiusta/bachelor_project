import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/screens/background.dart';
import 'package:signfluent_phone/src/screens/provider/components/body.dart';


class ProviderScreen extends StatelessWidget {
  const ProviderScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
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
