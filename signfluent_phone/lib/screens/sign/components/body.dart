import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:signfluent_phone/components/custom_text_button.dart';
import 'package:signfluent_phone/components/spinner.dart';
import 'package:signfluent_phone/model/signfluent_signature_request.dart';
import 'package:signfluent_phone/screens/sign/components/signature_home.dart';
import 'package:signfluent_phone/screens/sign/components/signature_sign_request.dart';
import 'package:signfluent_phone/screens/sign/components/view_model.dart';
import 'package:signfluent_phone/store/state/app_sate.dart';

class Body extends StatefulWidget {
  const Body({Key? key}) : super(key: key);

  @override
  _BodyState createState() => _BodyState();
}

class _BodyState extends State<Body> {
  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return StoreConnector<AppState, SignViewModel>(
      converter: (store) => SignViewModel.fromStore(store),
      builder: (_, viewModel) => (viewModel.signatureRequest == null)
          ? SignatureHome(viewModel: viewModel, size: size)
          : SignatureSignRequest(viewModel: viewModel, size: size),
      onDidChange: (_, viewModel) {},
    );
  }
}
