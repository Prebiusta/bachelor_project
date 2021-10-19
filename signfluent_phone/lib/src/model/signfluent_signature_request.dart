class SignfluentSignatureRequest {
  final String hashToBeSigned;
  final String taskId;

  SignfluentSignatureRequest(
      {required this.hashToBeSigned, required this.taskId});

  factory SignfluentSignatureRequest.fromJson(Map<String, dynamic> json) {
    return SignfluentSignatureRequest(
        taskId: json['taskId'], hashToBeSigned: json['hash']);
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SignfluentSignatureRequest &&
          runtimeType == other.runtimeType &&
          hashToBeSigned == other.hashToBeSigned &&
          taskId == other.taskId;

  @override
  int get hashCode => hashToBeSigned.hashCode ^ taskId.hashCode;
}
