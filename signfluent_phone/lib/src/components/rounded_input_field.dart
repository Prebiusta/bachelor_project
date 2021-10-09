import 'package:flutter/material.dart';
import 'package:signfluent_phone/src/components/text_field_container.dart';
import 'package:signfluent_phone/src/constants.dart';

class RoundedInputField extends StatelessWidget {
  final String hintText;
  final IconData icon;
  final ValueChanged<String> onChanged;
  const RoundedInputField({
    Key? key,
    required this.hintText,
    this.icon = Icons.person,
    required this.onChanged,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFieldContainer(
      child: TextField(
        onChanged: onChanged,
        cursorColor: sPrimaryColor,
        style: const TextStyle(color: sDarkText),
        decoration: InputDecoration(
          icon: Icon(
            icon,
            color: sPrimaryColor,
          ),
          hintText: hintText,
          hintStyle: const TextStyle(color: sDarkText),
          border: InputBorder.none,
        ),
      ),
    );
  }
}