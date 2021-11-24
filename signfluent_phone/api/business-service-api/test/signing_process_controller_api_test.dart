import 'package:test/test.dart';
import 'package:business_service_api/business_service_api.dart';


/// tests for SigningProcessControllerApi
void main() {
  final instance = BusinessServiceApi().getSigningProcessControllerApi();

  group(SigningProcessControllerApi, () {
    // Submit approve document decision
    //
    //Future<BaseResponse> approveDocument(ApproveDocumentRequest approveDocumentRequest) async
    test('test approveDocument', () async {
      // TODO
    });

    // Assign approvers to a document
    //
    //Future<BaseResponse> assignApprovers(AssignApproversRequest assignApproversRequest) async
    test('test assignApprovers', () async {
      // TODO
    });

    // Get active approvers
    //
    //Future<BuiltList<User0>> getActiveApprovers() async
    test('test getActiveApprovers', () async {
      // TODO
    });

    // Returns document details for specified task
    //
    //Future<DocumentWithContent> getDocumentDetails1(ProcessIdRequest processIdRequest) async
    test('test getDocumentDetails1', () async {
      // TODO
    });

    // Returns documents needed User's approval
    //
    //Future<BuiltList<DocumentWithProcessResponse>> getDocumentsForApproval() async
    test('test getDocumentsForApproval', () async {
      // TODO
    });

    // Returns documents needed inspection
    //
    //Future<BuiltList<DocumentWithProcessResponse>> getDocumentsForInspection() async
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
    //Future<BaseResponse> inspectDocument(InspectDocumentRequest inspectDocumentRequest) async
    test('test inspectDocument', () async {
      // TODO
    });

    // Submits document signature
    //
    //Future<BaseResponse> submitSignature(SignfluentSignature signfluentSignature) async
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
