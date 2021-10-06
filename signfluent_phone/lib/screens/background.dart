import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:signfluent_phone/constants.dart';

class Background extends StatelessWidget {
  final Widget child;
  static const IconData copyright =
      IconData(0xe198, fontFamily: 'MaterialIcons');

  const Background({Key? key, required this.child}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return SizedBox(
      height: size.height,
      width: double.infinity,
      child: Stack(
        alignment: Alignment.center,
        children: <Widget>[
          Positioned(
            top: 30,
            child: SvgPicture.asset(
              "assets/images/logo.svg",
              width: size.width * 0.95,
            ),
          ),
          Positioned(
              bottom: 30,
              child: RichText(
                textAlign: TextAlign.center,
                text: const TextSpan(
                  children: [
                    WidgetSpan(
                      alignment: PlaceholderAlignment.middle,
                      child: Icon(copyright, size: 12, color: sTextColor),
                    ),
                    TextSpan(
                      text: " Signfluent 2021 | 1.0.0",
                      style: TextStyle(color: sTextColor),
                    ),
                  ],
                ),
              )),
          Container(
            alignment: Alignment.center,
            child: child,
          )
        ],
      ),
    );
  }
}
