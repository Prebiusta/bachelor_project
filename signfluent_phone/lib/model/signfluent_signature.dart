class SignfluentSignature {
  final String signedHash;
  final String certificate;
  final String taskId;

  SignfluentSignature({required this.signedHash, required this.certificate, required this.taskId});

  Map<String, dynamic> toJson() => {
    'signedHash': signedHash,
    'certificate': certificate,
    'taskId': taskId,
  };

  @override
  String toString() {
    return 'SignfluentSignature{signedHash: $signedHash, certificate: $certificate, taskId: $taskId}';
  }
}