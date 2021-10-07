import 'package:flutter/material.dart';
import 'package:signfluent_phone/components/custom_text_button.dart';
import 'package:signfluent_phone/components/spinner.dart';
import 'package:signfluent_phone/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/screens/sign/components/signature_sign_response.dart';
import 'package:signfluent_phone/screens/sign/components/view_model.dart';

class SignatureSignRequest extends StatelessWidget {
  final SignViewModel viewModel;
  final Size size;

  const SignatureSignRequest(
      {Key? key, required this.viewModel, required this.size})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return renderSignatureRequest();
  }

  FutureBuilder<SignfluentSignatureRequest> renderSignatureRequest() {
    return FutureBuilder<SignfluentSignatureRequest>(
      future: viewModel.signatureRequest,
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          return SignatureSignResponse(
              data: snapshot.data!, viewModel: viewModel, size: size);
        } else if (snapshot.hasError) {
          return buildSignatureErrorView(snapshot.error!);
        }

        return const Spinner();
      },
    );
  }

  Column buildSignatureErrorView(Object error) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Text(error.toString()),
        SizedBox(height: size.height * 0.05),
        CustomTextButton(
          text: "CONFIRM",
          onPressed: () {
            // viewModel.doStuff
          },
        )
      ],
    );
  }
}
