import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:signfluent_phone/src/components/custom_text_button.dart';
import 'package:signfluent_phone/src/components/heading.dart';
import 'package:signfluent_phone/src/components/loading_view.dart';
import 'package:signfluent_phone/src/components/rounded_input_field.dart';
import 'package:signfluent_phone/src/components/spinner.dart';
import 'package:signfluent_phone/src/screens/background.dart';
import 'package:signfluent_phone/src/screens/provider/components/view_model.dart';
import 'package:signfluent_phone/src/store/actions/provider_actions.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';

class Body extends StatefulWidget {
  const Body({Key? key}) : super(key: key);

  @override
  _BodyState createState() => _BodyState();
}

class _BodyState extends State<Body> {
  String _baseURL = "http://10.0.2.2:8003";

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return StoreConnector<AppState, ProviderViewModel>(
      onInit: (store) => store.dispatch(verifyExistingURL()),
      converter: (store) => ProviderViewModel.fromStore(store),
      builder: (context, viewModel) => (viewModel.isLoading == false)
          ? buildView(viewModel, size)
          : LoadingView(size: size),
      onDidChange: (_, viewModel) {},
    );
  }

  Column buildView(ProviderViewModel viewModel, Size size) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        const Heading(text: 'Select Provider'),
        SizedBox(height: size.height * 0.03),
        RoundedInputField(
          hintText: "Provider URL",
          icon: Icons.person,
          onChanged: (value) {
            setState(() {
              _baseURL = value;
            });
          },
        ),
        SizedBox(height: size.height * 0.02),
        CustomTextButton(
          text: "CONFIRM",
          onPressed: () {
            viewModel.pingProvider(_baseURL);
          },
        ),
        SizedBox(height: size.height * 0.02),
        (viewModel.isError == true) ? Text(viewModel.error, style: const TextStyle(color: Colors.red)) : const Text("")
      ],
    );
  }
}
