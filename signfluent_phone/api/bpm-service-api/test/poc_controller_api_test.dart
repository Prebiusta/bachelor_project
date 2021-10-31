import 'package:test/test.dart';
import 'package:bpm_service_api/bpm_service_api.dart';


/// tests for PocControllerApi
void main() {
  final instance = BpmServiceApi().getPocControllerApi();

  group(PocControllerApi, () {
    // fetchDocument
    //
    //Future<JsonObject> fetchDocumentUsingPOST(String taskID) async
    test('test fetchDocumentUsingPOST', () async {
      // TODO
    });

    // startProcess
    //
    //Future<String> startProcessUsingGET() async
    test('test startProcessUsingGET', () async {
      // TODO
    });

    // uploadDocumentId
    //
    //Future uploadDocumentIdUsingPOST(String docID, String taskID) async
    test('test uploadDocumentIdUsingPOST', () async {
      // TODO
    });

    // uploadDocument
    //
    //Future<String> uploadDocumentUsingGET(Document document) async
    test('test uploadDocumentUsingGET', () async {
      // TODO
    });

  });
}
