import 'package:flutter/material.dart';
import 'package:signfluent_phone/components/custom_text_button.dart';
import 'package:signfluent_phone/screens/sign/components/view_model.dart';

class SignatureHome extends StatelessWidget {
  final SignViewModel viewModel;
  final Size size;

  const SignatureHome(
      {Key? key, required this.viewModel, required this.size})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return renderSignatureHome();
  }

  Column renderSignatureHome() {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        const Text('Waiting for signing requests'),
        SizedBox(height: size.height * 0.05),
        CustomTextButton(
          text: "REFRESH",
          onPressed: viewModel.fetchSignatureRequests,
        )
      ],
    );
  }
}
