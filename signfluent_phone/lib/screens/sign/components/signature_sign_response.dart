import 'package:flutter/material.dart';
import 'package:signfluent_phone/components/custom_text_button.dart';
import 'package:signfluent_phone/components/success_view.dart';
import 'package:signfluent_phone/constants.dart';
import 'package:signfluent_phone/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/screens/sign/components/view_model.dart';

class SignatureSignResponse extends StatelessWidget {
  final SignViewModel viewModel;
  final Size size;
  final SignfluentSignatureRequest data;

  const SignatureSignResponse(
      {Key? key,
      required this.viewModel,
      required this.size,
      required this.data})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return buildSignatureResponseView();
  }

  FutureBuilder<String> buildSignatureResponseView() {
    return FutureBuilder<String>(
      future: viewModel.signingResponse,
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          return SuccessView(size: size, onConfirm: (){}, text: "text");
        } else if (snapshot.hasError) {
          return const Text("Hi");
        }

        return confirmSignatureView();
      },
    );
  }

  Column confirmSignatureView() {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        const Text('Signature awaits your signature'),
        SizedBox(height: size.height * 0.05),
        CustomTextButton(
          text: "SIGN",
          onPressed: () {
            viewModel.sign(data.taskId, data.hashToBeSigned);
          },
        )
      ],
    );
  }
}
