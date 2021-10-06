class SignfluentSignature {
  final String signedHash;
  final String certificate;

  SignfluentSignature({required this.signedHash, required this.certificate});

  Map<String, dynamic> toJson() => {
    'signedHash': signedHash,
    'certificate': certificate,
  };

  @override
  String toString() {
    return 'SignfluentSignature{signedHash: $signedHash, certificate: $certificate}';
  }
}