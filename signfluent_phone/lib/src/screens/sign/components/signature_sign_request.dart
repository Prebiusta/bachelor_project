import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/components/error_view.dart';
import 'package:signfluent_phone/src/components/spinner.dart';
import 'package:signfluent_phone/src/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/src/screens/sign/components/signature_sign_response.dart';
import 'package:signfluent_phone/src/screens/sign/components/view_model.dart';

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
          return ErrorView(
              size: size,
              onConfirm: viewModel.confirmSignatureResponse,
              text: "No signatures required");
        }

        return const Spinner();
      },
    );
  }
}
