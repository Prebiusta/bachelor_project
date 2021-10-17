import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:signfluent_phone/src/components/loading_view.dart';
import 'package:signfluent_phone/src/components/success_view.dart';
import 'package:signfluent_phone/src/screens/setup/components/view_model.dart';
import 'package:signfluent_phone/src/store/actions/setup_actions.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';

class Body extends StatefulWidget {
  const Body({Key? key}) : super(key: key);

  @override
  _BodyState createState() => _BodyState();
}

class _BodyState extends State<Body> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return StoreConnector<AppState, SetupViewModel>(
      onInit: (store) => store.dispatch(
          initiateSetup(store.state.userState.authenticationResponse!.user.id)),
      converter: (store) => SetupViewModel.fromStore(store),
      builder: (store, viewModel) => (viewModel.isLoading == false)
          ? SuccessView(
              size: size,
              onConfirm: viewModel.navigateToSignView,
              text: 'Device is ready to use')
          : LoadingView(
              size: size,
              text: "Setting Up",
            ),
      onDidChange: (_, viewModel) {},
    );
  }
}
