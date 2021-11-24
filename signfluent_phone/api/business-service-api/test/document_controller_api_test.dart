import 'package:test/test.dart';
import 'package:business_service_api/business_service_api.dart';


/// tests for DocumentControllerApi
void main() {
  final instance = BusinessServiceApi().getDocumentControllerApi();

  group(DocumentControllerApi, () {
    // Returns all available documents
    //
    //Future<BuiltList<DocumentResponse>> getAllDocuments() async
    test('test getAllDocuments', () async {
      // TODO
    });

    // Returns details for selected documents
    //
    //Future<DocumentDetailsResponse> getDocumentDetails(String documentId) async
    test('test getDocumentDetails', () async {
      // TODO
    });

    // Returns documents own by authenticated user
    //
    //Future<BuiltList<DocumentResponse>> getOwnDocuments() async
    test('test getOwnDocuments', () async {
      // TODO
    });

  });
}
