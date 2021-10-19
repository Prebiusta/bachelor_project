import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:flutter_redux_navigation/flutter_redux_navigation.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/src/constants.dart';
import 'package:signfluent_phone/src/routes/routes.dart';
import 'package:signfluent_phone/src/screens/login/login_screen.dart';
import 'package:signfluent_phone/src/screens/provider/provider_screen.dart';
import 'package:signfluent_phone/src/screens/setup/setup_screen.dart';
import 'package:signfluent_phone/src/screens/sign/sign_screen.dart';
import 'package:signfluent_phone/src/store/actions/actions.dart';
import 'package:signfluent_phone/src/store/reducer/app_reducer.dart';
import 'package:signfluent_phone/src/store/state/app_sate.dart';


class SignfluentApp extends StatefulWidget {
  const SignfluentApp({Key? key}) : super(key: key);

  @override
  _SignfluentAppState createState() => _SignfluentAppState();
}

class _SignfluentAppState extends State<SignfluentApp> {
  final store = Store<AppState>(appReducer,
      initialState: AppState.initial(),
      middleware: [thunkMiddleware, const NavigationMiddleware()]);

  late Stream<String> _tokenStream;

  void setToken(String? token) {
    print('FCM Token: $token');
    store.dispatch(SetFCMTokenAction(token));
  }

  @override
  void initState() {
    super.initState();
    FirebaseMessaging.instance
        .getToken(
        vapidKey:
        'BEj6qO9PzaLbQs56VyCWNtMsrIr4Q50kPo8MZ8WP9DGnmeEnmQwfJTMRT-S7W5IUgDZyeBxFPtWt7eeQogeh2pE')
        .then(setToken);
    _tokenStream = FirebaseMessaging.instance.onTokenRefresh;
    _tokenStream.listen(setToken);
  }

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
