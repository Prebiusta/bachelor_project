import 'package:signfluent_phone/model/user.dart';

class AuthenticateResponse{
  final User user;
  final String message;
  final bool successful;

  AuthenticateResponse({required this.user, required this.message, required this.successful});

  factory AuthenticateResponse.fromJson(Map<String, dynamic> json) {
    return AuthenticateResponse(
        message: json['message'],
        successful: json['successful'],
        user: User.fromJson(json['user']));
  }
}