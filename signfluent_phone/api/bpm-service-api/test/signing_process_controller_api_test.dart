import 'package:test/test.dart';
import 'package:bpm_service_api/bpm_service_api.dart';


/// tests for SigningProcessControllerApi
void main() {
  final instance = BpmServiceApi().getSigningProcessControllerApi();

  group(SigningProcessControllerApi, () {
    // Get active approvers
    //
    //Future<BuiltList<User>> getActiveApprovers() async
    test('test getActiveApprovers', () async {
      // TODO
    });

    // Returns document details for specified task
    //
    //Future<DocumentWithContent> getDocumentDetails(TaskIdRequest taskIdRequest) async
    test('test getDocumentDetails', () async {
      // TODO
    });

    // Returns documents needed inspection
    //
    //Future<BuiltList<DocumentResponse>> getDocumentsForInspection() async
    test('test getDocumentsForInspection', () async {
      // TODO
    });

    // Inspect document and assign approvers
    //
    //Future<String> inspectDocument(InspectDocumentRequest inspectDocumentRequest) async
    test('test inspectDocument', () async {
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
