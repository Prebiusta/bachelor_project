import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/constants.dart';
import 'package:signfluent_phone/routes/routes.dart';
import 'package:signfluent_phone/screens/login/login_screen.dart';
import 'package:signfluent_phone/screens/provider/provider_screen.dart';
import 'package:signfluent_phone/screens/setup/setup_screen.dart';
import 'package:signfluent_phone/screens/sign/sign_screen.dart';
import 'package:signfluent_phone/store/reducer/app_reducer.dart';

import 'service_location.dart';
import 'store/state/app_sate.dart';

void main() {
  setupServiceLocator();
  runApp(const SignfluentApp());
}

class SignfluentApp extends StatefulWidget {
  const SignfluentApp({Key? key}) : super(key: key);

  @override
  _SignfluentAppState createState() => _SignfluentAppState();
}

class _SignfluentAppState extends State<SignfluentApp> {
  final store = Store<AppState>(appReducer,
      initialState: AppState.initial(),
      middleware: [thunkMiddleware, const NavigationMiddleware()]);

  @override
  Widget build(BuildContext context) {
    return StoreProvider(
        store: store,
        child: MaterialApp(
          debugShowCheckedModeBanner: false,
          title: 'Flutter Auth',
          theme: ThemeData(
              primaryColor: sPrimaryColor,
              scaffoldBackgroundColor: sPrimaryColor,
              fontFamily: 'RedHatDisplay',
              textTheme: Theme.of(context).textTheme.apply(
                    bodyColor: Colors.white,
                    displayColor: Colors.white,
                  )),
          navigatorKey: NavigatorHolder.navigatorKey,
          onGenerateRoute: _getRoute,
        ));
  }

  Route _getRoute(RouteSettings settings) {
    switch (settings.name) {
      case selectProviderBasePath:
        return _buildRoute(settings, const ProviderScreen());
      case loginBasePath:
        return _buildRoute(settings, const LoginScreen());
      case setupBasePath:
        return _buildRoute(settings, const SetupScreen());
      default:
        return _buildRoute(settings, const SignScreen());
    }
  }

  MaterialPageRoute _buildRoute(RouteSettings settings, Widget builder) {
    return MyCustomRoute(
      settings: settings,
      builder: (BuildContext context) => builder,
    );
  }
}

class MyCustomRoute<T> extends MaterialPageRoute<T> {
  MyCustomRoute(
      {required WidgetBuilder builder, required RouteSettings settings})
      : super(builder: builder, settings: settings);

  @override
  Widget buildTransitions(BuildContext context, Animation<double> animation,
          Animation<double> secondaryAnimation, Widget child) =>
      child;
}
