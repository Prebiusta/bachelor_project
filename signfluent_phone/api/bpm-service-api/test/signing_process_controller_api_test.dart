import 'package:test/test.dart';
import 'package:bpm_service_api/bpm_service_api.dart';


/// tests for SigningProcessControllerApi
void main() {
  final instance = BpmServiceApi().getSigningProcessControllerApi();

  group(SigningProcessControllerApi, () {
    // Submit approve document decision
    //
    //Future<String> approveDocument(ApproverDocumentRequest approveDocumentRequest) async
    test('test approveDocument', () async {
      // TODO
    });

    // Assign approvers to a document
    //
    //Future<String> assignApprovers(AssignApproversRequest assignApproversRequest) async
    test('test assignApprovers', () async {
      // TODO
    });

    // Get active approvers
    //
    //Future<BuiltList<User>> getActiveApprovers() async
    test('test getActiveApprovers', () async {
      // TODO
    });

    // Returns document details for specified task
    //
    //Future<DocumentWithContent> getDocumentDetails(ProcessIdRequest taskIdRequest) async
    test('test getDocumentDetails', () async {
      // TODO
    });

    // Returns documents needed User's approval
    //
    //Future<BuiltList<DocumentResponse>> getDocumentsForApproval() async
    test('test getDocumentsForApproval', () async {
      // TODO
    });

    // Returns documents needed inspection
    //
    //Future<BuiltList<DocumentResponse>> getDocumentsForInspection() async
    test('test getDocumentsForInspection', () async {
      // TODO
    });

    // Returns signature request for authenticated user
    //
    //Future<SignfluentSignatureRequest> getSignatureRequest() async
    test('test getSignatureRequest', () async {
      // TODO
    });

    // Inspect document and assign approvers
    //
    //Future<String> inspectDocument(InspectDocumentRequest inspectDocumentRequest) async
    test('test inspectDocument', () async {
      // TODO
    });

    // Submits document signature
    //
    //Future<String> submitSignature(SignfluentSignature signfluentSignature) async
    test('test submitSignature', () async {
      // TODO
    });

    // Uploads a document
    //
    //Future uploadDocument(UploadDocumentRequest uploadDocumentRequest) async
    test('test uploadDocument', () async {
      // TODO
    });

  });
}
