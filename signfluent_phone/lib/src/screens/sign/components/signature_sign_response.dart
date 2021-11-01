import 'package:bpm_service_api/bpm_service_api.dart';
import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/components/error_view.dart';
import 'package:signfluent_phone/src/components/signfluent_text.dart';
import 'package:signfluent_phone/src/components/success_view.dart';
import 'package:signfluent_phone/src/constants.dart';
import 'package:signfluent_phone/src/screens/sign/components/view_model.dart';
import 'package:slide_to_confirm/slide_to_confirm.dart';

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
          return SuccessView(
              size: size,
              onConfirm: viewModel.confirmSignatureResponse,
              text: "Successfully Signed");
        } else if (snapshot.hasError) {
          return ErrorView(
              size: size,
              onConfirm: viewModel.confirmSignatureResponse,
              text: "Signing Failed");
        }

        return confirmSignatureView();
      },
    );
  }

  Column confirmSignatureView() {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        const SignfluentText(
          text: 'Document awaits your signature',
        ),
        SizedBox(height: size.height * 0.15),
        ConfirmationSlider(
          foregroundColor: sDarkText,
          text: "SIGN",
          backgroundColor: Colors.white,
          onConfirmation: () =>
              viewModel.sign(data.processId!, data.contentToBeSigned!),
        ),
      ],
    );
  }
}
