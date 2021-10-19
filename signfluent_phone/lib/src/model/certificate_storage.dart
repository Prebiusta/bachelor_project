class CertificateStorage {
  final String privateKeyPEM;
  final String x509PEM;

  CertificateStorage({required this.privateKeyPEM, required this.x509PEM});

  factory CertificateStorage.fromJson(Map<String, dynamic> json) {
    return CertificateStorage(
      privateKeyPEM: json['privateKeyPEM'],
      x509PEM: json['x509PEM'],
    );
  }

  Map<String, dynamic> toJson() => {
    'privateKeyPEM': privateKeyPEM,
    'x509PEM': x509PEM,
  };

  @override
  String toString() {
    return 'CertificateStorage{privateKeyPEM: $privateKeyPEM, x509PEM: $x509PEM}';
  }
}
