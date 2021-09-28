import 'package:flutter/material.dart';
import 'package:signfluent_phone/screens/provider/components/body.dart';


class ProviderScreen extends StatelessWidget {
  const ProviderScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Body(),
      resizeToAvoidBottomInset: false,
    );
  }
}
