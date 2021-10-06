import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:signfluent_phone/components/custom_text_button.dart';
import 'package:signfluent_phone/components/heading.dart';
import 'package:signfluent_phone/components/rounded_input_field.dart';
import 'package:signfluent_phone/components/rounded_password_field.dart';
import 'package:signfluent_phone/components/spinner.dart';
import 'package:signfluent_phone/constants.dart';
import 'package:signfluent_phone/screens/background.dart';
import 'package:signfluent_phone/screens/login/components/view_model.dart';
import 'package:signfluent_phone/store/state/app_sate.dart';

class Body extends StatefulWidget {
  const Body({Key? key}) : super(key: key);

  @override
  _BodyState createState() => _BodyState();
}

class _BodyState extends State<Body> {
  String _email = "user@signfluent.com";
  String _password = "123456";

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return StoreConnector<AppState, LoginViewModel>(
      converter: (store) => LoginViewModel.fromStore(store),
      builder: (_, viewModel) => (viewModel.isLoading == false)
          ? buildView(viewModel)
          : const Background(child: Spinner()),
      onDidChange: (_, viewModel) {
        if (viewModel.loginError) {
          final snackBar = SnackBar(
            content: const Text('Login failed', style: TextStyle(color: sErrorText)),
            action: SnackBarAction(
              onPressed: () {
                // Some code to undo the change.
              },
              label: 'Confirm',
              textColor: sTextColor,
            ),
            duration: const Duration(seconds: 2),
          );

          ScaffoldMessenger.of(context).showSnackBar(snackBar);
        }
      },
    );
  }

  Background buildView(LoginViewModel viewModel) {
    Size size = MediaQuery.of(context).size;

    return Background(
        child: SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          const Heading(text: 'Authenticate'),
          SizedBox(height: size.height * 0.03),
          RoundedInputField(
            hintText: "Email",
            onChanged: (value) {
              setState(() {
                _email = value;
              });
            },
          ),
          RoundedPasswordField(
            onChanged: (value) {
              setState(() {
                _password = value;
              });
            },
          ),
          SizedBox(height: size.height * 0.02),
          CustomTextButton(
            text: "LOGIN",
            onPressed: () {
              FocusScope.of(context).unfocus();
              viewModel.login(_email, _password);
            },
          )
        ],
      ),
    ));
  }
}
