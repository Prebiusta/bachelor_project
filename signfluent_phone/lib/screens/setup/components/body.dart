import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:signfluent_phone/components/custom_text_button.dart';
import 'package:signfluent_phone/components/heading.dart';
import 'package:signfluent_phone/components/spinner.dart';
import 'package:signfluent_phone/screens/background.dart';
import 'package:signfluent_phone/screens/setup/components/view_model.dart';
import 'package:signfluent_phone/store/actions/setup_actions.dart';
import 'package:signfluent_phone/store/state/app_sate.dart';
import 'package:stacked/stacked.dart';

import '../../../constants.dart';

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
    return StoreConnector<AppState, SetupViewModel>(
      onInit: (store) => store.dispatch(initiateSetup(store.state.userState.authenticationResponse!.user.id)),
      converter: (store) => SetupViewModel.fromStore(store),
      builder: (store, viewModel) => (viewModel.isLoading == false)
          ? buildView(viewModel)
          : buildSettingUpView(),
      onDidChange: (_, viewModel) {

      },
    );
  }

  Background buildSettingUpView() {
    Size size = MediaQuery.of(context).size;
    return Background(
      child: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            SizedBox(height: size.height * 0.05),
            const Heading(text: 'Setting Up'),
            SizedBox(height: size.height * 0.07),
            const Spinner(),
          ],
        ),
      ),
    );
  }


  Background buildView(SetupViewModel viewModel) {
    Size size = MediaQuery.of(context).size;
    return Background(
      child: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            SizedBox(height: size.height * 0.18),
            const Heading(text: 'Device is ready to use'),
            SizedBox(height: size.height * 0.07),
            const Icon(Icons.check_rounded, size: 140, color: sTextColor),
            SizedBox(height: size.height * 0.03),
            CustomTextButton(
              text: "CONTINUE",
              onPressed: viewModel.navigateToSignView,
            )
          ],
        ),
      ),
    );
  }
}
