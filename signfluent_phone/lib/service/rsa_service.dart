import 'dart:convert';

import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:pointycastle/api.dart';
import 'package:pointycastle/asymmetric/api.dart';
import 'package:rsa_encrypt/rsa_encrypt.dart';
import 'package:signfluent_phone/model/certificate_storage.dart';

class RSAService {
  final storage = const FlutterSecureStorage();

  Future<AsymmetricKeyPair<PublicKey, PrivateKey>> generateKeyPair() async {
    var helper = RsaKeyHelper();
    var computeRSAKeyPair = helper.computeRSAKeyPair(helper.getSecureRandom());
    return computeRSAKeyPair;
  }

  RSAPublicKey extractPublicKey(
      AsymmetricKeyPair<PublicKey, PrivateKey> asymmetricKeyPair) {
    return asymmetricKeyPair.publicKey as RSAPublicKey;
  }

  RSAPrivateKey extractPrivateKey(
      AsymmetricKeyPair<PublicKey, PrivateKey> asymmetricKeyPair) {
    return asymmetricKeyPair.privateKey as RSAPrivateKey;
  }

  String getPublicKeyPEM(
      AsymmetricKeyPair<PublicKey, PrivateKey> asymmetricKeyPair) {
    return RsaKeyHelper()
        .encodePublicKeyToPemPKCS1(extractPublicKey(asymmetricKeyPair));
  }

  String getPrivateKeyPEM(
      AsymmetricKeyPair<PublicKey, PrivateKey> asymmetricKeyPair) {
    return RsaKeyHelper()
        .encodePrivateKeyToPemPKCS1(extractPrivateKey(asymmetricKeyPair));
  }

  Future<void> storeCertificate(
      String userId, CertificateStorage certificateStorage) async {
    return storage.write(key: userId, value: jsonEncode(certificateStorage));
  }

  Future<CertificateStorage> getCertificateStorage(String userId) async {
    String certStorageJSON = (await storage.read(key: userId))!;
    if (certStorageJSON == "") {
      throw Exception('No certificate present');
    }
    return CertificateStorage.fromJson(jsonDecode(certStorageJSON));
  }

  Future<RSAPrivateKey> getPrivateKeyForUser(String userId) async {
    CertificateStorage certificateStorage = await getCertificateStorage(userId);
    return RsaKeyHelper()
        .parsePrivateKeyFromPem(certificateStorage.privateKeyPEM);
  }

  Future<String> sign(String content, String currentUserId) async {
    return RsaKeyHelper().sign(content, await getPrivateKeyForUser(currentUserId));
  }
}
