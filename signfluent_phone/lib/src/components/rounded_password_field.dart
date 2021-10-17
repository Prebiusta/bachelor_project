import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/components/text_field_container.dart';
import 'package:signfluent_phone/src/constants.dart';

class RoundedPasswordField extends StatelessWidget {
  final ValueChanged<String> onChanged;

  const RoundedPasswordField({
    Key? key,
    required this.onChanged,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFieldContainer(
      child: TextField(
        obscureText: true,
        onChanged: onChanged,
        cursorColor: sPrimaryColor,
        style: const TextStyle(color: sDarkText),
        decoration: const InputDecoration(
          hintText: "Password",
          hintStyle: TextStyle(color: sDarkText),
          icon: Icon(
            Icons.lock,
            color: sPrimaryColor,
          ),
          suffixIcon: Icon(
            Icons.visibility,
            color: sPrimaryColor,
          ),
          border: InputBorder.none,
        ),
      ),
    );
  }
}
