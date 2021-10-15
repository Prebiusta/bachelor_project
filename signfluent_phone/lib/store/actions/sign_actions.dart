import 'package:pointycastle/api.dart';
import 'package:redux/redux.dart';
import 'package:redux_thunk/redux_thunk.dart';
import 'package:signfluent_phone/service/rsa_service.dart';
import 'package:signfluent_phone/service/user_service.dart';
import 'package:signfluent_phone/service_location.dart';

RSAService _rsaService = getIt<RSAService>();

ThunkAction signContent(String content, String currentUserId) {
  return (Store store) async {
    Future(() async {
      // do all this on confirm
      // setLoading(true)
      String signature = await _rsaService.sign(content, currentUserId);
    });
  };
}
